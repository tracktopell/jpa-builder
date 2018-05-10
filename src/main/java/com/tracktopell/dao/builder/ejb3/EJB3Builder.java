package com.tracktopell.dao.builder.ejb3;

import com.tracktopell.dao.builder.FormatString;
import com.tracktopell.dao.builder.metadata.Column;
import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.metadata.EmbeddeableColumn;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * com.tracktopell.dao.builder.ejb3.EJB3Builder
 * @author tracktopell
 */
public class EJB3Builder {
    public static final String FETCHTYPE_LAZY  = "LAZY";
    public static final String FETCHTYPE_EAGER = "EAGER";
    public static final String FETCHTYPE_DEFAULT = "DEFAULT";
	private static String defaultValueFetchType = FETCHTYPE_DEFAULT;

    public static void setDefaultValueFetchType_EAGER() {
        EJB3Builder.defaultValueFetchType = FETCHTYPE_EAGER;
    }
    
    public static void setDefaultValueFetchType_LAZY() {
        EJB3Builder.defaultValueFetchType = FETCHTYPE_LAZY;
    }
    
    public static void setDefaultValueFetchType_DEFAULT() {
        EJB3Builder.defaultValueFetchType = FETCHTYPE_DEFAULT;
    }
    
    
    
	public static void buildMappingBeans(DBTableSet dbSet, String schemmaName,String packageBeanMember, String basePath)
			throws Exception {
		String fileName;
		File baseDir = null;
		File dirSourceFile = null;
		File sourceFile = null;

		FileOutputStream fos = null;
		PrintStream ps = null;
		BufferedReader br = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		final String collectionClass = "List";
		final String explainedM2OList = "_HAS_"; //"_THAT_HAS_THIS_";
		
		ArrayList<Table> tablesForGeneration = new ArrayList<Table>();
		Properties vp=VersionUtil.loadVersionProperties();
		
        System.err.println("====================== [ com.tracktopell.dao.builder.ejb3.EJB3Builder.buildMappingBeans ]========================");
        
		//System.err.println("Preparing Tables: ");			
		for (Table iterTable: dbSet.getTablesList()) {
			//System.err.println("Preparing Table: " + iterTable.getJavaDeclaredName());			
			if (!iterTable.isManyToManyTableWinthMoreColumns()) {				
				tablesForGeneration.add(iterTable);								
				Iterator<Column> itFKC = iterTable.getSortedColumnsForJPA();
				while (itFKC.hasNext()) {
					Column c = itFKC.next();					
					if (c instanceof EmbeddeableColumn) {						
						tablesForGeneration.add((EmbeddeableColumn) c);						
					}
				}
			}
		}
		//System.err.println("----------------->>Analizing"); 
		
		for (Table iterTable: tablesForGeneration) {
			//System.err.println("\tAnaliznig Table: " + iterTable.getName());
			if(iterTable.getSingularName()!=null){				
				//System.err.println("\tPreferred Java Name Table: " + iterTable.getSingularName());
			}
			List<Column>            plainColumns   = new ArrayList();
			List<EmbeddeableColumn> embededColumns = new ArrayList();
			
			iterTable.setPlainColumns(plainColumns);
			iterTable.setEmbededColumns(embededColumns);
			int countStringPrintable=0;
			if (! ( iterTable instanceof EmbeddeableColumn)) {
			
				Iterator<Column> itFKC = iterTable.getSortedColumnsForJPA();
				countStringPrintable = 0;
				while (itFKC.hasNext()) {
					Column c = itFKC.next();					
					if (c instanceof EmbeddeableColumn) {						
						embededColumns.add((EmbeddeableColumn)c);						
					} else {
						
						plainColumns.add(c);
						
						String suggested=null;
						String suggestedObjectName=null;
						String suggestedGettetObjectName=null;
						String suggestedSettetObjectName=null;
						Table fTable = null;
                        
                        if(c.isForeignDescription()){
                            countStringPrintable++;
                        }                        
                        
						if (c.isForeignKey() && !(iterTable instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(iterTable.getFKReferenceTable(c.getName()).getTableName());
							c.setFTable(fTable);
							
							final Collection<Column> ftPksCol = fTable.getPrimaryKeys();
							for(Column ftpk: ftPksCol){
								if(c.getName().toUpperCase().contains(ftpk.getName().toUpperCase())){
									if(fTable.getSingularName()!=null){
										suggested = fTable.getSingularName()+c.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");								
									}else{
										suggested = fTable.getName()+c.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");								
									}
									suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggested));
									suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggested);
									suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggested);

									c.setHyperColumnName(suggested);
									break;
								} else {
									suggested = c.getName().toUpperCase();								
									
									suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggested));
									suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggested);
									suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggested);

									c.setHyperColumnName(suggested);
									break;
								}
							}							
						}
					}
				}
				
                if(countStringPrintable==0){
                    Iterator<Column> itFKC2 = iterTable.getSortedColumnsForJPA();
                    int countTSx=0;
                    while(itFKC2.hasNext()){
                        Column cx2=itFKC2.next();
                        if(cx2.isPrimaryKey()){
                            cx2.setForeignDescription(true);
                            countTSx++;
                        }
                    }
                    if(countTSx==0){
                        throw new IllegalStateException("Table '"+iterTable.getName()+"', Needs PK's !");
                    }
                }
                
				Collection<Table> m2mTables = dbSet.getManyToManyRelationTables(iterTable);

				for (Table m2mTable : m2mTables) {
					//System.err.println("\t\t\t* -- [M2M] "+m2mTable.getName()+" {"+(m2mOT!=null?m2mOT.getName():"-------")+"}");
					iterTable.getM2mTableList().add(m2mTable);
				}
				
				Collection<Table> o2mTables = dbSet.getOneToManyRelationTables(iterTable);
				for (Table o2mTable : o2mTables) {
					//System.err.println("\t\t\t* -- [O2M] "+o2mTable.getName());
					iterTable.getO2mTableList().add(o2mTable);
				}
				
			} else {				
				Iterator<Column> itFKC = iterTable.getSortedColumnsForJPA();				
				while (itFKC.hasNext()) {
					Column c = itFKC.next();
					plainColumns.add(c);
				}
			}
			
			
			for(Column dc:plainColumns){
				if(dc.isForeignKey()){
					//System.err.println("\t\t\tN " +(dc.isPrimaryKey()?"PK":"--")+" [M20] "+dc.getName());
				} else{
					//System.err.println("\t\t\tN " +(dc.isPrimaryKey()?"PK":"--")+" [---] "+dc.getName());
				}				
			}
			for(EmbeddeableColumn ec:embededColumns){
				//System.err.println("\t\t\tE " +(ec.isPrimaryKey()?"PK":"--")    +" [EMD] "+ec.getName());
			}
			
			for(Table m2mTable:iterTable.getM2mTableList()){
				Table m2mOT = dbSet.getTableOwnerManyToManyRelation(iterTable, m2mTable);
				//System.err.println("\t\t\t* -- [M2M] "+m2mTable.getName()+" {"+(m2mOT!=null?m2mOT.getName():"-------")+"}");
			}
			for(Table o2mTable:iterTable.getO2mTableList()){
				//System.err.println("\t\t\t* -- [O2M] "+o2mTable.getName());
			}
		}
		//System.err.println("================== @JPA BEAN CODE GENERATION ========================>>> ");
        boolean auditableInterfaceGenerated=false;
        boolean auditableInterfaceForceInclude=true;
		for (Table table : tablesForGeneration) {
			System.err.println("------------->> Generating: "+table.getJavaDeclaredName()+".java for Table:"+table.getName()+", is Auditable?"+(table.isAuditable()));
            
            if( ( auditableInterfaceForceInclude || table.isAuditable()) && !auditableInterfaceGenerated){
                generateAuditableEntityInterface( packageBeanMember, basePath);
                auditableInterfaceGenerated=true;
            }
            
			//-------------------------------------------------------
			baseDir = new File(basePath);

			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}

			fileName = packageBeanMember.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			if(table.getSingularName()!=null){
				fileName = dirSourceFile.getPath() + File.separator + table.getSingularNameJavaDeclaredName()+ ".java";
			} else {
				fileName = dirSourceFile.getPath() + File.separator + table.getJavaDeclaredName() + ".java";
			}
			
			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);
			if(table instanceof EmbeddeableColumn){
				br = new BufferedReader(new InputStreamReader(fos.getClass().getResourceAsStream("/templates/TablePKJPABean.java.template")));
			}else{
				br = new BufferedReader(new InputStreamReader(fos.getClass().getResourceAsStream("/templates/TableJPABean.java.template")));
			}
			
			String line = null;
			ArrayList<String> linesToParse = null;
			int nl = 0;
			
			List<Column> plainColumns = table.getPlainColumns();
			List<EmbeddeableColumn> embededColumns = table.getEmbededColumns();
			
			
			if(plainColumns == null){
				throw new IllegalStateException("For table:'"+table.getName()+"' Doesn't have List of definitive columns for generation!");
			}
			
			List<Column> allGenerableColumns = new ArrayList<Column>();
			
			allGenerableColumns.addAll(plainColumns);
			if( embededColumns !=null){
				for(EmbeddeableColumn eColumn: embededColumns){
					allGenerableColumns.add(eColumn);
				}
			}
			
			
			while ((line = br.readLine()) != null) {

				if (line.indexOf("%foreach") >= 0) {
					linesToParse = new ArrayList<String>();
				} else if (line.indexOf("%endfor") >= 0) {
					
					for (Column column : allGenerableColumns) {
						
						for (String lineInLoop : linesToParse) {
							if (lineInLoop.indexOf("${tablebean.member.javadocCommnet}") >= 0) {
								if (!table.isManyToManyTableWinthMoreColumns()) {
									if (column.getComments() != null) {
										ps.println("    ");
										ps.println("    /**");
										ps.println("    * Maps to COLUMN '"+column.getName()+"'");
										ps.println("    * " + column.getComments().replace("\n", "\n     * "));
										ps.println("    */");
									} else {
										String commentForced = column.getName().replace("_", " ");
										ps.println("    ");
										ps.println("    /**");
										ps.println("    * The '" + commentForced+"' Maps to COLUMN '"+column.getName()+"'");
										ps.println("    */");
									}
								}
							} else if (lineInLoop.indexOf("${tablebean.member.namedQuery}") >= 0) {
								String on = "";
								String vn = "";
								String vo = "";
								if(		column.getName().equalsIgnoreCase("FECHA_CREACION")		|| 
										column.getName().equalsIgnoreCase("CREADO_POR")			||
										column.getName().equalsIgnoreCase("FECHA_MODIFICACION")	||
										column.getName().equalsIgnoreCase("MODIFICADO_POR")){
									// NO GENERATION
								} else {
									vo = table.getName().toLowerCase().substring(0, 1);
									if(column.getFTable()!=null && column.getHyperColumnName()!=null){
										on = column.getHyperColumnObjectName();
										vn = column.getHyperColumnObjectName();
									} else if(column.getFTable()!=null){
										on = column.getFTable().getJavaDeclaredName();
										vn = column.getFTable().getJavaDeclaredObjectName();
									} else{
										on = column.getJavaDeclaredName();
										vn = column.getJavaDeclaredObjectName();
									}

									lineInLoop = lineInLoop.replace("${tablebean.member.namedQuery}", 
											"@NamedQuery(name = \""+table.getJavaDeclaredName()+
											".findBy"+on+"\", query = \"SELECT "+vo+" FROM "+table.getJavaDeclaredName()+" "+vo+" WHERE "+table.getName().toLowerCase().charAt(0)+"."+vn+" = :"+vn+"\")");
									ps.println(lineInLoop);
								}
							} else if (lineInLoop.indexOf("${tablebean.member.declaration}") >= 0) {
								ps.println("    ");
								
								if (table.isManyToManyTableWinthMoreColumns()) {	
									if (column instanceof EmbeddeableColumn) {										
										ps.println("    @EmbeddedId");
										ps.println("    private " + column.getJavaClassType().replace("java.lang.", "")
												+ " " + column.getJavaDeclaredObjectName() + ";");
									} else if (column.getFTable() != null) {
										ps.println("    @JoinColumn(name = \"" + column.getName().toUpperCase()
												+ "\" , referencedColumnName = \"" + table.getFKReferenceTable(column.getName()).getColumnName().toUpperCase() + "\", "
												+ " insertable = false, updatable = false)");
                                        if(!defaultValueFetchType.equals(FETCHTYPE_DEFAULT)){
                                            ps.println("    @ManyToOne(optional = " + column.isNullable() + ", fetch = FetchType."+defaultValueFetchType+")");
                                        }else{
                                            ps.println("    @ManyToOne(optional = " + column.isNullable() + " )");
                                        }
										if(column.getFTable()!=null && column.getHyperColumnName()!=null){
											ps.println("    private " + column.getFTable().getJavaDeclaredName()+" "+column.getHyperColumnObjectName()+";");
										}else {
											ps.println("    private " + column.getFTable().getJavaDeclaredName() + " " + FormatString.getCadenaHungara(column.getFTable().getJavaDeclaredName()) + ";");
										}
									} else {
										ps.println("    @Basic(optional = " + column.isNullable() + ")");
										if(!column.isNullable()){
											//ps.println("    // Hibernate Validator 5x is not compatible with validation-api 1.0.x");
											//ps.println("    //@NotNull");
										}
										String extraCoulmnDeclarationInfo="";
										if (column.getJavaClassType().equals("java.lang.String")) {
											extraCoulmnDeclarationInfo = ", length=" + column.getScale();
											if (!column.isNullable()) {												
												//ps.println("    //@Size(min = 1, max = "+column.getScale()+")");
											} else {
												//ps.println("    //@Size(max = "+column.getScale()+")");
											}
										}
										
										ps.println("    @Column(name = \"" + column.getName().toUpperCase() + "\", nullable= "+column.isNullable()+")");
										if (column.getSqlType().toLowerCase().equals("timestamp")) {
											ps.println("    @Temporal(TemporalType.TIMESTAMP)");
										} else if (column.getSqlType().toLowerCase().equals("datetime")) {
											ps.println("    @Temporal(TemporalType.DATE)");
										} else if (column.getSqlType().toLowerCase().equals("date")) {
											ps.println("    @Temporal(TemporalType.DATE)");
										}
										
										ps.println("    private " + column.getJavaClassType().replace("java.lang.", "") + " " + column.getJavaDeclaredObjectName() + ";");
									}
								} else {
									if (column.isPrimaryKey() && !column.isForeignKey()) {
										if (column instanceof EmbeddeableColumn) {
											ps.println("    @EmbeddedId");
										} else {
											if (!(table instanceof EmbeddeableColumn)) {
												ps.println("    @Id");
											}
											String extraCoulmnDeclarationInfo = "";

											//ps.println("    //@Basic(optional = false)");
											if (column.getJavaClassType().equals("java.lang.String")) {
												extraCoulmnDeclarationInfo = ", length=" + column.getScale();
												if (!column.isNullable()) {
													//ps.println("    //@Size(min = 1, max = "+column.getScale()+")");
												} else {
													//ps.println("    //@Size(max = "+column.getScale()+")");
												}
											}
											if (!column.isNullable()) {
												//ps.println("    // Hibernate Validator 5x is not compatible with validation-api 1.0.x");
												//ps.println("    //@NotNull");
											}
											ps.println("    @Column(name = \"" + column.getName().toUpperCase() + "\" " + extraCoulmnDeclarationInfo + ", nullable="+column.isNullable()+"  )");

											if (column.isAutoIncremment()) {
												ps.println("    @GeneratedValue(strategy=GenerationType.IDENTITY)");
												//ps.println("    //@GeneratedValue(strategy=GenerationType.AUTO)");
											}
										}
										if (column.getJavaClassType().equals("java.util.Date")) {
											ps.println("    @Temporal(TemporalType.TIMESTAMP)");
										} else if (column.getJavaClassType().equals("java.util.Calendar")) {
											ps.println("    @Temporal(TemporalType.DATE)");
										}
										
										ps.println("    private " + column.getJavaClassType().replace("java.lang.", "")
												+ " " + column.getJavaDeclaredObjectName() + ";");
									} else {
										if (column.getFTable() != null) {
																						
											ps.print("    @JoinColumn(name = \"" + column.getName().toUpperCase() + "\" , referencedColumnName = \"" + table.getFKReferenceTable(column.getName()).getColumnName().toUpperCase() + "\"");
											if (table.hasEmbeddedPK() && column.isPrimaryKey()) {
												ps.println(", insertable = false, updatable = false)");
											} else {
												ps.println(")");
											}
											if(!defaultValueFetchType.equals(FETCHTYPE_DEFAULT)){
                                                ps.println("    @ManyToOne(optional = " + column.isNullable() + ", fetch = FetchType."+defaultValueFetchType+")");
                                            }else{
                                                ps.println("    @ManyToOne(optional = " + column.isNullable() + " )");
                                            }
											if(column.getFTable()!=null && column.getHyperColumnName()!=null){
												ps.println("    private " + column.getFTable().getJavaDeclaredName()+" "+column.getHyperColumnObjectName()+";");
											}else {												
												ps.println("    private " + column.getFTable().getJavaDeclaredName() + " " + FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(column.getFTable().getJavaDeclaredName())) + ";");
											}
										} else {
											String extraCoulmnDeclarationInfo = "";
											ps.println("    @Basic(optional = " + column.isNullable() + ")");
											if (!column.isNullable()) {
												//ps.println("    // Hibernate Validator 5x is not compatible with validation-api 1.0.x");
												//ps.println("    //@NotNull");
											}
											if (column.getJavaClassType().equals("java.lang.String")) {
												extraCoulmnDeclarationInfo = ", length=" + column.getScale();
												if (!column.isNullable()) {
													//ps.println("    //@Size(min = 1, max = "+column.getScale()+")");
												} else {
													//ps.println("    //@Size(max = "+column.getScale()+")");
												}
											}
											if (column.getJavaClassType().equals("java.util.Date")) {
												ps.println("    @Temporal(TemporalType.TIMESTAMP)");
											} else if (column.getJavaClassType().equals("java.util.Calendar")) {
												ps.println("    @Temporal(TemporalType.DATE)");
											} else if (column.getJavaClassType().equals("java.lang.String")) {
												extraCoulmnDeclarationInfo = ", length=" + column.getScale();
											}
											ps.println("    @Column(name = \"" + column.getName().toUpperCase() + "\" " + extraCoulmnDeclarationInfo + ", nullable="+column.isNullable()+")");
											ps.println("    private " + column.getJavaClassType().replace("java.lang.", "")
													+ " " + column.getJavaDeclaredObjectName() + ";");
										}
									}
								}
                            } else if (lineInLoop.indexOf("${tablebean.member.toStringMinimal}") >= 0) {
                                if( column.isForeignDescription()){
                                    lineInLoop = lineInLoop.replace("${tablebean.member.toStringMinimal}", column.getJavaDeclaredObjectName());
                                    
                                    ps.println(lineInLoop);                                    
                                }                                
							} else if (lineInLoop.indexOf("${tablebean.member.javaIdentifier}") >= 0) {
								if (!column.isPrimaryKey()) {
									if(column.getFTable()!=null){										
										if(column.getHyperColumnName()!=null){
											lineInLoop = lineInLoop.replace("${tablebean.member.javaIdentifier}", column.getHyperColumnObjectName());
										}else{
											lineInLoop = lineInLoop.replace("${tablebean.member.javaIdentifier}", column.getFTable().getJavaDeclaredObjectName());
										}
									}else {
										lineInLoop = lineInLoop.replace("${tablebean.member.javaIdentifier}", column.getJavaDeclaredObjectName());
									}
								} else {
									if(column instanceof EmbeddeableColumn){
										lineInLoop = lineInLoop.replace("${tablebean.member.javaIdentifier}", column.getJavaDeclaredObjectName());
									}else{										
										boolean ePK=false;
										for(Column ic:allGenerableColumns){
											if(ic instanceof EmbeddeableColumn){
												ePK=true;
												break;
											}
										}
										if( ePK ){
											if(column.getFTable()!=null){
												if(column.getHyperColumnName()!=null){
													lineInLoop = lineInLoop.replace("${tablebean.member.javaIdentifier}", column.getHyperColumnObjectName());
												}else{
													lineInLoop = lineInLoop.replace("${tablebean.member.javaIdentifier}", column.getFTable().getJavaDeclaredObjectName());
												}
											}else {
												lineInLoop = lineInLoop.replace("${tablebean.member.javaIdentifier}", column.getJavaDeclaredObjectName());
											}
										} else {
											lineInLoop = lineInLoop.replace("${tablebean.member.javaIdentifier}", column.getJavaDeclaredObjectName());
										}										
									}									
								}
								ps.println(lineInLoop);
							} else if (lineInLoop.indexOf("${tablebean.member.getter}") >= 0) {
								if (!column.isPrimaryKey() ) {
									if(column.getFTable()!=null ){
										if (column.getHyperColumnName()!=null){
											ps.println("    public " + column.getFTable().getJavaDeclaredName()+" "+ column.getHyperColumnGetterName()+"(){ return this."+column.getHyperColumnObjectName()+" ; }");
										}else{
											ps.println("    public " + column.getFTable().getJavaDeclaredName()+" get" + column.getFTable().getJavaDeclaredName() + "() { return this." + column.getFTable().getJavaDeclaredObjectName() + ";}");
										}
									}else {
										ps.println("    public " + column.getJavaClassType().replace("java.lang.", "")+" get" + column.getJavaDeclaredName() + "() { return this." + column.getJavaDeclaredObjectName() + ";}");
									}
								} else {
									boolean ePK=false;
									for(Column ic:allGenerableColumns){
										if(ic instanceof EmbeddeableColumn){
											ePK=true;
											break;
										}
									}
									if( ePK ){										
										if(column.getFTable()!=null){
											if(column.getHyperColumnName()!=null){
												ps.println("    public " + column.getFTable().getJavaDeclaredName()+" "+ column.getHyperColumnGetterName()+"(){ return this."+column.getHyperColumnObjectName()+" ; }");
											}else{
												ps.println("    public " + column.getFTable().getJavaDeclaredName()+" get" + column.getFTable().getJavaDeclaredName() + "() { return this." + column.getFTable().getJavaDeclaredObjectName() + ";}");
											}
										}else {
											ps.println("    public " + column.getJavaClassType().replace("java.lang.", "")+" get" + column.getJavaDeclaredName() + "() { return this." + column.getJavaDeclaredObjectName() + ";}");
										}									
									} else{
										ps.println("    public " + column.getJavaClassType().replace("java.lang.", "")+" get" + column.getJavaDeclaredName() + "() { return this." + column.getJavaDeclaredObjectName() + ";}");
									}
								}
							} else if (lineInLoop.indexOf("${tablebean.member.setter}") >= 0) {
								if (!column.isPrimaryKey()) {
									if(column.getFTable()!=null){
										if(column.getHyperColumnName()!=null){
											ps.println("    public void " + column.getHyperColumnSetterName()+"("+column.getFTable().getJavaDeclaredName()+" x){ this."+column.getHyperColumnObjectName()+" = x; }");
										}else {
											ps.println("    public void set" + column.getFTable().getJavaDeclaredName()+ "(" + column.getFTable().getJavaDeclaredName() + " v) { this." + column.getFTable().getJavaDeclaredObjectName() + " = v; }");
										}
									}else{
										ps.println("    public void set" + FormatString.getCadenaHungara(column.getName())+ "(" + column.getJavaClassType().replace("java.lang.", "") + " v) { this." + column.getJavaDeclaredObjectName() + " = v; }");
									}
								} else {
									boolean ePK=false;
									for(Column ic:allGenerableColumns){
										if(ic instanceof EmbeddeableColumn){
											ePK=true;
											break;
										}
									}
									if( ePK ){										
										if(column.getFTable()!=null){
											if(column.getHyperColumnName()!=null){
												ps.println("    public void " + column.getHyperColumnSetterName()+"("+column.getFTable().getJavaDeclaredName()+" x){ this."+column.getHyperColumnObjectName()+" = x; }");
											}else {
												ps.println("    public void set" + column.getFTable().getJavaDeclaredName()+ "(" + column.getFTable().getJavaDeclaredName() + " v) { this." + column.getFTable().getJavaDeclaredObjectName() + " = v; }");
											}
										}else{
											ps.println("    public void set" + FormatString.getCadenaHungara(column.getName())+ "(" + column.getJavaClassType().replace("java.lang.", "") + " v) { this." + column.getJavaDeclaredObjectName() + " = v; }");
										}
									}else{
										ps.println("    public void set" + FormatString.getCadenaHungara(column.getName())+ "(" + column.getJavaClassType().replace("java.lang.", "") + " v) { this." + column.getJavaDeclaredObjectName() + " = v; }");
									}
									
								}
							} else {
								ps.println(lineInLoop);
							}
						}
					}

					linesToParse = null;
				} else if (linesToParse != null) {
					linesToParse.add(line);
				} else if (line.indexOf("${tablebean.oneToManyRelations.declarations}") >= 0) {
					
					for (Table posibleTableOneToMany : tablesForGeneration) {
						
						if(posibleTableOneToMany instanceof EmbeddeableColumn){
							continue;
						}
						
						Table  tableReferenceOneToMany = null;
						Column colmnMappedBy = null;
						String realSugestedCollectionName = null;
						
						for(Column cfk: posibleTableOneToMany.getFKs()){
							if(!cfk.isPrimaryKey() && cfk.getFTable().getName().equals(table.getName())){
								colmnMappedBy = cfk;
								
								if(posibleTableOneToMany.getSingularName()!=null){
									realSugestedCollectionName = posibleTableOneToMany.getSingularName()+explainedM2OList;
								}else{
									realSugestedCollectionName = posibleTableOneToMany.getName()+explainedM2OList;
								}
								
								if(cfk.getHyperColumnName()!=null){
									realSugestedCollectionName += cfk.getHyperColumnName()+"_"+collectionClass;
								}else{
									realSugestedCollectionName += cfk.getName()+"_"+collectionClass;
								}
								
								realSugestedCollectionName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(realSugestedCollectionName));
								
								ps.println("    /** " );
								ps.println("    * Map the relation to "+posibleTableOneToMany.getName()+" table where has "+cfk.getName()+" object mapped column of for this class." );
								ps.println("    */ " );
                                
								if(cfk.getHyperColumnName()!=null){
                                    if(!defaultValueFetchType.equals(FETCHTYPE_DEFAULT)){
                                        ps.println("    @OneToMany(cascade = CascadeType.ALL, mappedBy = \"" + cfk.getHyperColumnObjectName() + "\", fetch = FetchType."+defaultValueFetchType+")");
                                    }else{
                                        ps.println("    @OneToMany(cascade = CascadeType.ALL, mappedBy = \"" + cfk.getHyperColumnObjectName() + "\")");
                                    }
								}else if(cfk.getFTable()!=null){
                                    if(!defaultValueFetchType.equals(FETCHTYPE_DEFAULT)){
                                        ps.println("    @OneToMany(cascade = CascadeType.ALL, mappedBy = \"" + cfk.getFTable().getJavaDeclaredObjectName() + "\", fetch = FetchType."+defaultValueFetchType+")");
                                    }else{
                                        ps.println("    @OneToMany(cascade = CascadeType.ALL, mappedBy = \"" + cfk.getFTable().getJavaDeclaredObjectName() + "\")");
                                    }
								}else {
                                    if(!defaultValueFetchType.equals(FETCHTYPE_DEFAULT)){
                                        ps.println("    @OneToMany(cascade = CascadeType.ALL, mappedBy = \"" + cfk.getJavaDeclaredObjectName() + "\", fetch = FetchType."+defaultValueFetchType+")");
                                    }else{
                                        ps.println("    @OneToMany(cascade = CascadeType.ALL, mappedBy = \"" + cfk.getJavaDeclaredObjectName() + "\")");
                                    }
								}
								//ps.println("    // "+posibleTableOneToMany.getName()+" Well know as "+posibleTableOneToMany.getJavaDeclaredName());
								ps.println("    private " + collectionClass + "<" + posibleTableOneToMany.getJavaDeclaredName() + "> " + realSugestedCollectionName + ";");
								ps.println("    " );
							}
						}
					}
				} else if (line.indexOf("${tablebean.oneToManyRelations.gettersAndSetters}") >= 0) {
					for (Table posibleTableOneToMany : tablesForGeneration) {
						
						if(posibleTableOneToMany instanceof EmbeddeableColumn){
							continue;
						}
						
						Table  tableReferenceOneToMany = null;
						Column colmnMappedBy = null;
						String realSugestedCollectionName = null;
						
						for(Column cfk: posibleTableOneToMany.getFKs()){
							if(!cfk.isPrimaryKey() && cfk.getFTable().getName().equals(table.getName())){
								colmnMappedBy = cfk;
								
								
								if(posibleTableOneToMany.getSingularName()!=null){
									realSugestedCollectionName = posibleTableOneToMany.getSingularName()+explainedM2OList;
								}else{
									realSugestedCollectionName = posibleTableOneToMany.getName()+explainedM2OList;
								}
								
								if(cfk.getHyperColumnName()!=null){
									realSugestedCollectionName += cfk.getHyperColumnName()+"_"+collectionClass;
								}else{
									realSugestedCollectionName += cfk.getName()+"_"+collectionClass;
								}
								
								realSugestedCollectionName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(realSugestedCollectionName));
																
								ps.println("    public " + collectionClass + "<"+posibleTableOneToMany.getJavaDeclaredName()+"> get"+FormatString.firstLetterUpperCase(realSugestedCollectionName)+"(){ return this." + realSugestedCollectionName + "; }");
								ps.println("    public void set"+FormatString.firstLetterUpperCase(realSugestedCollectionName)+"(" + collectionClass + "<"+posibleTableOneToMany.getJavaDeclaredName()+"> v){ this." + realSugestedCollectionName + " = v; }");
								ps.println("    ");
							}
						}
					}
				} else if (line.indexOf("${tablebean.ManyToManyRelations.declarations}") >= 0) {
					
					Collection<Table> m2mTables = dbSet.getManyToManyRelationTables(table);

					for (Table fm2mTable : m2mTables) {						
						Table tableOwnerManyToManyRelation = dbSet.getTableOwnerManyToManyRelation(table, fm2mTable);
                        final HashMap<Integer,Column> rtColM2M = tableOwnerManyToManyRelation.getFKsForCreation();
                        
                        final Column rtCol1 = rtColM2M.get(1);
						final Column rtCol2 = rtColM2M.get(2);
                        
						//ps.println("    ");
                        //ps.println("    //# BUG: "+fm2mTable.getName());
                        //ps.println("    //# BUG: M2M:"+tableOwnerManyToManyRelation.getName()+", rtCol1["+rtCol1.getPosition()+"]="+rtCol1.getName()+", rtCol2["+rtCol2.getPosition()+"]="+rtCol2.getName());
                        //ps.println("    //# BUG: "+tableOwnerManyToManyRelation.getFKReferenceTable(rtCol1.getName()).getTableName()+" == "+table.getName()+"?"+(tableOwnerManyToManyRelation.getFKReferenceTable(rtCol1.getName()).getTableName().equalsIgnoreCase(table.getName())));
						if (!tableOwnerManyToManyRelation.getFKReferenceTable(rtCol1.getName()).getTableName().equalsIgnoreCase(table.getName())) {
							if(table.getSingularName()!=null){
                                if(!defaultValueFetchType.equals(FETCHTYPE_DEFAULT)){
                                    ps.println("    @ManyToMany(cascade = CascadeType.ALL,mappedBy = \"" + table.getSingularNameJavaDeclaredObjectName() + collectionClass + "\", fetch = FetchType."+defaultValueFetchType+")");
                                }else{
                                    ps.println("    @ManyToMany(cascade = CascadeType.ALL,mappedBy = \"" + table.getSingularNameJavaDeclaredObjectName() + collectionClass + "\")");
                                }
                                
							}else{
                                if(!defaultValueFetchType.equals(FETCHTYPE_DEFAULT)){
                                    ps.println("    @ManyToMany(cascade = CascadeType.ALL,mappedBy = \"" + FormatString.renameForJavaMethod(table.getName()) + collectionClass + "\", fetch = FetchType."+defaultValueFetchType+")");
                                }else{
                                    ps.println("    @ManyToMany(cascade = CascadeType.ALL,mappedBy = \"" + FormatString.renameForJavaMethod(table.getName()) + collectionClass + "\")");
                                }
							}
						} else {
                            if(!defaultValueFetchType.equals(FETCHTYPE_DEFAULT)){
                                ps.println("    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType."+defaultValueFetchType+")");
                            }else{
                                ps.println("    @ManyToMany(cascade = CascadeType.ALL)");
                            }
							ps.println("    @JoinTable(name               = \"" + tableOwnerManyToManyRelation.getName().toUpperCase() + "\",");
							ps.println("               joinColumns        = {@JoinColumn(name = \"" + rtCol1.getName().toUpperCase() + "\", referencedColumnName =\"" + tableOwnerManyToManyRelation.getFKReferenceTable(rtCol1.getName()).getColumnName().toUpperCase() + "\")},");
							ps.println("               inverseJoinColumns = {@JoinColumn(name = \"" + rtCol2.getName().toUpperCase() + "\", referencedColumnName =\"" + tableOwnerManyToManyRelation.getFKReferenceTable(rtCol2.getName()).getColumnName().toUpperCase() + "\")}");
							ps.println("               )");							
						}		
						
						if(fm2mTable.getSingularName()!=null){
							ps.println("    private " + collectionClass + "<" + fm2mTable.getSingularNameJavaDeclaredName() + "> " + fm2mTable.getSingularNameJavaDeclaredObjectName() + collectionClass + ";");
						}else{
							ps.println("    private " + collectionClass + "<" + FormatString.getCadenaHungara(fm2mTable.getName()) + "> " + FormatString.renameForJavaMethod(fm2mTable.getName()) + collectionClass + ";");
						}
						
						ps.println("    ");
					}
				} else if (line.indexOf("${tablebean.ManyToManyRelations.gettersAndSetters}") >= 0) {			
					Collection<Table> m2mTables = dbSet.getManyToManyRelationTables(table);
					for (Table fm2mTable : m2mTables) {
						if(fm2mTable.getSingularName()!=null){
							ps.println("    public " + collectionClass + "<" + fm2mTable.getSingularNameJavaDeclaredName() + "> " + fm2mTable.getSingularNameGetter() + collectionClass + "() { return this." + fm2mTable.getSingularNameJavaDeclaredObjectName() + collectionClass + "; }");						
							ps.println("    public void " + fm2mTable.getSingularNameSetter() + collectionClass + "(" + collectionClass + "<" + fm2mTable.getSingularNameJavaDeclaredName() + ">  v) { this." + fm2mTable.getSingularNameJavaDeclaredObjectName() + collectionClass + " = v; }");							
						}else{
							ps.println("    public " + collectionClass + "<" + FormatString.getCadenaHungara(fm2mTable.getName()) + "> get" + FormatString.getCadenaHungara(fm2mTable.getName()) + collectionClass + "() { return this." + FormatString.renameForJavaMethod(fm2mTable.getName()) + collectionClass + "; }");						
							ps.println("    public void set" + FormatString.getCadenaHungara(fm2mTable.getName()) + collectionClass + "(" + collectionClass + "<" + FormatString.getCadenaHungara(fm2mTable.getName()) + ">  v) { this." + FormatString.renameForJavaMethod(fm2mTable.getName()) + collectionClass + " = v; }");
						}
						ps.println("    ");
					}

				} else {
					line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
					line = line.replace("${date}", sdf.format(new Date()));
					line = line.replace("${tablebean.serialId}", String.valueOf(table.getName().hashCode()));
					line = line.replace("${tablebean.name}", table.getName());
					line = line.replace("${tablebean.declaredName}", table.getJavaDeclaredName());
                    if(table.isAuditable()){
                        line = line.replace("${tablebean.implementsAuditable}", ", AuditableEntity");
                    } else{
                        line = line.replace("${tablebean.implementsAuditable}", "");
                    }
					line = line.replace("${tablebean.namedQuery}", "@NamedQuery(name = \""+table.getJavaDeclaredName()+".findAll\", query = \"SELECT "+table.getName().toLowerCase().charAt(0)+" FROM "+table.getJavaDeclaredName()+" "+table.getName().toLowerCase().charAt(0)+"\")");
					line = line.replace("${tablebean.countAll.namedQuery}", "@NamedQuery(name = \""+table.getJavaDeclaredName()+".countAll\", query = \"SELECT COUNT("+table.getName().toLowerCase().charAt(0)+") FROM "+table.getJavaDeclaredName()+" "+table.getName().toLowerCase().charAt(0)+"\")");					
					line = line.replace("${tablebean.PKMembersParameters}", membersParameters(table, dbSet));

					if (table instanceof EmbeddeableColumn) {
						line = line.replace("${tablebean.jpa_entity_or_embeddeable}", "@Embeddable");
						line = line.replace("${tablebean.jpa_talbe}", "");
					} else {
						line = line.replace("${tablebean.jpa_entity_or_embeddeable}", "@Entity");
						//line = line.replace("${tablebean.jpa_talbe}", "@Table(name = \"" + table.getName() + "\", catalog=\""+schemmaName+"\", schema = \"\" )");
						line = line.replace("${tablebean.jpa_talbe}", "@Table(name = \"" + table.getName() + "\")");
						line = line.replace("${tablebean.id}", table.getJPAPK());
						line = line.replace("${tablebean.id.javaClass}", table.getJPAPKClass().replace("java.lang.", ""));
					}

					line = line.replace("${tablebean.hashCodeSumCode}", table.getHashCodeSumCode());
					line = line.replace("${tablebean.PKMembersParametersInitCode}", membersParametersInitCode(table, dbSet));
					line = line.replace("${tablebean.equalsCode}", table.getEqualsCode());
					line = line.replace("${tablebean.toStringCode}", table.getToStringCode(dbSet, packageBeanMember));
					line = line.replace("${tablebean.name.uc}", table.getName().toUpperCase());
					line = line.replace("${tablebean.package}", packageBeanMember);
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

			if (column.isForeignKey() && !table.isManyToManyTableWinthMoreColumns()) {
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

			if (column.isForeignKey() && !table.isManyToManyTableWinthMoreColumns()) {
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

	static void updatePersistenceXML(DBTableSet dbSet, String packageBeanMember, String path_2_Parsistence_xml) {

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

		InputStream is = null;
		BufferedReader br = null;
		try {
			is = new FileInputStream(path_2_Parsistence_xml);
			br = new BufferedReader(new InputStreamReader(is));

			String line = null;

			while ((line = br.readLine()) != null) {
				if (line.indexOf("${InsertDeclaration4JPABeans}") >= 0) {
					for (Table table : tablesForGeneration) {
						System.out.println("\t\t<class>" + packageBeanMember + "." + table.getJavaDeclaredName() + "</class>");
					}
				} else {
					System.out.println(line);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
		}
	}

	public static void buildReourceBoundleBeans(DBTableSet dbSet, String basePath,String prefixTableLabel)
			throws Exception {
		File baseDir = null;
		File sourceFile = null;

		FileOutputStream fos = null;
		PrintStream ps = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		baseDir = new File(basePath);
		if(!baseDir.exists()){
			baseDir.mkdirs();
		}
		
		sourceFile = new File(baseDir, "model_i18n_es.properties");
		fos =  new FileOutputStream(sourceFile);
		System.err.println("Tring to write to -->> + " + sourceFile.getAbsolutePath());
		ps = new PrintStream(fos);

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
		try{
			for (Table table : tablesForGeneration) {

				//ps.println("# -------- Labels Entity: " + table.getName());
				//ps.println("L_" + table.getJavaDeclaredName() + " = " + table.getLabel().toUpperCase());
				
                String tableLabel = null;
                if(table.getLabel()!=null){
                    tableLabel = table.getLabel().toUpperCase();
                } else{
                    tableLabel = table.getName();
                }
				char lastLetter = tableLabel.toCharArray()[tableLabel.length() - 1];
				if (lastLetter == 'A' || lastLetter == 'E' || lastLetter == 'I' || lastLetter == 'O' || lastLetter == 'U') {
					//ps.println("MENU_CRUD_" + table.getJavaDeclaredName().toUpperCase() + " = "+prefixTableLabel+" " + tableLabel + "S");
				} else {
					//ps.println("MENU_CRUD_" + table.getJavaDeclaredName().toUpperCase() + " = "+prefixTableLabel+" " + tableLabel.toUpperCase() + "ES");
				}

				//ps.println("LABEL_NEW_" + table.getJavaDeclaredName().toUpperCase() + " = AGREGAR " + table.getLabel().toUpperCase());
				//ps.println("LABEL_EDIT_" + table.getJavaDeclaredName().toUpperCase() + " = EDITAR " + table.getLabel().toUpperCase());

				Iterator<Column> columnsSortedColumnsForJPA = table.getSortedColumnsForJPA();
				List<Column> definitiveColumns = new ArrayList();
				while (columnsSortedColumnsForJPA.hasNext()) {
					Column c = columnsSortedColumnsForJPA.next();
					definitiveColumns.add(c);
					//System.err.println("\t-->> DefinitiveColumn: " + c);
					String c_javaDeclaredName = c.getJavaDeclaredName();
					String c_label = c.getLabel()!=null?c.getLabel():c.getName();

					ps.println("L_" + table.getJavaDeclaredName() + "." + c_javaDeclaredName + " = " + c_label.toUpperCase());
					//ps.println("TEXT_MAXCHARS_" + table.getJavaDeclaredName().toUpperCase() + "_" + c_javaDeclaredName.toUpperCase() + " = " + c.getScale());
					//ps.println("INPUT_REQUIRED_" + table.getJavaDeclaredName().toUpperCase() + "_" + c_javaDeclaredName.toUpperCase() + " = " + (!c.isNullable()));
				}
				ps.println();
			}
		}catch(Exception ex){
			ex.printStackTrace(System.err);
		}
		fos.close();
	}

	static void buildSSB(
            String interfaceRL,DBTableSet dbSet, String jpaPU, 
            String jpaPackageBeanMember, String rlsbPackageBeanMember, String ssbPackageBeanMember, 
            String basePathJPA         , String basePathRLSB         , String basePathESB) 
		throws IOException{
        
        String fileName;
		File baseDir = null;
		File dirSourceFile = null;
		File sourceFile = null;

		FileOutputStream fos = null;
		PrintStream ps = null;
		BufferedReader br = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		final String collectionClass = "List";
		final String explainedM2OList = "_HAS_"; //"_THAT_HAS_THIS_";
		
		ArrayList<Table> tablesForGeneration = new ArrayList<Table>();
		Properties vp=VersionUtil.loadVersionProperties();
        System.err.println("====================== [ com.tracktopell.dao.builder.jpa.JPABeanBuilder.buildSSB @"+interfaceRL+"]========================");
		
		for (Table iterTable: dbSet.getTablesList()) {
			//System.err.println("Preparing Table: " + iterTable.getJavaDeclaredName());			
			if (!iterTable.isManyToManyTableWinthMoreColumns()) {				
				tablesForGeneration.add(iterTable);								
				Iterator<Column> itFKC = iterTable.getSortedColumnsForJPA();
				while (itFKC.hasNext()) {
					Column c = itFKC.next();					
					if (c instanceof EmbeddeableColumn) {						
						tablesForGeneration.add((EmbeddeableColumn) c);						
					}
				}
			}
		}
		//System.err.println("----------------->>Analizing"); 
		List<Column>            plainColumns   = new ArrayList();
		List<EmbeddeableColumn> embededColumns = new ArrayList();
		
		for (Table iterTable: tablesForGeneration) {
			//System.err.println("\tAnaliznig Table: " + iterTable.getName());
			if(iterTable.getSingularName()!=null){				
				System.err.println("\tPreferred Java Name Table: " + iterTable.getSingularName());
			}
			plainColumns   = new ArrayList();
			embededColumns = new ArrayList();
			
			iterTable.setPlainColumns(plainColumns);
			iterTable.setEmbededColumns(embededColumns);
			
			if (! ( iterTable instanceof EmbeddeableColumn)) {
			
				Iterator<Column> itFKC = iterTable.getSortedColumnsForJPA();
				
				while (itFKC.hasNext()) {
					Column c = itFKC.next();					
					if (c instanceof EmbeddeableColumn) {						
						embededColumns.add((EmbeddeableColumn)c);						
					} else {
						
						plainColumns.add(c);
						
						String suggested=null;
						String suggestedObjectName=null;
						String suggestedGettetObjectName=null;
						String suggestedSettetObjectName=null;
						Table fTable = null;
						if (c.isForeignKey() && !(iterTable instanceof EmbeddeableColumn)) {
							fTable = dbSet.getTable(iterTable.getFKReferenceTable(c.getName()).getTableName());
							c.setFTable(fTable);
							
							final Collection<Column> ftPksCol = fTable.getPrimaryKeys();
							for(Column ftpk: ftPksCol){
								if(c.getName().toUpperCase().contains(ftpk.getName().toUpperCase())){
									if(fTable.getSingularName()!=null){
										suggested = fTable.getSingularName()+c.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");								
									}else{
										suggested = fTable.getName()+c.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");								
									}
									suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggested));
									suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggested);
									suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggested);

									c.setHyperColumnName(suggested);
									break;
								}
							}
							
						}
					}
				}
				
				Collection<Table> m2mTables = dbSet.getManyToManyRelationTables(iterTable);

				for (Table m2mTable : m2mTables) {
					//System.err.println("\t\t\t* -- [M2M] "+m2mTable.getName()+" {"+(m2mOT!=null?m2mOT.getName():"-------")+"}");
					iterTable.getM2mTableList().add(m2mTable);
				}
				
				Collection<Table> o2mTables = dbSet.getOneToManyRelationTables(iterTable);
				for (Table o2mTable : o2mTables) {
					//System.err.println("\t\t\t* -- [O2M] "+o2mTable.getName());
					iterTable.getO2mTableList().add(o2mTable);
				}
				
			} else {				
				Iterator<Column> itFKC = iterTable.getSortedColumnsForJPA();				
				while (itFKC.hasNext()) {
					Column c = itFKC.next();
					plainColumns.add(c);
				}
			}
			
			
			for(Column dc:plainColumns){
				if(dc.isForeignKey()){
					//System.err.println("\t\t\tN " +(dc.isPrimaryKey()?"PK":"--")+" [M20] "+dc.getName());
				} else{
					//System.err.println("\t\t\tN " +(dc.isPrimaryKey()?"PK":"--")+" [---] "+dc.getName());
				}				
			}
			for(EmbeddeableColumn ec:embededColumns){
				//System.err.println("\t\t\tE " +(ec.isPrimaryKey()?"PK":"--")    +" [EMD] "+ec.getName());
			}
			
			for(Table m2mTable:iterTable.getM2mTableList()){
				Table m2mOT = dbSet.getTableOwnerManyToManyRelation(iterTable, m2mTable);
				//System.err.println("\t\t\t* -- [M2M] "+m2mTable.getName()+" {"+(m2mOT!=null?m2mOT.getName():"-------")+"}");
			}
			for(Table o2mTable:iterTable.getO2mTableList()){
				//System.err.println("\t\t\t* -- [O2M] "+o2mTable.getName());
			}
		}
		System.err.println("============ @EJB Stateless Session Abstract BEAN CODE GENERATION =====================>>> ");
		String line = null;
		baseDir = new File(basePathESB);

		if (!baseDir.exists()) {
			baseDir.mkdirs();
		}

		fileName = ssbPackageBeanMember.replace(".", File.separator) + File.separator;

		dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
		if (!dirSourceFile.exists()) {
			dirSourceFile.mkdirs();
		}

		fileName = dirSourceFile.getPath() + File.separator + "AbstractFacade.java";		

		sourceFile = new File(fileName);
		fos = new FileOutputStream(sourceFile);
		ps = new PrintStream(fos);
		br = new BufferedReader(new InputStreamReader(fos.getClass().getResourceAsStream("/templates/SSBAF.java.template")));
		
		while ((line = br.readLine()) != null) {
			line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
			line = line.replace("${date}", sdf.format(new Date()));
			line = line.replace("${ssbean.package}"  , ssbPackageBeanMember);
            line = line.replace("${tablebean.package}"  , jpaPackageBeanMember);
			line = line.replace("${ssbinterface.package}", rlsbPackageBeanMember);
			ps.println(line);
		}
		br.close();
		ps.close();
		fos.close();
		
        //--------
        System.err.println("================== PaginatedResult.java CODE GENERATION ========================>>> ");
        
        fileName = (rlsbPackageBeanMember+".util").replace(".", File.separator) + File.separator;
        baseDir = new File(basePathRLSB);
        
        dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
        if (!dirSourceFile.exists()) {
            dirSourceFile.mkdirs();
        }
        
        fileName = dirSourceFile.getPath() + File.separator + File.separator  + "PaginatedResult.java";
        
		sourceFile = new File(fileName);
        
		fos = new FileOutputStream(sourceFile);
		ps = new PrintStream(fos);
		br = new BufferedReader(new InputStreamReader(fos.getClass().getResourceAsStream("/templates/PR.java.template")));
		
		while ((line = br.readLine()) != null) {
			line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
			line = line.replace("${date}", sdf.format(new Date()));
			line = line.replace("${ssbean.package}"  , ssbPackageBeanMember);
            line = line.replace("${tablebean.package}"  , jpaPackageBeanMember);
			line = line.replace("${ssbinterface.package}", rlsbPackageBeanMember);
			ps.println(line);
		}
		br.close();
		ps.close();
		fos.close();
		
		System.err.println("================== @EJB Remote Stateless Session BEAN CODE GENERATION ========================>>> ");
		for (Table table : tablesForGeneration) {
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
				String suggested=null;
				String suggestedObjectName=null;
				String suggestedGettetObjectName=null;
				String suggestedSettetObjectName=null;
				Table fTable = null;
				
				if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
					fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
					column.setFTable(fTable);
					
					final Collection<Column> ftPksCol = fTable.getPrimaryKeys();
					for(Column ftpk: ftPksCol){
						if(column.getName().toUpperCase().contains(ftpk.getName().toUpperCase())){
							if(fTable.getSingularName()!=null){
								suggested = fTable.getSingularName()+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");								
							}else{
								suggested = fTable.getName()+column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(),"");								
							}
							suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggested));
							suggestedGettetObjectName = "get"+FormatString.getCadenaHungara(suggested);
							suggestedSettetObjectName = "set"+FormatString.getCadenaHungara(suggested);

							column.setHyperColumnName(suggested);
							break;
						}
					}					
				} else {
					fTable = null;
				}				
				definitiveColumns.add(column);				
			}

			baseDir = new File(basePathRLSB);

			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}

			fileName = rlsbPackageBeanMember.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + table.getJavaDeclaredName()+"Facade"+interfaceRL+".java";		

			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);
			br = new BufferedReader(new InputStreamReader(fos.getClass().getResourceAsStream("/templates/SSBF_LR.java.template")));

			while ((line = br.readLine()) != null) {
				line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
				line = line.replace("${date}", sdf.format(new Date()));
				line = line.replace("${rssbean.package}"  , rlsbPackageBeanMember);
				line = line.replace("${ssf_lr_bean.package}", rlsbPackageBeanMember);
				line = line.replace("${ssbean.package}"  , ssbPackageBeanMember);				
				line = line.replace("${tablebean.package}"  , jpaPackageBeanMember);
				line = line.replace("${tablebean.name}", table.getName());
				line = line.replace("${tablebean.declaredName}", table.getJavaDeclaredName());
                line = line.replace("${tablebean.declaredInterface}", interfaceRL);                
                line = line.replace("${tablebean.declaredObjectName}", table.getJavaDeclaredObjectName());
				line = line.replace("${JPA.PU}", jpaPU);
				ps.println(line);
			}
			br.close();
			ps.close();
			fos.close();
			
			sourceFile = null;
			ps = null;
			fos = null;
			//==================================================================
			baseDir = new File(basePathESB);

			if (!baseDir.exists()) {
				baseDir.mkdirs();
			}

			fileName = ssbPackageBeanMember.replace(".", File.separator) + File.separator;

			dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
			if (!dirSourceFile.exists()) {
				dirSourceFile.mkdirs();
			}

			fileName = dirSourceFile.getPath() + File.separator + table.getJavaDeclaredName()+"Facade.java";		

			sourceFile = new File(fileName);
			fos = new FileOutputStream(sourceFile);
			ps = new PrintStream(fos);
			br = new BufferedReader(new InputStreamReader(fos.getClass().getResourceAsStream("/templates/SSB.java.template")));

			while ((line = br.readLine()) != null) {
				line = line.replace("${version}", vp.getProperty(VersionUtil.PROJECT_VERSION));
				line = line.replace("${date}", sdf.format(new Date()));
				line = line.replace("${rssbean.package}"  , rlsbPackageBeanMember);
				line = line.replace("${ssbinterface.package}", rlsbPackageBeanMember);
				line = line.replace("${tablebean.declaredInterface}", table.getJavaDeclaredName()+"Facade"+interfaceRL);
                line = line.replace("${tablebean.declaredI}", interfaceRL.substring(0, 1));
				line = line.replace("${ssbean.package}"  , ssbPackageBeanMember);
				line = line.replace("${tablebean.package}"  , jpaPackageBeanMember);
				line = line.replace("${tablebean.name}", table.getName());
				line = line.replace("${tablebean.declaredName}", table.getJavaDeclaredName());                
                line = line.replace("${tablebean.declaredObjectName}", table.getJavaDeclaredObjectName());
				if(line.contains("${tablebean.prepareQuery}")){
					line = line.replace("${tablebean.prepareQuery}", "");
					for(Column ci:definitiveColumns){
						String vn="";
						String vo="";
						String cmp = "!= null";						
						if(ci.getHyperColumnName() != null){
							vn = FormatString.getCadenaHungara(ci.getHyperColumnName());
							vo = ci.getHyperColumnObjectName();
						} else if( ci.getFTable()!= null){
							vn = ci.getFTable().getSingularNameJavaDeclaredName();
							vo = ci.getFTable().getSingularNameJavaDeclaredObjectName();
						} else {
							if(	ci.getJavaClassType().equals("byte") ||
								ci.getJavaClassType().equals("short") ||
								ci.getJavaClassType().equals("int")   ||
								ci.getJavaClassType().equals("long")  ){
								cmp = " != 0";
							} else if(	ci.getJavaClassType().equals("double")){
								cmp = " != 0.0";
							} else if(	ci.getJavaClassType().equals("float")){
								cmp = " != 0.0f";
							}
							vn = ci.getJavaDeclaredName();
							vo = ci.getJavaDeclaredObjectName();
						}                        
						ps.println("			if(x.get"+vn+"() "+cmp+"){");
						ps.println("			    paramAsigned++;");
						ps.println("			    sbq.append(\" and x."+vo+" = :"+vo+"\");");
						ps.println("			}");
					}
				} else if(line.contains("${tablebean.fillQuery}")){
					line = line.replace("${tablebean.fillQuery}", "");
					for(Column ci:definitiveColumns){						
						String vn="";
						String vo="";
						String cmp = "!= null";
						if(ci.getHyperColumnName() != null){
							vn = FormatString.getCadenaHungara(ci.getHyperColumnName());
							vo = ci.getHyperColumnObjectName();
						} else if( ci.getFTable()!= null){
							vn = ci.getFTable().getSingularNameJavaDeclaredName();
							vo = ci.getFTable().getSingularNameJavaDeclaredObjectName();
						} else {
							if(	ci.getJavaClassType().equals("byte") ||
								ci.getJavaClassType().equals("short") ||
								ci.getJavaClassType().equals("int")   ||
								ci.getJavaClassType().equals("long")  ){
								cmp = " != 0";
							} else if(	ci.getJavaClassType().equals("double")){
								cmp = " != 0.0";
							} else if(	ci.getJavaClassType().equals("float")){
								cmp = " != 0.0f";
							}
							vn = ci.getJavaDeclaredName();
							vo = ci.getJavaDeclaredObjectName();
						}                        
						ps.println("			if(x.get"+vn+"() "+cmp+"){");
						ps.println("			    nq.setParameter(\""+vo+"\",x.get"+vn+"());");						
						ps.println("			}");
					}
				} else if(line.contains("${tablebean.collectionMember.eagerInitializerCode}")){
                    line = "";
                    
                    for(Column ci:definitiveColumns){
                        if(ci.isForeignKey() && ci.getFTable()!=null){
                            String getterFK="";
                            String getterPK_PK="";
                            
                            if(ci.getHyperColumnName()!=null){
                                getterFK    = "get"+FormatString.firstLetterUpperCase(ci.getHyperColumnObjectName());
                            }else {
                                getterFK    = "get"+FormatString.getCadenaHungara(ci.getFTable().getJavaDeclaredName());                                
                            }
                            getterPK_PK = "get"+ci.getFTable().getPrimaryKeys().iterator().next().getJavaDeclaredName();
                            
                            ps.println("            if(x."+getterFK+"() !=null && x."+getterFK+"()."+getterPK_PK+"()!=null){} ");
                        }                        
                    }
                    
                    for (Table posibleTableOneToMany : tablesForGeneration) {
						
						if(posibleTableOneToMany instanceof EmbeddeableColumn){
							continue;
						}
						
						Table  tableReferenceOneToMany = null;
						Column colmnMappedBy = null;
						String realSugestedCollectionName = null;
						String colectionClassName = null;
						for(Column cfk: posibleTableOneToMany.getFKs()){
                            colectionClassName = null;
							if(!cfk.isPrimaryKey() && cfk.getFTable().getName().equals(table.getName())){
								colmnMappedBy = cfk;
															
								if(posibleTableOneToMany.getSingularName()!=null){
                                    colectionClassName = posibleTableOneToMany.getSingularName();
									realSugestedCollectionName = posibleTableOneToMany.getSingularName()+explainedM2OList;
								}else{
                                    colectionClassName = posibleTableOneToMany.getName();
									realSugestedCollectionName = posibleTableOneToMany.getName()+explainedM2OList;
								}
								
								if(cfk.getHyperColumnName()!=null){
									realSugestedCollectionName += cfk.getHyperColumnName()+"_"+collectionClass;
								}else{
									realSugestedCollectionName += cfk.getName()+"_"+collectionClass;
								}
								ps.println("            for("+FormatString.firstLetterUpperCase(FormatString.getCadenaHungara(colectionClassName))+" x_"+posibleTableOneToMany.getJavaDeclaredObjectName()+": x.get"+FormatString.getCadenaHungara(realSugestedCollectionName)+"() ) {} ");
							}
						}
					}

					Collection<Table> m2mTables = dbSet.getManyToManyRelationTables(table);

					for (Table fm2mTable : m2mTables) {
						//ps.println("    // "+fm2mTable.getName());
						Table tableOwnerManyToManyRelation = dbSet.getTableOwnerManyToManyRelation(table, fm2mTable);
						Iterator<Column> fKsM2M = tableOwnerManyToManyRelation.getFKs().iterator();

						Column rtCol1 = fKsM2M.next();
						Column rtCol2 = fKsM2M.next();
                        String colectionClassName = "";
                        String m2mCollectuionProperty="";
                        
                        colectionClassName = fm2mTable.getSingularNameJavaDeclaredObjectName();
						if(fm2mTable.getSingularName()!=null){
                            m2mCollectuionProperty = fm2mTable.getSingularNameJavaDeclaredObjectName() + collectionClass;							
						}else{
                            m2mCollectuionProperty = FormatString.renameForJavaMethod(fm2mTable.getName()) + collectionClass;							
						}
                        
                        //ps.println("            //EAGER M-2-M init: "+fm2mTable.getName()+", "+fm2mTable.getJavaDeclaredName()+", "+fm2mTable.getJavaDeclaredObjectName()+", "+fm2mTable.getJavaDeclaredObjectName()+ collectionClass+", "+m2mCollectuionProperty);                        
                        ps.println("            for("+fm2mTable.getJavaDeclaredName()+" x_"+fm2mTable.getJavaDeclaredName()+": x.get"+FormatString.firstLetterUpperCase(m2mCollectuionProperty)+"() ) {} ");						
					}                    
				} else if(line.contains("${tablebean.collectionMember.eagerLeaveFlatCode}")){
                    line = "";
                    for (Table posibleTableOneToMany : tablesForGeneration) {
						
						if(posibleTableOneToMany instanceof EmbeddeableColumn){
							continue;
						}
						
						Table  tableReferenceOneToMany = null;
						Column colmnMappedBy = null;
						String realSugestedCollectionName = null;
						String colectionClassName = null;
						for(Column cfk: posibleTableOneToMany.getFKs()){
                            colectionClassName = null;
							if(!cfk.isPrimaryKey() && cfk.getFTable().getName().equals(table.getName())){
								colmnMappedBy = cfk;
															
								if(posibleTableOneToMany.getSingularName()!=null){
                                    colectionClassName = posibleTableOneToMany.getSingularName();
									realSugestedCollectionName = posibleTableOneToMany.getSingularName()+explainedM2OList;
								}else{
                                    colectionClassName = posibleTableOneToMany.getName();
									realSugestedCollectionName = posibleTableOneToMany.getName()+explainedM2OList;
								}
								
								if(cfk.getHyperColumnName()!=null){
									realSugestedCollectionName += cfk.getHyperColumnName()+"_"+collectionClass;
								}else{
									realSugestedCollectionName += cfk.getName()+"_"+collectionClass;
								}
								//ps.println("        //EAGER leave flat ? O-2-M :"+FormatString.firstLetterUpperCase(FormatString.getCadenaHungara(colectionClassName))+" x_"+posibleTableOneToMany.getJavaDeclaredObjectName()+", x.get"+FormatString.getCadenaHungara(realSugestedCollectionName)+"()  ");
                                ps.println("        final List<"+FormatString.firstLetterUpperCase(FormatString.getCadenaHungara(colectionClassName))+"> entity_"+FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(realSugestedCollectionName))+" =  entity.get"+FormatString.getCadenaHungara(realSugestedCollectionName)+"();");
                                ps.println("        entity.set"+FormatString.getCadenaHungara(realSugestedCollectionName)+"(null);");
							}
						}
					}

					Collection<Table> m2mTables = dbSet.getManyToManyRelationTables(table);

					for (Table fm2mTable : m2mTables) {
						//ps.println("    // "+fm2mTable.getName());
						Table tableOwnerManyToManyRelation = dbSet.getTableOwnerManyToManyRelation(table, fm2mTable);
						Iterator<Column> fKsM2M = tableOwnerManyToManyRelation.getFKs().iterator();

						Column rtCol1 = fKsM2M.next();
						Column rtCol2 = fKsM2M.next();
                        String colectionClassName = "";
                        String m2mCollectuionProperty="";
                        
                        colectionClassName = fm2mTable.getSingularNameJavaDeclaredObjectName();
						if(fm2mTable.getSingularName()!=null){
                            m2mCollectuionProperty = fm2mTable.getSingularNameJavaDeclaredObjectName() + collectionClass;							
						}else{
                            m2mCollectuionProperty = FormatString.renameForJavaMethod(fm2mTable.getName()) + collectionClass;							
						}
                        
                        //ps.println("        //EAGER leave flat: M-2-M :"+fm2mTable.getName()+", "+fm2mTable.getJavaDeclaredName()+", "+fm2mTable.getJavaDeclaredObjectName()+", "+fm2mTable.getJavaDeclaredObjectName()+ collectionClass+", "+m2mCollectuionProperty);
                        ps.println("        final List<"+fm2mTable.getJavaDeclaredName()+"> entity_"+m2mCollectuionProperty+" =  entity.get"+FormatString.firstLetterUpperCase(m2mCollectuionProperty)+"();");
                        ps.println("        entity.set"+FormatString.firstLetterUpperCase(m2mCollectuionProperty)+"(null);");
					}
				} else if(line.contains("${tablebean.collectionMember.eagerCopyCode}")){
                    line = "";
                    for (Table posibleTableOneToMany : tablesForGeneration) {
						
						if(posibleTableOneToMany instanceof EmbeddeableColumn){
							continue;
						}
						
						Table  tableReferenceOneToMany = null;
						Column colmnMappedBy = null;
						String realSugestedCollectionName = null;
						String colectionClassName = null;
						for(Column cfk: posibleTableOneToMany.getFKs()){
                            colectionClassName = null;
							if(!cfk.isPrimaryKey() && cfk.getFTable().getName().equals(table.getName())){
								colmnMappedBy = cfk;
															
								if(posibleTableOneToMany.getSingularName()!=null){
                                    colectionClassName = posibleTableOneToMany.getSingularName();
									realSugestedCollectionName = posibleTableOneToMany.getSingularName()+explainedM2OList;
								}else{
                                    colectionClassName = posibleTableOneToMany.getName();
									realSugestedCollectionName = posibleTableOneToMany.getName()+explainedM2OList;
								}
								
								if(cfk.getHyperColumnName()!=null){
									realSugestedCollectionName += cfk.getHyperColumnName()+"_"+collectionClass;
								}else{
									realSugestedCollectionName += cfk.getName()+"_"+collectionClass;
								}
								//ps.println("        //EAGER copy ? O-2-M :"+FormatString.firstLetterUpperCase(FormatString.getCadenaHungara(colectionClassName))+" x_"+posibleTableOneToMany.getJavaDeclaredObjectName()+", x.get"+FormatString.getCadenaHungara(realSugestedCollectionName)+"()  ");                                
                                ps.println("        entity.set"+FormatString.getCadenaHungara(realSugestedCollectionName)+"(entity_"+FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(realSugestedCollectionName))+");");
							}
						}
					}

					Collection<Table> m2mTables = dbSet.getManyToManyRelationTables(table);

					for (Table fm2mTable : m2mTables) {
						//ps.println("    // "+fm2mTable.getName());
						Table tableOwnerManyToManyRelation = dbSet.getTableOwnerManyToManyRelation(table, fm2mTable);
						Iterator<Column> fKsM2M = tableOwnerManyToManyRelation.getFKs().iterator();

						Column rtCol1 = fKsM2M.next();
						Column rtCol2 = fKsM2M.next();
                        String colectionClassName = "";
                        String m2mCollectuionProperty="";
                        
                        colectionClassName = fm2mTable.getSingularNameJavaDeclaredObjectName();
						if(fm2mTable.getSingularName()!=null){
                            m2mCollectuionProperty = fm2mTable.getSingularNameJavaDeclaredObjectName() + collectionClass;							
						}else{
                            m2mCollectuionProperty = FormatString.renameForJavaMethod(fm2mTable.getName()) + collectionClass;							
						}
                        
                        //ps.println("        //EAGER copy ? M-2-M init: "+fm2mTable.getName()+", "+fm2mTable.getJavaDeclaredName()+", "+fm2mTable.getJavaDeclaredObjectName()+", "+fm2mTable.getJavaDeclaredObjectName()+ collectionClass+", "+m2mCollectuionProperty);
                        ps.println("        entity.set"+FormatString.firstLetterUpperCase(m2mCollectuionProperty)+"(entity_"+m2mCollectuionProperty+");");
                        
					}                    
                }
				line = line.replace("${tablebean.declaredName}", table.getJavaDeclaredName());
				line = line.replace("${JPA.PU}", jpaPU);
				ps.println(line);
			}
			br.close();
			ps.close();
			fos.close();
			
			sourceFile = null;
			ps = null;
			fos = null;			
		}
	}
    
    private static void generateAuditableEntityInterface(String packageBeanMember, String basePath) throws IOException {
        String fileName = packageBeanMember.replace(".", File.separator) + File.separator;
        File baseDir = new File(basePath);
        File dirSourceFile = new File(baseDir.getPath() + File.separator + File.separator + fileName);
        if (!dirSourceFile.exists()) {
            dirSourceFile.mkdirs();
        }

        fileName = dirSourceFile.getPath() + File.separator + "AuditableEntity.java";		

        File sourceFile = new File(fileName);
        FileOutputStream fos = new FileOutputStream(sourceFile);
        PrintStream ps = new PrintStream(fos);
        BufferedReader br = new BufferedReader(new InputStreamReader(fos.getClass().getResourceAsStream("/templates/TableBeanAuditable.java.template")));

        String line=null;
        while ((line = br.readLine()) != null) {            
            line = line.replace("${tablebean.package}", packageBeanMember);
            ps.println(line);
        }
    }
	
}
