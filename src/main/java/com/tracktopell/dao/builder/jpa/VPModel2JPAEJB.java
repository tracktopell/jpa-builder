package com.tracktopell.dao.builder.jpa;

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
 * java com.tracktopell.dao.builder.jpa.VPModel2JPAEJB VPModel2SQL
 */
public class VPModel2JPAEJB {

    public static void main(String[] args) {
        String pathToVPProject = null;
        String schemmaName = null;
        String jpaPackageBeanMember = null;
        String esbPackageBeanMember = null;
        String rsbPackageBeanMember = null;
        String lsbPackageBeanMember = null;
        String basePathJPA = null;
        String basePathESB = null;
        String basePathRSB = null;
        String basePathLSB = null;
        String jpaPU = null;
        String interfaceToImpl = null;
        String[] tableNames2Gen = null;

        try {
            if (args.length != 13) {
                System.err.println("use: <java ...> com.tracktopell.dao.builder.jpa.VPModel2JPAEJB  "
                        + "pathToVPProject SCHEMA "
                        + "jpaPackageBeanMember rsbPackageBeanMember lsbPackageBeanMember esbPackageBeanMember "
                        + "basePathJPA          basePathRSB          basePathLSB          basePathESB "
                        + "jpaPU  [ @Remote | @Local ] [ tableNames2GenList,Separated,By,Comma | {all} ]");
                System.exit(1);
            }

            pathToVPProject = args[0];
            schemmaName = args[1];

            jpaPackageBeanMember = args[2];
            rsbPackageBeanMember = args[3];
            lsbPackageBeanMember = args[4];
            esbPackageBeanMember = args[5];

            basePathJPA = args[6];
            basePathRSB = args[7];
            basePathLSB = args[8];
            basePathESB = args[9];

            jpaPU = args[10];
            interfaceToImpl = args[11];
            tableNames2Gen = args[12].split(",");

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
            if (interfaceToImpl.equals("@Remote")) {
                JPABeanBuilder.buildRSSB(dbSet, jpaPU, jpaPackageBeanMember, rsbPackageBeanMember, esbPackageBeanMember, basePathJPA, basePathRSB, basePathESB);
            } else if (interfaceToImpl.equals("@Local")) {
                JPABeanBuilder.buildLSSB(dbSet, jpaPU, jpaPackageBeanMember, lsbPackageBeanMember, esbPackageBeanMember, basePathJPA, basePathLSB, basePathESB);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.exit(2);
        }
    }
}
