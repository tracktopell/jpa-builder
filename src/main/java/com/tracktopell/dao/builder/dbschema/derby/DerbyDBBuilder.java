/*
 * DerbyDBBuilder.java
 *
 */

package com.tracktopell.dao.builder.dbschema.derby;

import com.tracktopell.dao.builder.dbschema.DBBuilder;
import com.tracktopell.dao.builder.metadata.Column;
import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.metadata.ReferenceTable;
import com.tracktopell.dao.builder.metadata.Table;
import java.io.PrintStream;
import java.util.Iterator;

/**
 * com.tracktopell.dao.builder.dbschema.derby.DerbyDBBuilder
 * @author tracktopell
 */
public class DerbyDBBuilder extends DBBuilder{
    
    public DerbyDBBuilder() {
    }

    protected void printDefinitionSchema(String schemaName,DBTableSet dbSet,PrintStream out) {
    }

    protected void printDefinitionTable(Table currentTable, PrintStream out) {
        Iterator<Column> it = currentTable.getSortedColumns();
        Column col = null;
        StringBuffer pkBuffer = new StringBuffer("PRIMARY KEY (");
        int pkConter=0;
        out.println("CREATE TABLE ${table.name}".replace("${table.name}",currentTable.getName().toUpperCase())+" (");
        while(it.hasNext()) {
            col = it.next();
            out.print("\t");
            out.print(col.getName().toUpperCase());
            out.print("\t\t");
            if(col.getSqlType().equals("varchar")){
                out.print("VARCHAR");
                out.print(" (");
                out.print(col.getScale());                
                out.print(")");                
            } else if(col.getSqlType().toLowerCase().equals("double") ||
                    col.getSqlType().toLowerCase().equals("float") || 
                    col.getSqlType().toLowerCase().equals("numeric")) {
                out.print("DOUBLE");
            } else if(	col.getSqlType().toLowerCase().startsWith("int") || 
						col.getSqlType().toLowerCase().startsWith("integer")) {
				out.print("INTEGER");
            } else if(col.getSqlType().toLowerCase().startsWith("tinyint")) {
                out.print("SMALLINT");
            } else if(col.getSqlType().toLowerCase().startsWith("bigint")) {
                out.print("BIGINT");
            } else {
                out.print(col.getSqlType().toUpperCase());
            }
            out.print("\t");
            if(!col.isNullable()) {
                out.print(" NOT NULL");
            }
            if(col.isAutoIncremment()) {
                out.print(" GENERATED BY DEFAULT AS IDENTITY");
            }
            out.println(" ,");                      
            
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
        
        out.print("\t");
        out.println(pkBuffer);        
        out.println(");");
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
                out.print(" ADD FOREIGN KEY (");
                out.print(col.getName().toUpperCase());                
                out.print(")\tREFERENCES ");
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