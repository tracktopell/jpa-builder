/**
 * com.tracktopell.dao.builder.dbschema.mssqlserver.SQLServerDBBuilder.java
 *
 */

package com.tracktopell.dao.builder.dbschema.mssqlserver;

import com.tracktopell.dao.builder.dbschema.DBBuilder;
import com.tracktopell.dao.builder.metadata.Column;
import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.metadata.ReferenceTable;
import com.tracktopell.dao.builder.metadata.Table;
import java.io.PrintStream;
import java.util.Iterator;

/**
 *
 * @author tracktopell
 */
public class SQLServerDBBuilder extends DBBuilder{
    
    public SQLServerDBBuilder() {
    }

    protected void printDefinitionSchema(String schemaName,DBTableSet dbSet,PrintStream out) {
    }

    protected void printDefinitionTable(Table currentTable, PrintStream out) {
        Iterator<Column> it = currentTable.getSortedColumns();
        Column col = null;
        StringBuffer pkBuffer = new StringBuffer("PRIMARY KEY (");
        StringBuffer fkBuffer = new StringBuffer();
        int pkConter=0;
        int colCounter=0;
        int fkCounter=0;
        out.println("CREATE TABLE ${table.name}".replace("${table.name}",currentTable.getName().toUpperCase())+" (");

        for(colCounter=1;it.hasNext();colCounter++) {
            col = it.next();
            out.print("\t");
            out.print(col.getName().toUpperCase());
            out.print("\t\t");
            if(col.getSqlType().equals("varchar")){
                out.print("VARCHAR");
                out.print(" (");
                out.print(col.getScale());                
                out.print(")");                
            } else if(col.getSqlType().equals("char")){
                out.print("CHAR");
                out.print(" (");
                out.print(col.getScale());                
                out.print(")");                
            } else if(col.getSqlType().toLowerCase().equals("double") ||
                    col.getSqlType().toLowerCase().equals("float") ) {
                out.print("FLOAT");
            } else if(col.getSqlType().toLowerCase().equals("numeric")) {
                out.print("NUMERIC");
            } else if(col.getSqlType().toLowerCase().equals("real")) {
                out.print("REAL");
            } else if(col.getSqlType().toLowerCase().startsWith("bit") ) {
                out.print("BIT");
            } else if(col.getSqlType().toLowerCase().startsWith("long") ) {
                out.print("BIGINT");
            } else if(col.getSqlType().toLowerCase().startsWith("int") ) {
                out.print("INT");
            } else if(col.getSqlType().toLowerCase().startsWith("tinyint")) {
                out.print("TINYINT");
            } else if(col.getSqlType().toLowerCase().startsWith("timestamp")) {
                out.print("DATETIME");
            } else {
                out.print(col.getSqlType().toUpperCase());
            }
            out.print("\t");
            if(!col.isNullable()) {
				out.print(" NOT NULL");				
            } else if(col.isNullable()) {
				out.print(" NULL");				                
            }
            if(col.isAutoIncremment()) {
                out.print(" IDENTITY(1,1)");
            }
			out.println(",");
            
			if(col.isPrimaryKey()) {
                pkConter++;
                if(pkConter>1)
                    pkBuffer.append(", ");
                pkBuffer.append("");                
                pkBuffer.append(col.getName().toUpperCase());                
                pkBuffer.append("");
            }
        }
        pkBuffer.append(")");
        
        out.print("    ");
        out.println(pkBuffer);        
        out.println(");");        
        out.println("");
        out.println("-- ===============================================================================");
    }
    /**
     * prints the alter talble for add constraints
     */
    protected void printAddPKContraints(Table currentTable, PrintStream out) {
    }
    /**
     * prints the alter talble for add constraints
     */
    protected void printAddFKContraints(Table currentTable, PrintStream out) {
		Iterator<Column> it = currentTable.getSortedColumns();
        Column col = null;
        while(it.hasNext()) {
            col = it.next();
            
            if(col.isForeignKey()) {                
                ReferenceTable rt = currentTable.getFKReferenceTable(col.getName());
                
                out.print("ALTER TABLE ");
                out.print(currentTable.getName().toUpperCase());
                out.print(" ADD CONSTRAINT ");
				out.print(currentTable.getName().toUpperCase());
				out.print("_FK_");
				out.print(col.getName().toUpperCase());
				out.print(" FOREIGN KEY (");
                out.print(col.getName().toUpperCase());
                out.print(")    REFERENCES ");
                out.print(rt.getTableName().toUpperCase());
                out.print("(");
                out.print(rt.getColumnName().toUpperCase());
                out.println(");");                                
            }
        }         
    }
	
    /**
     * prints the alter talble for add constraints
     */
    protected void printAddUniqueContraints(Table currentTable, PrintStream out) {
        Iterator<Column> it = currentTable.getSortedColumns();
        Column col = null;
        while(it.hasNext()) {
            col = it.next();
            
            if(col.isUnique() && !col.isPrimaryKey()) {             
                ReferenceTable rt = currentTable.getFKReferenceTable(col.getName());
                
                out.print("ALTER TABLE ");
                out.print(currentTable.getName().toUpperCase());
                out.print(" ADD CONSTRAINT ");
				out.print(currentTable.getName().toUpperCase());
				out.print("_");				
				out.print(col.getName().toUpperCase());
				out.print("_UC ");
				out.print("UNIQUE (");
                out.print(col.getName().toUpperCase());                
                out.println(");");
            }
        }        
    }
    @Override
    protected void printAddIndexes(Table currentTable, PrintStream out) {       
    }
}
