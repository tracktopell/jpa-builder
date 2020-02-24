/**
 * Archivo: JDBCToJPABeans.java
 *
 * Fecha de Creaci&oacute;n: 1/06/2011
 *
 * 2H Software - Bursatec 2011
 */
package com.tracktopell.dao.builder.dbextractor;

import com.tracktopell.dao.builder.ejb3.DTOBeanBuilder;
import com.tracktopell.dao.builder.metadata.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * com.tracktopell.dao.builder.dbextractor.JDBCToDTOs
 * 
 * @author Alfredo Estrada Gonz&aacute;lez.
 * @version 1.0
 *
 */
public class JDBCToDTOs {

    public static void main(String args[]) {

        if (args.length != 10) {
            System.err.print("use: <java ...> JDBCToJPABeans  jdbcDriver urlConnection user password schemma tableNames2GenList,Separated,By,Comma  packageDTOMember  packageDAOMember basePath jpaCompatibleFKs ");
            System.exit(1);
        }

        String driver = args[0]; 
        String connection = args[1]; 
        String user = args[2]; 
        String password = args[3]; 

        String schemma = args[4]; 
        String[] tables = args[5].split(","); 
        String packageDTOMember = args[6];
		String packageDAOMember = args[7];
        String basePath = args[8];
		boolean jpaCompatibleFKs= args[9].equals("true");

        try {            
            Class.forName(driver);
            Connection con = DriverManager.getConnection(connection, user, password);

            Statement st = con.createStatement();

            List<String> tableList = new ArrayList<String>();

            for (String table : tables) {
                tableList.add(table);
            }
            DBTableSet dbSet = extractDBSet(con, schemma, tableList);
            
            List<String> foreignTableNames = new ArrayList<String>();

            Enumeration<Table> tablesElements = dbSet.getTablesElements();
            while (tablesElements.hasMoreElements()) {
                Table tableE = tablesElements.nextElement();
                Collection<ReferenceTable> fKReferenceTables = tableE.getFKReferenceTables();
                for (ReferenceTable rt : fKReferenceTables) {
                    foreignTableNames.add(rt.getTableName());
                }
            }


            for (String foreignTableName : foreignTableNames) {
                if (dbSet.getTable(foreignTableName) == null) {
                    System.out.println("=> " + foreignTableName + " IS MISSING FOR FOREIGN REFERENCES!");
                }
            }
			
			System.err.println("Generating :dbSet="+dbSet);
			
			System.err.println("Generating DTOs:");
			DTOBeanBuilder.buildMappingDTOs(dbSet, packageDTOMember, basePath, jpaCompatibleFKs);
			
			System.err.println("Generating DAOs:");
			DTOBeanBuilder.buildDAOs(dbSet, packageDTOMember, packageDAOMember, basePath, jpaCompatibleFKs);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static DBTableSet extractDBSet(Connection conn, String schemma, List<String> tableList) {
        DBTableSet dbSet = null;

        Statement st = null;
        dbSet = new DBTableSet();

        try {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            ResultSet schemasRS = dbMetaData.getSchemas();
			ResultSet tablesRS = null;
            //System.out.println("TABLE_SCHEMAS");
            String realSchemma = null;
			while (schemasRS.next()) {
				if (	schemma!=null && 
						schemasRS.getString(1).equalsIgnoreCase(schemma)) {
					
					realSchemma = schemasRS.getString(1);
					//System.err.println("\t->SCHEMA:" + realSchemma);
				}
			}
			schemasRS.close();
			
			if(schemma!=null && schemma.length()>1){
				if (realSchemma == null) {
					throw new Exception("Schemma not found !");
				}
			}
			
			//System.err.println("tableList:"+Arrays.asList(tableList)+" , size:"+tableList.size()); 
			
			List<String> realTableList =  new ArrayList<>();
			if(tableList.size() == 1){
				final String iterTableName = tableList.get(0);
				//System.err.println("\titerTableName:"+iterTableName);
				if(iterTableName.contains("*") || iterTableName.contains("%")){
					//System.err.println("\t Getting all tables");
					tablesRS = dbMetaData.getTables(null, null, "%", new String[]{"TABLE"});
					
					while(tablesRS.next()){
						
						final String tableName = tablesRS.getString("TABLE_NAME");
						//System.err.println("\t\t --> table:"+tableName);
						realTableList.add(tableName);
					}					
				}
			} else {
				realTableList.addAll(tableList);
			}

            //System.err.println("==============================-------================================");

            for (String tableName : realTableList) {

                Table table = new Table();

                table.setName(tableName);
                table.setSchemma(realSchemma);

                ResultSet rsColumns = dbMetaData.getColumns(null, realSchemma, tableName, null);
                //System.err.println("========>> List of Columns for table: "+tableName);
                while (rsColumns.next()) {

                    Column column = new SimpleColumn();

                    column.setName(rsColumns.getString("COLUMN_NAME"));
                    //column.setAutoIncremment();
                    column.setSqlType(getSQLTypeFor(rsColumns.getInt("DATA_TYPE")).toLowerCase());
                    column.setPosition(rsColumns.getInt("ORDINAL_POSITION"));
                    column.setPrecision(rsColumns.getInt("DECIMAL_DIGITS"));
                    column.setScale(rsColumns.getInt("COLUMN_SIZE"));
                    column.setNullable(rsColumns.getInt("NULLABLE") == 1);
                    column.setJavaClassType(SQLTypesToJavaTypes.getTypeFor(column.getSqlType()));

					//System.err.println("\t========>> column: "+tableName+"."+column.getName()+" null:"+column.isNullable()+", sql:"+column.getSqlType());
					
                    if (!column.isNullable()) {
                        if (!column.isPrimaryKey()
                                && (	SQLTypesToJavaTypes.getTypeFor(column.getSqlType()).endsWith("Double") 
									||	SQLTypesToJavaTypes.getTypeFor(column.getSqlType()).endsWith("Float"))
                                && column.getPrecision() == 0) {

                            column.setJavaClassType("int");
                        } else {
                            column.fixBestJavaClassForSQLType();
                        }
                    }
					
                    if (column.isNullable()
                            && (SQLTypesToJavaTypes.getTypeFor(column.getSqlType()).endsWith("Double")
                            || SQLTypesToJavaTypes.getTypeFor(column.getSqlType()).endsWith("Float"))
                            && column.getPrecision() == 0) {
                        column.setJavaClassType(Integer.class.toString().replace("class ", ""));
                    }

                    table.addColumn(column);
                }
                rsColumns.close();

                ResultSet rsPKs = dbMetaData.getPrimaryKeys(null, realSchemma, tableName);
                //System.err.println("==============================");
                //System.err.println("List of PKs for table: ");
                ArrayList<Column> pkColumns = new ArrayList<Column>();
                
                while (rsPKs.next()) {
                    //System.out.println(rsPKs.getString("TABLE_NAME") + "." + rsPKs.getString("COLUMN_NAME"));
                    Column pkColumn = table.getColumn(rsPKs.getString("COLUMN_NAME"));
                    pkColumn.setPrimaryKey(true);
                    pkColumns.add(pkColumn);
                }
                rsPKs.close();
                                
                ResultSet rsFKs = dbMetaData.getImportedKeys(null, realSchemma, tableName);
                //System.err.println("==============================");
                //System.err.println("List of FKs for table: ");
                ResultSetMetaData rsFKsMetaData = rsFKs.getMetaData();
                while (rsFKs.next()) {
                    table.getColumn(rsFKs.getString("FKCOLUMN_NAME")).setForeignKey(true);
                    ReferenceTable rt = new ReferenceTable();
                    rt.setColumnName(rsFKs.getString("PKCOLUMN_NAME"));
                    rt.setTableName(rsFKs.getString("PKTABLE_NAME"));

                    table.addForeignKey(rsFKs.getString("FKCOLUMN_NAME"), rt);
                }
                rsFKs.close();
                //==============================================================
                
                dbSet.addTable(table);
            }
            //System.out.println("==============================-------================================");            
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return dbSet;
    }
    private static Hashtable<Integer, String> sqlTypes;

    public static String getSQLTypeFor(int type) {

        if (sqlTypes == null) {
            sqlTypes = new Hashtable<Integer, String>();

            Class classTypes = java.sql.Types.class;
            Field[] declaredFields = classTypes.getDeclaredFields();

            for (Field f : declaredFields) {

                f.setAccessible(true);
                try {
                    //System.out.println(f.getName() + ": " + f.get(null));
                    sqlTypes.put(new Integer(f.get(null).toString()), f.getName());
                } catch (Exception ex) {
                    //System.out.println("X");
                }

            }
        }

        return sqlTypes.get(new Integer(type));
    }
}