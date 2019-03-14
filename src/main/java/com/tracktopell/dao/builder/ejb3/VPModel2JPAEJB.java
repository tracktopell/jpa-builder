package com.tracktopell.dao.builder.ejb3;

import com.tracktopell.dao.builder.FormatString;
import com.tracktopell.dao.builder.metadata.Column;
import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.metadata.EmbeddeableColumn;
import com.tracktopell.dao.builder.metadata.Table;
import com.tracktopell.dao.builder.parser.VP6Parser;
import com.tracktopell.dao.builder.parser.VPModel;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/**
 * com.tracktopell.dao.builder.ejb3.VPModel2JPAEJB
 */
public class VPModel2JPAEJB {

    public static void main(String[] args) {
        String pathToVPProject = null;
        String schemmaName = null;
		String   dtoPackage          = null;
        String jpaPackageBeanMember = null;
        String esbPackageBeanMember = null;
        String rlsbPackageBeanMember = null;
        String basePathJPA = null;
        String basePathESB = null;
        String basePathRLSB = null;
        String jpaPU = null;
        String interfaceToImpl = null;
        String[] tableNames2Gen = null;

        try {
            if (args.length != 12) {
                System.err.println("use: <java ...> com.tracktopell.dao.builder.ejb3.VPModel2JPAEJB "
                        + "pathToVPProject SCHEMA "
                        + "dtoPackage jpaPackageBeanMember rlsbPackageBeanMember esbPackageBeanMember "
                        + "basePathJPA          basePathRLSB          basePathESB "
                        + "jpaPU  [ @Remote | @Local ] [ tableNames2GenList,Separated,By,Comma | {all} ]");
                System.exit(1);
            }

			int arg=0;
            pathToVPProject       = args[arg++];
            schemmaName           = args[arg++];

			dtoPackage            = args[arg++];
            jpaPackageBeanMember  = args[arg++];
            rlsbPackageBeanMember = args[arg++];            
            esbPackageBeanMember  = args[arg++];

            basePathJPA           = args[arg++];
            basePathRLSB          = args[arg++];            
            basePathESB           = args[arg++];

            jpaPU                 = args[arg++];
            interfaceToImpl       = args[arg++].replace("@", "");
            tableNames2Gen        = args[arg++].split(",");

            System.err.println("====================== [ com.tracktopell.dao.builder.jpa.VPModel2DTOAndBeans ]========================");
            Hashtable<String, VPModel> vpModels;
            vpModels = VP6Parser.loadVPModels(new FileInputStream(pathToVPProject));

            DBTableSet dbSet;
            dbSet = VP6Parser.loadFromXMLWithVPModels(new FileInputStream(pathToVPProject), vpModels);

            if (!tableNames2Gen[0].equals("{all}")) {
                dbSet = dbSet.copyJustSelectedNames(tableNames2Gen);
            }

            System.err.println("====================== END PARSE XML ========================");
            System.out.println("->" + dbSet);

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
            //System.err.println("==============================>>> ");
            for (Table table : tablesForGeneration) {

                //System.err.println("-->> generating DTO: " + table.getJavaDeclaredName() + "DTO.java :" + table);
                Iterator<Column> columnsSortedColumnsForJPA = table.getSortedColumnsForJPA();
                List<Column> definitiveColumns = new ArrayList();
                while (columnsSortedColumnsForJPA.hasNext()) {
                    Column column = columnsSortedColumnsForJPA.next();
                    if (column.getName().equalsIgnoreCase("FECHA_CREACION")
                            || column.getName().equalsIgnoreCase("CREADO_POR")
                            || column.getName().equalsIgnoreCase("FECHA_MODIFICACION")
                            || column.getName().equalsIgnoreCase("MODIFICADO_POR")) {
                        continue;
                    }
                    String suggested = null;
                    String suggestedObjectName = null;
                    String suggestedGettetObjectName = null;
                    String suggestedSettetObjectName = null;
                    Table fTable = null;

                    if (column.isForeignKey() && !(table instanceof EmbeddeableColumn)) {
                        fTable = dbSet.getTable(table.getFKReferenceTable(column.getName()).getTableName());
                        column.setFTable(fTable);

                        final Collection<Column> ftPksCol = fTable.getPrimaryKeys();
                        for (Column ftpk : ftPksCol) {
                            if (column.getName().toUpperCase().contains(ftpk.getName().toUpperCase())) {
                                if (fTable.getSingularName() != null) {
                                    suggested = fTable.getSingularName() + column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(), "");
                                } else {
                                    suggested = fTable.getName() + column.getName().toUpperCase().replace(ftpk.getName().toUpperCase(), "");
                                }
                                suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggested));
                                suggestedGettetObjectName = "get" + FormatString.getCadenaHungara(suggested);
                                suggestedSettetObjectName = "set" + FormatString.getCadenaHungara(suggested);

                                column.setHyperColumnName(suggested);
                                break;
                            } else {
                                suggested = column.getName().toUpperCase();

                                suggestedObjectName = FormatString.firstLetterLowerCase(FormatString.getCadenaHungara(suggested));
                                suggestedGettetObjectName = "get" + FormatString.getCadenaHungara(suggested);
                                suggestedSettetObjectName = "set" + FormatString.getCadenaHungara(suggested);

                                column.setHyperColumnName(suggested);
                                break;
                            }
                        }

                    } else {
                        fTable = null;
                    }
                    definitiveColumns.add(column);
                    //System.err.println("\t-->> DefinitiveColumn: " + column);
                }
            }

            //-------------------------------------------------------
            
            EJB3Builder.buildSSB(interfaceToImpl,dbSet, jpaPU, dtoPackage, jpaPackageBeanMember, rlsbPackageBeanMember, esbPackageBeanMember, basePathJPA, basePathRLSB, basePathESB);
            
            
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.exit(2);
        }
    }
}
