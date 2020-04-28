package com.tracktopell.dao.builder.ejb3;

import com.tracktopell.dao.builder.FormatString;
import com.tracktopell.dao.builder.metadata.Column;
import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.metadata.EmbeddeableColumn;
import com.tracktopell.dao.builder.metadata.ReferenceTable;
import com.tracktopell.dao.builder.metadata.Table;
import com.tracktopell.util.VersionUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * com.tracktopell.dao.builder.jpa.DTOBeanBuilder
 * @author aegonzalez
 */
public class DTOBeanBuilder {
	
	public static void buildMappingDTOsForJPABeans(DBTableSet dbSet, String dtoPackage, String dtoPackageBeanMember, String jpaPackageBeanMember, String basePath,boolean flatDTOs)
			throws Exception {
		String fileName;
		File baseDir = null;
		File dirSourceFile = null;
		File sourceFile = null;

		FileOutputStream fos = null;
		PrintStream ps = null;
		BufferedReader br = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");		
		Properties vp=VersionUtil.loadVersionProperties();
		System.err.println("====================== [ com.tracktopell.dao.builder.jpa.DTOBeanBuilder.buildMappingDTOsForJPABeans ]========================");
		
		
		Enumeration<String> tableNames = dbSet.getTableNames();
		ArrayList<Table> tablesForGeneration = new ArrayList<Table>();
		while (tableNames.hasMoreElements()) {
			Table simpleTable = dbSet.getTable(tableNames.nextElement());
			if (!simpleTable.isManyToManyTableWinthMoreColumns()) {
				//System.err.println("-->> + " + simpleTable.getName());
				tablesForGeneration.add(simpleTable);

				Iterator<Column> itFKC = simpleTable.getSortedColumnsForJPA();
				boolean addedAsFKEmbedded = false;
				while (itFKC.hasNext()) {
					Column cctJpaC = itFKC.next();
					if (cctJpaC instanceof EmbeddeableColumn) {
						//System.err.println("\t-->>SKIPING DTO + " + cctJpaC.getName());	
					}
				}

				if (addedAsFKEmbedded) {
				}
			}
		}
		for (Table iterTable: tablesForGeneration) {
			if(	iterTable.getColumn("CREATED_BY")	!= null	&&
				iterTable.getColumn("CREATED_TIME")	!= null	&&
				iterTable.getColumn("UPDATED_BY")	!= null	&&
				iterTable.getColumn("UPDATED_TIME")	!= null	&&
				iterTable.getColumn("STATUS")		!= null	   ){
				
				iterTable.setAuditable(true);
				
				//iterTable.getColumn("CREATED_BY")	.setJsonIgnored(true);
				//iterTable.getColumn("CREATED_TIME")	.setJsonIgnored(true);
				//iterTable.getColumn("UPDATED_BY")	.setJsonIgnored(true);
				//iterTable.getColumn("UPDATED_TIME")	.setJsonIgnored(true);
				//iterTable.getColumn("STATUS")		.setJsonIgnored(true);				
			}
		}
		//System.err.println("==============================>>> ");
		for (Table table : tablesForGeneration) {

			System.err.println("-->> generating DTO: " + table.getJavaDeclaredName() + "DTO.java :" + table.getName());

			Iterator<Column> columnsSortedColumnsForJPA = table.getSortedColumnsForJPA();
			List<Column> definitiveColumns = new ArrayList();
			while (columnsSortedColumnsForJPA.hasNext()) {
				Column column = columnsSortedColumnsForJPA.next();
				if(		column.getName().equalsIgnoreCase("FECHA_CREACION")		|| 
						column.getName().equalsIgnoreCase("CREADO_POR")			||
						column.getName().equalsIgnoreCase("FECHA_MODIFICACION")	||
						column.getName().equalsIgnoreCase("MODIFICADO_POR")){
					continue;
				}
				String suggestedHyperColumnName=null;
				String suggestedObjectName=null;
				String suggestedGettetObjectName=null;
				String suggestedSettetObjectName=null;
				Table fTable = null;
				
				if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
					fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
					column.setFTable(fTable);
					System.err.println("\t\t\t-->>column:"+column.getName()+" == fTable: name:"+fTable.getName()+"?");
					final Collection<Column> ftPksCol = fTable.getPrimaryKeys();
					for(Column ftpk: ftPksCol){
						System.err.println("\t\t\t\t-->>column:"+column.getName()+" == FKs:"+ftpk.getName()+"?");
						if(column.getName().toUpperCase().equals(ftpk.getName().toUpperCase())){
							//suggestedHyperColumnName = column.getName().toUpperCase();
							suggestedHyperColumnName = fTable.getName();
							System.err.println("\t\t\t1)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
							
							suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggestedHyperColumnName));
							suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggestedHyperColumnName);
							suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggestedHyperColumnName);

							column.setHyperColumnName(suggestedHyperColumnName);
							break;
						} else if(column.getName().toUpperCase().contains(ftpk.getName().toUpperCase())){
							if(fTable.getSingularName()!=null){
								suggestedHyperColumnName = fTable.getSingularName()+"_"+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");								
								//suggestedHyperColumnName = fTable.getSingularName();
								System.err.println("\t\t\t\t2)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
							} else if((fTable.getName()+"_"+ftpk.getName()).toUpperCase().equals(column.getName().toUpperCase())){
								suggestedHyperColumnName = column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");
								//suggestedHyperColumnName = fTable.getName()+"_"+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");										
								System.err.println("\t\t\t3A)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
							} else {
								//suggestedHyperColumnName = c.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");
								suggestedHyperColumnName = fTable.getName()+"_"+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");										
								System.err.println("\t\t\t3B)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
							}
							suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggestedHyperColumnName));
							suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggestedHyperColumnName);
							suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggestedHyperColumnName);

							column.setHyperColumnName(suggestedHyperColumnName);
							break;
						}
					}
					if(suggestedHyperColumnName == null){
						suggestedHyperColumnName = fTable.getName();
						System.err.println("\t\t\t4)-->>suggestedHyperColumnName="+suggestedHyperColumnName);

						suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggestedHyperColumnName));
						suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggestedHyperColumnName);
						suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggestedHyperColumnName);

						column.setHyperColumnName(suggestedHyperColumnName);
						break;
					}					
				} else {
					fTable = null;
				}
				definitiveColumns.add(column);
				//System.err.println("\t\t\t-->> * DefinitiveColumn: " + column.getName()+"\tHyperColumnName:"+column.getHyperColumnName());
			}

			//-------------------------------------------------------
			baseDir = new File(basePath);

			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}
			String line = null;
			ArrayList<String> linesToParse = null;
			int nl = 0;
			// ------------------------------------------------------
			fileName = dtoPackage.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + "FilteredByDTO.java";

			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);

			br = new BufferedReader(new InputStreamReader(
					fos.getClass().getResourceAsStream("/templates/FilterByDTO.java.template")));
			nl = 0;
			while ((line = br.readLine()) != null) {
				line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
				line = line.replace("${date}", sdf.format(new Date()));
				line = line.replace("${tablebean.dto.package}", dtoPackage);
				line = line.replace("${tablebean.serialId}", String.valueOf(23234523453L)+"L");
				ps.println(line);
			}
			// ------------------------------------------------------
			fileName = dtoPackage.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + "MultipageRecordDTORequest.java";

			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);

			br = new BufferedReader(new InputStreamReader(
					fos.getClass().getResourceAsStream("/templates/MultipageRecordDTORequest.java.template")));
			line = null;
			linesToParse = null;
			nl = 0;
			while ((line = br.readLine()) != null) {
				line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
				line = line.replace("${date}", sdf.format(new Date()));
				line = line.replace("${tablebean.dto.package}", dtoPackage);
				line = line.replace("${tablebean.serialId}", String.valueOf(23234523454L)+"L");
				ps.println(line);
			}
			// ------------------------------------------------------
			fileName = dtoPackage.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + "PaginatedResult.java";

			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);

			br = new BufferedReader(new InputStreamReader(
					fos.getClass().getResourceAsStream("/templates/PaginatedResult.java.template")));
			line = null;
			linesToParse = null;
			nl = 0;
			while ((line = br.readLine()) != null) {
				line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
				line = line.replace("${tablebean.dto.package}", dtoPackage);
				line = line.replace("${tablebean.serialId}", String.valueOf(23234523455L)+"L");
				ps.println(line);
			}
			// ------------------------------------------------------
			fileName = dtoPackage.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + "OrderByDTO.java";

			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);

			br = new BufferedReader(new InputStreamReader(
					fos.getClass().getResourceAsStream("/templates/OrderByDTO.java.template")));
			line = null;
			linesToParse = null;
			nl = 0;
			while ((line = br.readLine()) != null) {
				line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
				line = line.replace("${tablebean.dto.package}", dtoPackage);
				line = line.replace("${tablebean.serialId}", String.valueOf(23234523455L)+"L");
				ps.println(line);
			}
			// ------------------------------------------------------
			fileName = dtoPackage.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + "RecordDTO.java";

			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);

			br = new BufferedReader(new InputStreamReader(
					fos.getClass().getResourceAsStream("/templates/RecordDTO.java.template")));
			line = null;
			linesToParse = null;
			nl = 0;
			while ((line = br.readLine()) != null) {
				line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
				line = line.replace("${date}", sdf.format(new Date()));
				line = line.replace("${tablebean.dto.package}", dtoPackage);
				line = line.replace("${tablebean.serialId}", String.valueOf(23234523456L)+"L");
				ps.println(line);
			}

			// ------------------------------------------------------
			
			fileName = dtoPackageBeanMember.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + table.getJavaDeclaredName() + "DTO.java";

			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);

			br = new BufferedReader(new InputStreamReader(
					fos.getClass().getResourceAsStream("/templates/TableJsonDTOBeanMapingJPABean.java.template")));
			line = null;
			linesToParse = null;
			nl = 0;
			while ((line = br.readLine()) != null) {

				if (line.indexOf("%foreach") >= 0) {
					linesToParse = new ArrayList<String>();
				} else if (line.indexOf("%endfor") >= 0) {
					int numColumnGenerating = 0;

					for (Column column : definitiveColumns) {
						numColumnGenerating++;

						Table fTable = null;
						String refObjFK = null;

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
						} else {
							fTable = null;
						}

						for (String lineInLoop : linesToParse) {
							//System.err.println("===========================["+lineInLoop+".indexOf(${tablebean.member.valueGetter})] => "+(lineInLoop.indexOf("${tablebean.member.valueGetter}")));
							if (	lineInLoop.indexOf("${tablebean.member.javaIdentifier}") >= 0 || 
									lineInLoop.indexOf("${tablebean.member.valueGetter}")    >= 0 ||
									lineInLoop.indexOf("${tablebean.member.jsonignore}")     >= 0 ||
									lineInLoop.indexOf("${tablebean.member.jsonignore.comment}")     >= 0 ) {
								if (! (column instanceof EmbeddeableColumn) ){
									lineInLoop = lineInLoop.replace("${tablebean.member.javaIdentifier}", column.getJavaDeclaredObjectName());
									
									if(column.getJavaClassType().equalsIgnoreCase("byte[]")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"   , "getString");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "java.util.Base64.getDecoder().decode");									
									}else if(column.getJavaClassType().equalsIgnoreCase("double")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"   , "getDouble");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());										
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "(Double)");							
									}else if(column.getJavaClassType().equalsIgnoreCase("java.lang.Double")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"   , "getDouble");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());										
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "(Double)");							
									}else if(column.getJavaClassType().equalsIgnoreCase("double")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"   , "getDouble");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());										
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "(double)");							
									}else if(column.getJavaClassType().equalsIgnoreCase("java.lang.Integer")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"   , "getInt");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "(Integer)");							
									}else if(column.getJavaClassType().equalsIgnoreCase("int")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"   , "getInt");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "(int)");							
									}else if(column.getJavaClassType().equalsIgnoreCase("java.lang.Long")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"   , "getLong");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "(Long)");							
									}else if(column.getJavaClassType().equalsIgnoreCase("java.lang.Short")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"   , "getInt");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "(short)");
									}else if(column.getJavaClassType().equalsIgnoreCase("short")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"   , "getInt");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());										
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "(short)");
									}else if(column.getJavaClassType().equalsIgnoreCase("java.util.Date")){
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"    , "getLong");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", "sdfIso8601.format("+column.getJavaDeclaredObjectName()+")");
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"     , "new java.util.Date");
									}else{
										lineInLoop = lineInLoop.replace("${tablebean.member.valueGetter}"    , column.getValueGetter());
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonValueGetter}", column.getJavaDeclaredObjectName());
										lineInLoop = lineInLoop.replace("${tablebean.member.valueCast}"      , column.getValueCast());
									}
									if(column.isJsonIgnored()){
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonignore}", "@JsonIgnore");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonignore.comment}", "// ");
									}else{
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonignore}", "");
										lineInLoop = lineInLoop.replace("${tablebean.member.jsonignore.comment}", "");
									}
									ps.println(lineInLoop);
								}
							} else if (lineInLoop.indexOf("${tablebean.member.javadocCommnet}") >= 0) {
								
								if (column.getComments() != null) {
									ps.println("    ");
									ps.println("    /**");
									ps.println("    * " + column.getComments().replace("\n", "\n     * ")+(column.isJsonIgnored()?", Json Ignored in marshalling":""));
									ps.println("    */");
								} else {
									String commentForced = column.getName().toLowerCase().replace("_", " ");
									ps.println("    ");
									ps.println("    /**");
									ps.println("    * " + commentForced+(column.isJsonIgnored()?", Json Ignored in marshalling":""));
									ps.println("    */");
								}

							} else if (lineInLoop.indexOf("${tablebean.member.class}") >= 0) {
								if (column instanceof EmbeddeableColumn){
									lineInLoop = lineInLoop.replace("${tablebean.member.class}"   , column.getJavaDeclaredObjectName());
								} else {
									lineInLoop = lineInLoop.replace("${tablebean.member.class}"   , column.getJavaClassType());									
								}
								ps.println(lineInLoop);
							} else if (lineInLoop.indexOf("${tablebean.member.declaration}") >= 0) {
								if (column instanceof EmbeddeableColumn){
									EmbeddeableColumn eColumn = (EmbeddeableColumn)column;
									ps.println("    // " + column.getJavaDeclaredObjectName() + " EmbedableColumn ID References: FKs {"+eColumn.getFKs()+"}");
								} else {
									//ps.println("    // Simple: PK?"+column.isPrimaryKey()+", FK?"+column.isForeignKey()+", class="+column.getJavaClassType()+", o="+column.getJavaDeclaredObjectName());
									ps.println("    private " + column.getJavaClassType().replace("java.lang.", "") + " " + column.getJavaDeclaredObjectName() + ";");
								}

							} else if (lineInLoop.indexOf("${tablebean.member.getter}") >= 0) {
								
								if (column instanceof EmbeddeableColumn) {
									EmbeddeableColumn eColumn = (EmbeddeableColumn)column;
									ps.println("    // " + column.getJavaDeclaredObjectName() + " EmbedableColumn ID References: FKs {"+eColumn.getFKs()+"}");
								} else {
									
									ps.println("    public "+column.getJavaClassType().replace("java.lang.", "")+" get"+FormatString.getCadenaHungara(column.getName())+"() {");
									ps.println("        return this." + column.getJavaDeclaredObjectName() + ";");								
									ps.println("    }");
								}
							} else if (lineInLoop.indexOf("${tablebean.member.setter}") >= 0) {
								if (column instanceof EmbeddeableColumn) {
									EmbeddeableColumn eColumn = (EmbeddeableColumn)column;
									ps.println("    // " + column.getJavaDeclaredObjectName() + " EmbedableColumn ID References: FKs {"+eColumn.getFKs()+"}");
								} else {
									
									ps.println("    public void set"+FormatString.getCadenaHungara(column.getName())+"("+column.getJavaClassType().replace("java.lang.", "")+" v) {");
									ps.println("        this." + column.getJavaDeclaredObjectName() + " = v;");								
									ps.println("    }");
								}
								
							} else {
								ps.println(lineInLoop);
							}
						}
					}

					linesToParse = null;
				} else if (linesToParse != null) {
					linesToParse.add(line);
				} else if (line.indexOf("${jpaCopyedToDtoMembers.code}") >= 0) {
					for (Column column : definitiveColumns) {

						Table fTable = null;

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
														
							if( hasNomalizaedFKReferences(fTable, column) ){
								//ps.println("        this." + column.getJavaDeclaredObjectName() + " = jpaEntity.get" + FormatString.getCadenaHungara(fTable.getName()) + "().get" + FormatString.getCadenaHungara(fTable.getJPAPK()) + "(); // normalized ");
								ps.println("        this." + column.getJavaDeclaredObjectName() + " = jpaEntity.get" + FormatString.getCadenaHungara(fTable.getName()) + "()!=null?jpaEntity.get" + FormatString.getCadenaHungara(fTable.getName()) + "().get" + FormatString.getCadenaHungara(fTable.getJPAPK()) + "():null; // normalized ");
							}else{
								ps.println("        this." + column.getJavaDeclaredObjectName() + " = jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "()!=null?jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "().get" + FormatString.getCadenaHungara(fTable.getJPAPK()) + "():null; // custom");
							}
							
						} else if (column instanceof EmbeddeableColumn) {
							EmbeddeableColumn eColumn = (EmbeddeableColumn)column;							
							
							ps.println("        // "+FormatString.getCadenaHungara(column.getName())+" is Embeddable. Begin nested settings");
							final Collection<Column> fKs = eColumn.getFKs();
							for(Column fC: fKs){
								ps.print  ("        this." + column.getJavaDeclaredObjectName() + ".set"+fC.getJavaDeclaredName());
								ps.println("( jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "().get"+fC.getJavaDeclaredName()+"() );");							
							}
							ps.println("        // End nested settings");
							
						} else {
							ps.println("        this." + column.getJavaDeclaredObjectName() + " = jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "(); // primitive");							
						}
					}
				} else if (line.indexOf("${dtoCopyedToJpaMembers.code}") >= 0) {
					for (Column column : definitiveColumns) {
						Table fTable = null;

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
							
							if( hasNomalizaedFKReferences(fTable, column) ){
								//ps.println("        jpaEntity.set" + FormatString.getCadenaHungara(fTable.getName()) + "( new " + jpaPackageBeanMember + "." + fTable.getJavaDeclaredName() + "(this.get" + FormatString.getCadenaHungara(column.getName()) + "())); // normalized");
								ps.println("        jpaEntity.set" + FormatString.getCadenaHungara(fTable.getName()) + "( this.get" + FormatString.getCadenaHungara(column.getName()) + "()!=null? new " + jpaPackageBeanMember + "." + fTable.getJavaDeclaredName() + "(this.get" + FormatString.getCadenaHungara(column.getName()) + "()):null); // normalized");
							}else{
								ps.println("        jpaEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( new " + jpaPackageBeanMember + "." + fTable.getJavaDeclaredName() + "(this.get" + FormatString.getCadenaHungara(column.getName()) + "())); // custom");
							}
						} else if (column instanceof EmbeddeableColumn) {
							EmbeddeableColumn eColumn = (EmbeddeableColumn)column;							
							
							ps.println("        // "+FormatString.getCadenaHungara(column.getName())+" is Embeddable. Begin nested settings");
							final Collection<Column> fKs = eColumn.getFKs();
							for(Column fC: fKs){
								ps.print  ("        jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "().set"+fC.getJavaDeclaredName());
								ps.println("( this." + column.getJavaDeclaredObjectName() + ".get"+fC.getJavaDeclaredName()+"() );");
							}
							ps.println("        // End nested settings");
							
						} else {

							ps.println("        jpaEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( this.get" + FormatString.getCadenaHungara(column.getName()) + "());");
						}

					}
				} else if (line.indexOf("${dtoCopyedToJpaMembersList.code}") >= 0) {
					for (Column column : definitiveColumns) {
						Table fTable = null;

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
							
							if( hasNomalizaedFKReferences(fTable, column) ){
								//ps.println("        jpaEntity.set" + FormatString.getCadenaHungara(fTable.getName()) + "( new " + jpaPackageBeanMember + "." + fTable.getJavaDeclaredName() + "(this.get" + FormatString.getCadenaHungara(column.getName()) + "())); // normalized");
								ps.println("            jpaEntity.set" + FormatString.getCadenaHungara(fTable.getName()) + "( this.get" + FormatString.getCadenaHungara(column.getName()) + "()!=null? new " + jpaPackageBeanMember + "." + fTable.getJavaDeclaredName() + "(this.get" + FormatString.getCadenaHungara(column.getName()) + "()):null); // normalized");
							}else{
								ps.println("            jpaEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( new " + jpaPackageBeanMember + "." + fTable.getJavaDeclaredName() + "(this.get" + FormatString.getCadenaHungara(column.getName()) + "())); // custom");
							}
						} else if (column instanceof EmbeddeableColumn) {
							EmbeddeableColumn eColumn = (EmbeddeableColumn)column;							
							
							ps.println("            // "+FormatString.getCadenaHungara(column.getName())+" is Embeddable. Begin nested settings");
							final Collection<Column> fKs = eColumn.getFKs();
							for(Column fC: fKs){
								ps.print  ("            jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "().set"+fC.getJavaDeclaredName());
								ps.println("( this." + column.getJavaDeclaredObjectName() + ".get"+fC.getJavaDeclaredName()+"() );");
							}
							ps.println("            // End nested settings");
							
						} else {

							ps.println("            jpaEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( this.get" + FormatString.getCadenaHungara(column.getName()) + "());");
						}
					}
				} else {
					line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
					line = line.replace("${date}", sdf.format(new Date()));
					line = line.replace("${tablebean.serialId}", String.valueOf(table.hashCode())+"L");
					line = line.replace("${tablebean.name}", table.getName().toUpperCase());
					line = line.replace("${tablebean.declaredName}", table.getJavaDeclaredName());
					line = line.replace("${tablebean.PKMembersParameters}", membersParameters(table, dbSet));

					if (table instanceof EmbeddeableColumn) {
//                        line = line.replace("${tablebean.jpa_entity_or_embeddeable}", "@Embeddable");
						line = line.replace("${tablebean.jpa_talbe}", "");
					} else {
//                        line = line.replace("${tablebean.jpa_entity_or_embeddeable}", "@Entity");
//                        line = line.replace("${tablebean.jpa_talbe}", "@Table(name = \"" + table.getName().toUpperCase() + "\")");
						line = line.replace("${tablebean.id}", table.getJPAPK());
						line = line.replace("${tablebean.id.javaClass}", table.getJPAPKClass().replace("java.lang.", ""));
					}

					line = line.replace("${tablebean.hashCodeSumCode}", table.getHashCodeSumCode());
					line = line.replace("${tablebean.PKMembersParametersInitCode}", membersParametersInitCode(table, dbSet));
					line = line.replace("${tablebean.equalsCode}", table.getEqualsCode());
					line = line.replace("${tablebean.toStringCode}", table.getToDTOStringCode(dbSet, dtoPackageBeanMember));
					line = line.replace("${tablebean.name.uc}", table.getName().toUpperCase());
					line = line.replace("${tablebean.package}", dtoPackageBeanMember);
					line = line.replace("${tablebean.dto.package}", dtoPackage);
					line = line.replace("${tableJPAbean.package}", jpaPackageBeanMember);

					ps.println(line);
				}
			}
			//-------------------------------------------------------
			ps.close();
			fos.close();

			sourceFile = null;
			ps = null;
			fos = null;
		}
	}

	public static void buildDTOsAssembler(DBTableSet dbSet, String asmPackageBeanMember, String dtoPackageBeanMember, String jpaPackageBeanMember, String basePath)
			throws Exception {
		String fileName;
		File baseDir = null;
		File dirSourceFile = null;
		File sourceFile = null;

		FileOutputStream fos = null;
		PrintStream ps = null;
		BufferedReader br = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String collectionClass = "Collection";
		Properties vp=VersionUtil.loadVersionProperties();
		Enumeration<String> tableNames = dbSet.getTableNames();
		ArrayList<Table> tablesForGeneration = new ArrayList<Table>();
        
        System.err.println("====================== [ com.tracktopell.dao.builder.jpa.DTOBeanBuilder.buildMappingDTOsForJPABeans ]========================");
        
		while (tableNames.hasMoreElements()) {
			Table simpleTable = dbSet.getTable(tableNames.nextElement());
			if (!simpleTable.isManyToManyTableWinthMoreColumns()) {
				//System.err.println("-->> + " + simpleTable.getName());
				tablesForGeneration.add(simpleTable);

				Iterator<Column> itFKC = simpleTable.getSortedColumnsForJPA();
				boolean addedAsFKEmbedded = false;
				while (itFKC.hasNext()) {
					Column cctJpaC = itFKC.next();
					if (cctJpaC instanceof EmbeddeableColumn) {
						//System.err.println("\t-->> + " + cctJpaC.getName());
						tablesForGeneration.add((EmbeddeableColumn) cctJpaC);
						addedAsFKEmbedded = true;
					}
				}

				if (addedAsFKEmbedded) {
				}

			} else {
				//System.err.println("-->> [X] Many 2 Many : " + simpleTable.getName());
			}

		}
		//System.err.println("==============================>>> ");
		for (Table table : tablesForGeneration) {

			if(table.getName().endsWith("_P_K")){
				continue;
			}
			System.err.println("\t\t-->> generating: " + table.getJavaDeclaredName() + ".java :" + table.getName());

			Iterator<Column> columnsSortedColumnsForJPA = table.getSortedColumnsForJPA();
			List<Column> definitiveColumns = new ArrayList();
			while (columnsSortedColumnsForJPA.hasNext()) {
				Column column = columnsSortedColumnsForJPA.next();
				if(		column.getName().equalsIgnoreCase("FECHA_CREACION")		|| 
						column.getName().equalsIgnoreCase("CREADO_POR")			||
						column.getName().equalsIgnoreCase("FECHA_MODIFICACION")	||
						column.getName().equalsIgnoreCase("MODIFICADO_POR")){
					continue;
				}
				String suggestedHyperColumnName=null;
				String suggestedObjectName=null;
				String suggestedGettetObjectName=null;
				String suggestedSettetObjectName=null;
				Table fTable = null;
				
				if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
					fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
					column.setFTable(fTable);
					//System.err.println("\t\t\t-->>column:"+column.getName()+" == fTable: name:"+fTable.getName()+"?");
					final Collection<Column> ftPksCol = fTable.getPrimaryKeys();
					for(Column ftpk: ftPksCol){
						//System.err.println("\t\t-->>fTable="+fTable.getName()+", ftpk="+ftpk.getName()+", column="+column.getName());
						if(column.getName().toUpperCase().equals(ftpk.getName().toUpperCase())){
							//suggestedHyperColumnName = column.getName().toUpperCase();
							suggestedHyperColumnName = fTable.getName();
							//System.err.println("\t\t\t1)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
							
							suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggestedHyperColumnName));
							suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggestedHyperColumnName);
							suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggestedHyperColumnName);

							column.setHyperColumnName(suggestedHyperColumnName);
							break;
						} else if(column.getName().toUpperCase().contains(ftpk.getName().toUpperCase())){
							if(fTable.getSingularName()!=null){
								suggestedHyperColumnName = fTable.getSingularName()+"_"+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");								
								//suggestedHyperColumnName = fTable.getSingularName();
								//System.err.println("\t\t\t\t2)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
							} else if((fTable.getName()+"_"+ftpk.getName()).toUpperCase().equals(column.getName().toUpperCase())){
								suggestedHyperColumnName = column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");
								//suggestedHyperColumnName = fTable.getName()+"_"+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");										
								//System.err.println("\t\t\t3A)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
							} else {
								//suggestedHyperColumnName = c.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");
								suggestedHyperColumnName = fTable.getName()+"_"+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");										
								//System.err.println("\t\t\t3B)-->>suggestedHyperColumnName="+suggestedHyperColumnName);
							}
							suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggestedHyperColumnName));
							suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggestedHyperColumnName);
							suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggestedHyperColumnName);

							column.setHyperColumnName(suggestedHyperColumnName);
							break;
						}
					}
					if(suggestedHyperColumnName == null){
						suggestedHyperColumnName = fTable.getName();
						//System.err.println("\t\t\t4)-->>suggestedHyperColumnName="+suggestedHyperColumnName);

						suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggestedHyperColumnName));
						suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggestedHyperColumnName);
						suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggestedHyperColumnName);

						column.setHyperColumnName(suggestedHyperColumnName);
						break;
					}					
				} else {
					fTable = null;
				}
				definitiveColumns.add(column);
				//System.err.println("\t\t\t-->> DefinitiveColumn: " + column.getName()+"\tHyperColumnName:"+column.getHyperColumnName());
			}

			//-------------------------------------------------------
			baseDir = new File(basePath);

			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}

			fileName = asmPackageBeanMember.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + table.getJavaDeclaredName() + "Assembler.java";

			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);

			br = new BufferedReader(new InputStreamReader(
					fos.getClass().getResourceAsStream("/templates/AssemblerDTOJPABean.java.template")));
			String line = null;
			ArrayList<String> linesToParse = null;
			int nl = 0;
			while ((line = br.readLine()) != null) {

				if (line.indexOf("%foreach") >= 0) {
					linesToParse = new ArrayList<String>();
				} else if (line.indexOf("%endfor") >= 0) {
					int numColumnGenerating = 0;

					for (Column column : definitiveColumns) {
						numColumnGenerating++;

						Table fTable = null;
						String refObjFK = null;

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
						} else {
							fTable = null;
						}

						for (String lineInLoop : linesToParse) {
							if (lineInLoop.indexOf("${tablebean.member.declaration}") >= 0) {
								
								if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
									fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());									
									ps.println("    // Direct ID References");
									ps.println("    private "+fTable.getJPAPKClass().replace("java.lang.", "")+" "+FormatString.renameForJavaMethod(column.getName())+";");
								} else if (column instanceof EmbeddeableColumn) {
									EmbeddeableColumn eColumn = (EmbeddeableColumn)column;
									ps.println("    // EmbedableColumn ID References: FKs {"+eColumn.getFKs()+"}");
									//ps.println("    private "+fTable.getJPAPKClass().replace("java.lang.", "")+" "+FormatString.renameForJavaMethod(column.getName())+";");
									ps.println("    private " + column.getJavaClassType().replace("java.lang.", "") + " " + column.getJavaDeclaredObjectName() + ";");
								} else {
									ps.println("    // primitive");
									ps.println("    private " + column.getJavaClassType().replace("java.lang.", "") + " " + column.getJavaDeclaredObjectName() + ";");
								}
							} else {
								lineInLoop = lineInLoop.replace("${tablebean.member.getter}", "get"+column.getJavaDeclaredName());
								lineInLoop = lineInLoop.replace("${tablebean.member.setter}", "set"+column.getJavaDeclaredName());
								ps.println(lineInLoop);
							}
						}
					}

					linesToParse = null;
				} else if (linesToParse != null) {
					linesToParse.add(line);
				} else if (line.indexOf("${jpaCopyedToDtoMembers.code}") >= 0) {
					for (Column column : definitiveColumns) {

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							
							//ps.println("        //Not Embedable: "+FormatString.getCadenaHungara(column.getName())+" -> "+FormatString.getCadenaHungara(column.getFTable().getName())+", FTable: "+column.getFTable().getName()+", HyperName:"+column.getHyperColumnName());
							for(Column cfk: column.getFTable().getColums()){
								if(cfk.isPrimaryKey()){									
									if(column.getHyperColumnName()!=null){
										ps.println("        dtoEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( jpaEntity."+column.getHyperColumnGetterName()+"()!=null?jpaEntity."+column.getHyperColumnGetterName()+"().get"+FormatString.getCadenaHungara(cfk.getName())+"():null);");
									} else {
										ps.println("        dtoEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( jpaEntity.get"+FormatString.getCadenaHungara(column.getFTable().getName())+"()!=null?jpaEntity.get"+FormatString.getCadenaHungara(column.getFTable().getName())+"().get"+FormatString.getCadenaHungara(cfk.getName())+"():null);");
									}
								}
							}
						} else if (column instanceof EmbeddeableColumn) {
							EmbeddeableColumn eColumn = (EmbeddeableColumn)column;							
							
							//ps.println("        // Embedable: "+FormatString.getCadenaHungara(column.getName())+", begin nested settings");
							final Collection<Column> fKs = eColumn.getFKs();
							for(Column fC: fKs){
								ps.print  ("        dtoEntity.set" + FormatString.getCadenaHungara(fC.getName()));
								ps.println("( jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "().get"+fC.getJavaDeclaredName()+"() ); // bug 3 ?");
							}
							//ps.println("        // End nested settings");
							
						} else {
							ps.println("        dtoEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "() ); // primitive");
						}
					}
				} else if (line.indexOf("${jpaCopyedToDtoMembersList.code}") >= 0) {
					for (Column column : definitiveColumns) {

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							
							//ps.println("            //Not Embedable: "+FormatString.getCadenaHungara(column.getName())+" -> "+FormatString.getCadenaHungara(column.getFTable().getName())+", FTable: "+column.getFTable().getName()+", HyperName:"+column.getHyperColumnName());
							for(Column cfk: column.getFTable().getColums()){
								if(cfk.isPrimaryKey()){									
									if(column.getHyperColumnName()!=null){
										ps.println("            dtoEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( jpaEntity."+column.getHyperColumnGetterName()+"()!=null?jpaEntity."+column.getHyperColumnGetterName()+"().get"+FormatString.getCadenaHungara(cfk.getName())+"():null);");
									} else {
										ps.println("            dtoEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( jpaEntity.get"+FormatString.getCadenaHungara(column.getFTable().getName())+"()!=null?jpaEntity.get"+FormatString.getCadenaHungara(column.getFTable().getName())+"().get"+FormatString.getCadenaHungara(cfk.getName())+"():null);");
									}
								}
							}
						} else if (column instanceof EmbeddeableColumn) {
							EmbeddeableColumn eColumn = (EmbeddeableColumn)column;							
							
							//ps.println("            // Embedable: "+FormatString.getCadenaHungara(column.getName())+", begin nested settings");
							final Collection<Column> fKs = eColumn.getFKs();
							for(Column fC: fKs){
								ps.print  ("            dtoEntity.set" + FormatString.getCadenaHungara(fC.getName()));
								ps.println("( jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "().get"+fC.getJavaDeclaredName()+"() );");
							}
							//ps.println("            // End nested settings");
							
						} else {
							ps.println("            dtoEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "() );");
						}
					}
				} else if (line.indexOf("${dtoCopyedToJpaMembers.code}") >= 0) {
					for (Column column : definitiveColumns) {
						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {							
							if( column.getHyperColumnName()!=null){						
								ps.println("        "+column.getFTable().getJavaDeclaredName()+"DTO "+FormatString.firstLetterLowerCase(column.getHyperColumnObjectName())+"DTO = new "+column.getFTable().getJavaDeclaredName()+"DTO();");
								ps.println("        "+FormatString.firstLetterLowerCase(column.getHyperColumnObjectName())+"DTO.set"+FormatString.getCadenaHungara(column.getFTable().getJPAPK())+"( dtoEntity.get" + FormatString.getCadenaHungara(column.getName())+ "());");								
								ps.println("        jpaEntity." + column.getHyperColumnSetterName() + "( "+column.getFTable().getJavaDeclaredName()+"Assembler.buildJpaEntity( "+FormatString.firstLetterLowerCase(column.getHyperColumnObjectName())+"DTO ));");
							} else {
								//ps.println("        // Assembler delegation: fTable.pk="+column.getFTable().getJPAPK());
								ps.println("        "+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO dto"+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO = new "+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO();");
								ps.println("        dto"+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO.set"+FormatString.getCadenaHungara(column.getFTable().getJPAPK())+"( dtoEntity.get" + FormatString.getCadenaHungara(column.getName())+ "());");
								ps.println("        jpaEntity.set" + FormatString.getCadenaHungara(column.getFTable().getName()) + "( "+FormatString.getCadenaHungara(column.getFTable().getName())+"Assembler.buildJpaEntity( dto"+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO )); ");
							}
						} else if (column instanceof EmbeddeableColumn) {
							EmbeddeableColumn eColumn = (EmbeddeableColumn)column;														
							//ps.println("        // "+FormatString.getCadenaHungara(column.getName())+" is Embeddable. Begin nested settings");
							final Collection<Column> fKs = eColumn.getFKs();
							for(Column fC: fKs){
								ps.print  ("        jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "().set"+fC.getJavaDeclaredName());
								ps.println("( dtoEntity.get"+fC.getJavaDeclaredName()+"() );  // nested FKs > BUG");
							}
							//ps.println("        // End nested settings");
							
						} else {
							ps.println("        jpaEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( dtoEntity.get" + FormatString.getCadenaHungara(column.getName()) + "()); // normal");
						}

					}
				} else if (line.indexOf("${dtoCopyedToJpaMembersList.code}") >= 0) {
					for (Column column : definitiveColumns) {
						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {							
							if( column.getHyperColumnName()!=null){								
								ps.println("            "+column.getFTable().getJavaDeclaredName()+"DTO "+FormatString.firstLetterLowerCase(column.getHyperColumnObjectName())+"DTO = new "+column.getFTable().getJavaDeclaredName()+"DTO();");
								ps.println("            "+FormatString.firstLetterLowerCase(column.getHyperColumnObjectName())+"DTO.set"+FormatString.getCadenaHungara(column.getFTable().getJPAPK())+"( dtoEntity.get" + FormatString.getCadenaHungara(column.getName())+ "());");								
								ps.println("            jpaEntity." + column.getHyperColumnSetterName() + "( "+column.getFTable().getJavaDeclaredName()+"Assembler.buildJpaEntity( "+FormatString.firstLetterLowerCase(column.getHyperColumnObjectName())+"DTO ));");
							} else {
								//ps.println("            // Assembler delegation: fTable.pk="+column.getFTable().getJPAPK());
								ps.println("            "+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO dto"+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO = new "+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO();");
								ps.println("            dto"+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO.set"+FormatString.getCadenaHungara(column.getFTable().getJPAPK())+"( dtoEntity.get" + FormatString.getCadenaHungara(column.getName())+ "());");
								ps.println("            jpaEntity.set" + FormatString.getCadenaHungara(column.getFTable().getName()) + "( "+FormatString.getCadenaHungara(column.getFTable().getName())+"Assembler.buildJpaEntity( dto"+FormatString.getCadenaHungara(column.getFTable().getName())+"DTO )); ");
							}
						} else if (column instanceof EmbeddeableColumn) {
							EmbeddeableColumn eColumn = (EmbeddeableColumn)column;														
							//ps.println("            // "+FormatString.getCadenaHungara(column.getName())+" is Embeddable. Begin nested settings");
							final Collection<Column> fKs = eColumn.getFKs();
							for(Column fC: fKs){
								ps.print  ("            jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "().set"+fC.getJavaDeclaredName());
								ps.println("( dtoEntity.get"+fC.getJavaDeclaredName()+"() );  // nested FKs > BUG");
							}
							//ps.println("            // End nested settings");
							
						} else {
							ps.println("            jpaEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( dtoEntity.get" + FormatString.getCadenaHungara(column.getName()) + "());");
						}

					}
				} else {
					line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
					line = line.replace("${date}", sdf.format(new Date()));
					line = line.replace("${tablebean.serialId}", String.valueOf(table.hashCode()));
					line = line.replace("${tablebean.name}", table.getName());					                       					
					line = line.replace("${tablebean.declaredName}", table.getJavaDeclaredName());
					line = line.replace("${tablebean.PKMembersParameters}", membersParameters(table, dbSet));

					if (table instanceof EmbeddeableColumn) {
//                        line = line.replace("${tablebean.jpa_entity_or_embeddeable}", "@Embeddable");
						line = line.replace("${tablebean.jpa_talbe}", "");
					} else {
//                        line = line.replace("${tablebean.jpa_entity_or_embeddeable}", "@Entity");
//                        line = line.replace("${tablebean.jpa_talbe}", "@Table(name = \"" + table.getName().toUpperCase() + "\")");
						line = line.replace("${tablebean.id}", table.getJPAPK());
						line = line.replace("${tablebean.id.javaClass}", table.getJPAPKClass().replace("java.lang.", ""));
					}

					line = line.replace("${tablebean.hashCodeSumCode}", table.getHashCodeSumCode());
					line = line.replace("${tablebean.PKMembersParametersInitCode}", membersParametersInitCode(table, dbSet));
					line = line.replace("${tablebean.equalsCode}", table.getEqualsCode());
					line = line.replace("${tablebean.toStringCode}", table.getToDTOStringCode(dbSet, dtoPackageBeanMember));
					line = line.replace("${tablebean.name.uc}", table.getName().toUpperCase());					
					line = line.replace("${tableJPAbean.package}", jpaPackageBeanMember);
					line = line.replace("${tableDTObean.package}", dtoPackageBeanMember);
					line = line.replace("${asmbean.package}"     , asmPackageBeanMember);
					

					ps.println(line);
				}
			}
			//-------------------------------------------------------
			ps.close();
			fos.close();

			sourceFile = null;
			ps = null;
			fos = null;
		}
	}
	
	public static void buildMappingDTOs(DBTableSet dbSet, String dtoPackageBeanMember, String basePath,boolean jpaCompatibleFKs)
			throws Exception {
		String fileName;
		File baseDir = null;
		File dirSourceFile = null;
		File sourceFile = null;

		FileOutputStream fos = null;
		PrintStream ps = null;
		BufferedReader br = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		Enumeration<String> tableNames = dbSet.getTableNames();
		ArrayList<Table> tablesForGeneration = new ArrayList<Table>();
		
		if(jpaCompatibleFKs){
			while (tableNames.hasMoreElements()) {
				Table simpleTable = dbSet.getTable(tableNames.nextElement());
				if (!simpleTable.isManyToManyTableWinthMoreColumns()) {
					System.err.println("-->> + " + simpleTable.getName());
					tablesForGeneration.add(simpleTable);

					Iterator<Column> itFKC = simpleTable.getSortedColumnsForJPA();
					boolean addedAsFKEmbedded = false;
					while (itFKC.hasNext()) {
						Column cctJpaC = itFKC.next();
						if (cctJpaC instanceof EmbeddeableColumn) {
							//System.err.println("\t-->> + " + cctJpaC.getName());
							tablesForGeneration.add((EmbeddeableColumn) cctJpaC);
							addedAsFKEmbedded = true;
						}
					}

					if (addedAsFKEmbedded) {
					}

				} else {
					//System.err.println("-->> [X] Many 2 Many : " + simpleTable.getName());
				}
			}
		} else {
			while (tableNames.hasMoreElements()) {
				Table simpleTable = dbSet.getTable(tableNames.nextElement());				
				System.err.println("-->> + " + simpleTable.getName());
				tablesForGeneration.add(simpleTable);
			}
		}
		System.err.println("==============================>>> ");
		for (Table table : tablesForGeneration) {

			System.err.println("-->> generating for " + table.getJavaDeclaredName() );		
			
			Iterator<Column> columnsToGenerate = null;
			if(jpaCompatibleFKs){
				columnsToGenerate = table.getSortedColumnsForJPA();
			}else{
				columnsToGenerate = table.getColums().iterator();
			}
			
			List<Column> definitiveColumns = new ArrayList();
			while (columnsToGenerate.hasNext()) {
				Column c = columnsToGenerate.next();
				definitiveColumns.add(c);
				//System.err.println("\t\t-->> DefinitiveColumn: " + c);
			}
					

			//-------------------------------------------------------
			baseDir = new File(basePath);

			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}

			fileName = dtoPackageBeanMember.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + table.getJavaDeclaredName() + "DTO.java";
			System.err.println("\t-->> file: " + fileName);
			
			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);

			br = new BufferedReader(new InputStreamReader(
					fos.getClass().getResourceAsStream("/templates/TableDTO.java.template")));
			String line = null;
			ArrayList<String> linesToParse = null;
			int nl = 0;
						
			while ((line = br.readLine()) != null) {

				if (line.indexOf("%foreach") >= 0) {
					linesToParse = new ArrayList<String>();
				} else if (line.indexOf("%endfor") >= 0) {
					int numColumnGenerating = 0;
					
					for (Column column : definitiveColumns) {
						numColumnGenerating++;

						Table fTable = null;
						String refObjFK = null;

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
						} else {
							fTable = null;
						}
						
						String agregateInHashcodeExcludeExp = column.isPrimaryKey() && table.getPrimaryKeys().size()>0? "":"//";
						String agregateInEqualsExcludeExp   = column.isPrimaryKey() && table.getPrimaryKeys().size()>0? "":"//";;
			
						for (String lineIL : linesToParse) {
							if (lineIL.indexOf("${tablebean.member.javadocCommnet}") >= 0) {
								if (!table.isManyToManyTableWinthMoreColumns()) {
									if (column.getComments() != null) {
										ps.println("    ");
										ps.println("    /**");
										ps.println("    * " + column.getComments().replace("\n", "\n     * "));
										ps.println("    */");
									} else {
										String commentForced = column.getName().toLowerCase().replace("_", " ");
										ps.println("    ");
										ps.println("    /**");
										ps.println("    * " + commentForced);
										ps.println("    */");
									}
								}
							} else if (lineIL.indexOf("${tablebean.member.declaration}") >= 0) {
								
								if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
									fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());									
									ps.println("    private "+fTable.getJPAPKClass().replace("java.lang.", "")+" "+FormatString.renameForJavaMethod(column.getName())+";");
								} else {
									ps.println("    private " + column.getJavaClassType().replace("java.lang.", "") + " " + column.getJavaDeclaredObjectName() + ";");
								}								
							} else if (lineIL.indexOf("${tablebean.member.getter}") >= 0) {
								
								if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
									ps.println("    public "+fTable.getJPAPKClass().replace("java.lang.", "")+"  get"+FormatString.getCadenaHungara(column.getName())+"() {");									
									ps.println("        return this." + FormatString.renameForJavaMethod(column.getName()) + ";");
								} else {
									ps.println("    public "+column.getJavaClassType().replace("java.lang.", "")+" get"+FormatString.getCadenaHungara(column.getName())+"() {");
									ps.println("        return this." + column.getJavaDeclaredObjectName() + ";");								
								}
								ps.println("    }");

							} else if (lineIL.indexOf("${tablebean.member.setter}") >= 0) {
								if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
									ps.println("    public void set"+FormatString.getCadenaHungara(column.getName())+"("+fTable.getJPAPKClass().replace("java.lang.", "")+" id) {");									
									ps.println("        this." + column.getJavaDeclaredObjectName() + " = id;");
								} else {
									ps.println("    public void set"+FormatString.getCadenaHungara(column.getName())+"("+column.getJavaClassType().replace("java.lang.", "")+" v) {");
									ps.println("        this." + column.getJavaDeclaredObjectName() + " = v;");								
								}
								ps.println("    }");

							} else {
								lineIL = lineIL.replace("${tablebean.member.name}"                        , column.getName().toUpperCase());								
								lineIL = lineIL.replace("${tablebean.member.javaIdentifier}"              , column.getJavaDeclaredObjectName());
								lineIL = lineIL.replace("${tablebean.member.javaClass}"                   , column.getJavaClassType());
								lineIL = lineIL.replace("${tablebean.member.agregateInHashcodeExcludeExp}", agregateInHashcodeExcludeExp);
								lineIL = lineIL.replace("${tablebean.member.agregateInEqualsExcludeExp}"  , agregateInEqualsExcludeExp);								
								lineIL = lineIL.replace("${tablebean.member.valueGetter}"                 , column.getValueGetter());		
								lineIL = lineIL.replace("${tablebean.member.jsonObjValueGetter}"          , column.getJsonObjValueGetter());
								lineIL = lineIL.replace("${tablebean.member.jsonObjGetValue}"             , column.getJsonObjGetValue());								
								lineIL = lineIL.replace("${tablebean.member.nativeGetter}"                , column.getNativeGetter());
								lineIL = lineIL.replace("${tablebean.member.getterNative}"                , column.getGetterNative());
								lineIL = lineIL.replace("${tablebean.member.setterNative}"                , column.getSetterNative());
								lineIL = lineIL.replace("${tablebean.member.getterCast}"                  , column.getValueCast());
								lineIL = lineIL.replace("${tablebean.member.callGetter}"                  , "get"+column.getJavaDeclaredName());
								lineIL = lineIL.replace("${tablebean.member.callSetter}"                  , "set"+column.getJavaDeclaredName());								
								lineIL = lineIL.replace("${tablebean.member.nullableExpresion}"           , column.getNullableExpression("this"));
								lineIL = lineIL.replace("${tablebean.member.declaredName}"                , column.getJavaDeclaredName());
								
								ps.println(lineIL);
							}
						}
					}

					linesToParse = null;
				} else if (linesToParse != null) {
					linesToParse.add(line);
				} else if (line.indexOf("${jpaCopyedToDtoMembers.code}") >= 0) {
					for (Column column : definitiveColumns) {

						Table fTable = null;

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
														
							if( hasNomalizaedFKReferences(fTable, column) ){
								//ps.println("        this." + column.getJavaDeclaredObjectName() + " = jpaEntity.get" + FormatString.getCadenaHungara(fTable.getName()) + "().get" + FormatString.getCadenaHungara(fTable.getJPAPK()) + "(); // normalized ");
								ps.println("        this." + column.getJavaDeclaredObjectName() + " = jpaEntity.get" + FormatString.getCadenaHungara(fTable.getName()) + "()!=null?jpaEntity.get" + FormatString.getCadenaHungara(fTable.getName()) + "().get" + FormatString.getCadenaHungara(fTable.getJPAPK()) + "():null; // normalized ");
							}else{
								ps.println("        this." + column.getJavaDeclaredObjectName() + " = jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "()!=null?jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "().get" + FormatString.getCadenaHungara(fTable.getJPAPK()) + "():null; // custom");
							}
							
						} else {
							ps.println("        this." + column.getJavaDeclaredObjectName() + " = jpaEntity.get" + FormatString.getCadenaHungara(column.getName()) + "(); // primitive");
						}
					}
				} else if (line.indexOf("${dtoCopyedToJpaMembers.code}") >= 0) {
					for (Column column : definitiveColumns) {
						Table fTable = null;

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
							
						} else {

							ps.println("        jpaEntity.set" + FormatString.getCadenaHungara(column.getName()) + "( this.get" + FormatString.getCadenaHungara(column.getName()) + "());");
						}

					}
				} else {					
					line = line.replace("${date}", sdf.format(new Date()));
					line = line.replace("${tablebean.serialId}", String.valueOf(table.hashCode()));
					line = line.replace("${tablebean.name}", table.getName());
					line = line.replace("${tablebean.declaredName}", table.getJavaDeclaredName());
					line = line.replace("${tablebean.countPKs}", String.valueOf(table.getPrimaryKeys().size()));					
					line = line.replace("${tablebean.hashCodeSumCode}", table.getHashCodeSumCode());					
					line = line.replace("${tablebean.equalsCode}", table.getEqualsCode());
					line = line.replace("${tablebean.toStringCode}", table.getToDTOStringCode(dbSet, dtoPackageBeanMember));
					line = line.replace("${tablebean.name.uc}", table.getName().toUpperCase());
					line = line.replace("${tablebean.package}", dtoPackageBeanMember);
					
					ps.println(line);
				}
			}
			//-------------------------------------------------------
			ps.close();
			fos.close();

			sourceFile = null;
			ps = null;
			fos = null;
		}
	}
	
	public static void buildDAOs(DBTableSet dbSet, String dtoPackageBeanMember,String daoPackage, String basePath,boolean jpaCompatibleFKs)
			throws Exception {
		String fileName;
		File baseDir = null;
		File dirSourceFile = null;
		File sourceFile = null;
		System.err.println("-->> buildDAOs");
		FileOutputStream fos = null;
		PrintStream ps = null;
		BufferedReader br = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String collectionClass = "Collection";

		Enumeration<String> tableNames = dbSet.getTableNames();
		ArrayList<Table> tablesForGeneration = new ArrayList<Table>();		
		if(jpaCompatibleFKs){
			while (tableNames.hasMoreElements()) {
				Table simpleTable = dbSet.getTable(tableNames.nextElement());
				if (!simpleTable.isManyToManyTableWinthMoreColumns()) {
					//System.err.println("-->> + " + simpleTable.getName());
					tablesForGeneration.add(simpleTable);

					Iterator<Column> itFKC = simpleTable.getSortedColumnsForJPA();
					boolean addedAsFKEmbedded = false;
					while (itFKC.hasNext()) {
						Column cctJpaC = itFKC.next();
						if (cctJpaC instanceof EmbeddeableColumn) {
							//System.err.println("\t-->> + " + cctJpaC.getName());
							tablesForGeneration.add((EmbeddeableColumn) cctJpaC);
							addedAsFKEmbedded = true;
						}
					}

					if (addedAsFKEmbedded) {
					}

				} else {
					//System.err.println("-->> [X] Many 2 Many : " + simpleTable.getName());
				}
			}
		} else{
			while (tableNames.hasMoreElements()) {
				Table simpleTable = dbSet.getTable(tableNames.nextElement());				
				System.err.println("-->> + " + simpleTable.getName());
				tablesForGeneration.add(simpleTable);
			}
		}
		System.err.println("==============================>>> ");
		for (Table table : tablesForGeneration) {

			System.err.println("-->> generating: for " + table.getJavaDeclaredName() );

			Iterator<Column> columnsToGenerate = null;
			if(jpaCompatibleFKs){
				columnsToGenerate = table.getSortedColumnsForJPA();
			}else{
				columnsToGenerate = table.getColums().iterator();
			}

			List<Column> definitiveColumns = new ArrayList();
			while (columnsToGenerate.hasNext()) {
				Column c = columnsToGenerate.next();
				definitiveColumns.add(c);
				//System.err.println("\t\t-->> DefinitiveColumn: " + c);
			}

			//-------------------------------------------------------
			baseDir = new File(basePath);

			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}

			fileName = daoPackage.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + table.getJavaDeclaredName() + "DAO.java";
			System.err.println("\t-->> file: " + fileName);
			
			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);
			
			StringBuffer sbCols      = new StringBuffer();
			StringBuffer sbPKCols    = new StringBuffer();
			StringBuffer sbColsUpdate= new StringBuffer();
			StringBuffer sbColsParams= new StringBuffer();
			Iterator<Column> itCols = table.getSortedColumns();
			int pkc=0;
			int npkc=0;
			Column tablePKColumn =null;
			for(int icr=0;itCols.hasNext();icr++){
				Column col=itCols.next();
				if(icr>0){
					sbCols.append(",");
					sbColsParams.append(",");
				}
				
				sbCols.append(col.getName().toUpperCase());
				sbColsParams.append("?");
				
				if(col.isPrimaryKey()){
					tablePKColumn = col;
					if(icr>0){
						sbPKCols.append(",");						
					}
					pkc++;
					sbPKCols.append(col.getName().toUpperCase());
				} else{
					if(npkc>0){
						sbPKCols.append(",");
						sbColsUpdate.append(",");
					}
					npkc++;
					sbColsUpdate.append(col.getName().toUpperCase());
					sbColsUpdate.append("=?");					
				}
			}
			
			String allCols=sbCols.toString();
			String pksCols=sbPKCols.toString();
			String collToUpdate=sbColsUpdate.toString();
			String colsParams=sbColsParams.toString();
			
			br = new BufferedReader(new InputStreamReader(
					fos.getClass().getResourceAsStream("/templates/TableDAO.java.template")));
			String line = null;
			ArrayList<String> linesToParse = null;
			int nl = 0;
			while ((line = br.readLine()) != null) {

				if (line.indexOf("%foreach") >= 0) {
					linesToParse = new ArrayList<String>();
				} else if (line.indexOf("%endfor") >= 0) {
					int numColumnGenerating = 0;

					for (Column column : definitiveColumns) {
						numColumnGenerating++;

						Table fTable = null;
						String refObjFK = null;

						if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
						} else {
							fTable = null;
						}
						boolean skipPKMemberLine=false;
						for (String lineInLoop : linesToParse) {
							String lineIL = lineInLoop;
							skipPKMemberLine=false;
							String jc=column.getJavaClassType();
							boolean blob=false;
							if(jc.equals("byte[]")){
								//ps.println("\t\t\t\t// name="+column.getName()+", javaClsassType="+column.getJavaClassType()+", javaDeclaredName="+column.getJavaDeclaredName()+", PK?"+column.isPrimaryKey());
								blob=true;
								if(lineIL.contains("${tablebean.member.setter}")){
									ps.println("\t\t\t\tBlob bc=rs.getBlob(\""+column.getName().toUpperCase()+"\");");
									lineIL = lineIL.replace("${tablebean.member.setter}", "set"+column.getJavaDeclaredName());
									lineIL = lineIL.replace("rs.get${tablebean.member.javaClass}(\"${tablebean.member.name}\")", "bc.getBytes(0,(int)bc.length())");
								} else if(lineIL.contains("${tablebean.member.getter}")||lineIL.contains("${tablebean.memberNotPK.getter}")){
									lineIL = lineIL.replace("${tablebean.member.javaClass}", "Blob");									
									lineIL = lineIL.replace("${tablebean.memberNotPK.javaClass}", "Blob");
									lineIL = lineIL.replace("x.${tablebean.member.getter}(", "new ByteArrayInputStream(x.getContenidoOriginalXml()");
									lineIL = lineIL.replace("x.${tablebean.memberNotPK.getter}(", "new ByteArrayInputStream(x.getContenidoOriginalXml()");
								}
							} else {
								lineIL = lineIL.replace("${tablebean.member.setter}", "set"+column.getJavaDeclaredName());
								lineIL = lineIL.replace("${tablebean.member.javaClass}", FormatString.firstLetterUpperCase(jc.replace("java.lang.", "").replace("java.util.", "").replace("Integer","Int")));
							}
							
							lineIL = lineIL.replace("${tablebean.member.name}"                        , column.getName().toUpperCase());								
							lineIL = lineIL.replace("${tablebean.member.javaIdentifier}"              , column.getJavaDeclaredObjectName());
							lineIL = lineIL.replace("${tablebean.member.javaClass}"                   , column.getJavaClassType());
							lineIL = lineIL.replace("${tablebean.member.valueGetter}"                 , column.getValueGetter());		
							lineIL = lineIL.replace("${tablebean.member.jsonObjValueGetter}"          , column.getJsonObjValueGetter());
							lineIL = lineIL.replace("${tablebean.member.jsonObjGetValue}"             , column.getJsonObjGetValue());								
							lineIL = lineIL.replace("${tablebean.member.nativeGetter}"                , column.getNativeGetter());
							lineIL = lineIL.replace("${tablebean.member.getterNative}"                , column.getGetterNative());
							lineIL = lineIL.replace("${tablebean.member.setterNative}"                , column.getSetterNative());
							lineIL = lineIL.replace("${tablebean.member.getterCast}"                  , column.getValueCast());
							lineIL = lineIL.replace("${tablebean.member.callGetter}"                  , "get"+column.getJavaDeclaredName());
							lineIL = lineIL.replace("${tablebean.member.callSetter}"                  , "set"+column.getJavaDeclaredName());
							lineIL = lineIL.replace("${tablebean.member.nullableExpresion}"           , column.getNullableExpression("dto"));
							lineIL = lineIL.replace("${tablebean.member.declaredName}"                , column.getJavaDeclaredName());

							if(column.isPrimaryKey()){
								if(lineIL.contains("${tablebean.memberNotPK.javaClass}")){
									skipPKMemberLine=true;
								} else {
									lineIL = lineIL.replace("${tablebean.memberPK.setter}", "set"+column.getJavaDeclaredName());
									lineIL = lineIL.replace("${tablebean.memberPK.getter}", "get"+column.getJavaDeclaredName());									
									ps.println("            //2: javaClassType:"+jc);
									if(jc.equals("java.util.Date")){
										lineIL = lineIL.replace("${tablebean.memberNotPK.javaClass}", FormatString.firstLetterUpperCase(jc.replace("java.util.", "")));
										if(lineIL.contains("x.get")){
											lineIL = lineIL.replace("x.get", "new java.util.Date(x.get").replace(");", ".getTime()));");										
										}
									}else {
										lineIL = lineIL.replace("${tablebean.memberPK.javaClass}", FormatString.firstLetterUpperCase(jc.replace("java.lang.", "").replace("java.util.", "").replace("Integer","Int")));
									}
									
								}
							}else{								
								
								lineIL = lineIL.replace("${tablebean.memberNotPK.setter}", "set"+column.getJavaDeclaredName());
								lineIL = lineIL.replace("${tablebean.memberNotPK.getter}", "get"+column.getJavaDeclaredName());
								ps.println("            //3: javaClassType:"+jc);
								if(jc.equals("java.util.Date")){
									lineIL = lineIL.replace("${tablebean.memberNotPK.javaClass}", FormatString.firstLetterUpperCase(jc.replace("java.util.", "")));
									
									if(lineIL.contains("x.get")){
										lineIL = lineIL.replace("x.get", "new java.util.Date(x.get").replace(");", ".getTime()));");										
									}
								}else{
									lineIL = lineIL.replace("${tablebean.memberNotPK.javaClass}", FormatString.firstLetterUpperCase(jc.replace("java.lang.", "").replace("java.util.", "").replace("Integer","Int")));
								};
							}
							
							if(! skipPKMemberLine){
								ps.println(lineIL);
							}
							
						}
					}

					linesToParse = null;
				} else if (linesToParse != null) {
					
					linesToParse.add(line);
				} else {
					line = line.replace("${date}", sdf.format(new Date()));
					line = line.replace("${tablebean.serialId}", String.valueOf(table.hashCode()));
					line = line.replace("${tablebean.name}", table.getName().toUpperCase());
					line = line.replace("${tablebean.declaredName}", table.getJavaDeclaredName());					
					line = line.replace("${tablebean.hashCodeSumCode}", table.getHashCodeSumCode());
					line = line.replace("${tablebean.equalsCode}", table.getEqualsCode());
					line = line.replace("${tablebean.toStringCode}", table.getToDTOStringCode(dbSet, dtoPackageBeanMember));
					line = line.replace("${tablebean.package}", dtoPackageBeanMember);
					line = line.replace("${tablebean.listColumns}", allCols);
					line = line.replace("${tablebean.listParamColumns}", colsParams);
					line = line.replace("${tablebean.listColumns4Update}", collToUpdate);
					line = line.replace("${tablebean.columnList}", table.getListColumnsNames());
					line = line.replace("${tablebean.listMatchers4PS}", table.getListMatchers4PS());
					
					line = line.replace("${dao.package}", daoPackage);
					
					ps.println(line);
				}
			}
			//-------------------------------------------------------
			ps.close();
			fos.close();

			sourceFile = null;
			ps = null;
			fos = null;
		}
	}
	
	
	private static String membersParameters(Table table, DBTableSet dbSet) {
		StringBuffer sb = new StringBuffer();

		String varName = null;
		String varClassName = null;
		String refObjFK = null;

		Iterator<Column> simpleColumnsIterator = table.getSortedColumnsForJPA();

		for (int numColumnGenerating = 0; simpleColumnsIterator.hasNext(); numColumnGenerating++) {

			Column column = simpleColumnsIterator.next();
			if (!column.isPrimaryKey()) {
				continue;
			}

			if (numColumnGenerating > 0) {
				sb.append(", ");
			}

			if (column.isForeignKey() && !table.isManyToManyTableWinthMoreColumns() && !table.getName().toUpperCase().endsWith("_P_K")) {
				Table fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
				if (table instanceof EmbeddeableColumn) {
					refObjFK = column.getJavaClassType().replace("java.lang.", "");
				} else {
					refObjFK = FormatString.getCadenaHungara(fTable.getName());
				}
				varClassName = refObjFK;

				if (table instanceof EmbeddeableColumn && column.isForeignKey()) {
					varName = column.getJavaDeclaredObjectName();

				} else {
					varName = fTable.getJavaDeclaredObjectName();
				}
			} else {
				varClassName = column.getJavaClassType().replace("java.lang.", "");
				varName = column.getJavaDeclaredObjectName();
			}

			sb.append(varClassName);
			sb.append(" ");
			sb.append(varName);
		}

		return sb.toString();
	}

	private static String membersParametersInitCode(Table table, DBTableSet dbSet) {
		StringBuffer sb = new StringBuffer();

		String varName = null;
		String varClassName = null;
		String refObjFK = null;

		Iterator<Column> simpleColumnsIterator = table.getSortedColumnsForJPA();

		for (int numColumnGenerating = 0; simpleColumnsIterator.hasNext(); numColumnGenerating++) {

			Column column = simpleColumnsIterator.next();
			if (!column.isPrimaryKey()) {
				continue;
			}

			if (numColumnGenerating > 0) {
				sb.append("        ");
			}

			if (column.isForeignKey() && !table.isManyToManyTableWinthMoreColumns() && !table.getName().toUpperCase().endsWith("_P_K")) {
				Table fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
				if (table instanceof EmbeddeableColumn) {
					refObjFK = column.getJavaClassType().replace("java.lang.", "");
				} else {
					refObjFK = FormatString.getCadenaHungara(fTable.getName());
				}
				varClassName = refObjFK;

				if (table instanceof EmbeddeableColumn && column.isForeignKey()) {
					varName = column.getJavaDeclaredObjectName();

				} else {
					varName = fTable.getJavaDeclaredObjectName();
				}
			} else {
				varClassName = column.getJavaClassType().replace("java.lang.", "");
				varName = column.getJavaDeclaredObjectName();
			}

			sb.append("this.");
			sb.append(varName);
			sb.append(" \t= \t");
			sb.append(varName);
			sb.append(";\n");
		}

		return sb.toString();
	}

	private static boolean hasNomalizaedFKReferences(Table fTable, Column column) {
		String x= (fTable.getName()+"_"+fTable.getJPAPK()).toLowerCase();
		String y= column.getName().toLowerCase();
		return x.equals(y);
	}

}
