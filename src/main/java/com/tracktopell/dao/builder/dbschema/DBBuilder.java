/*
 * DBBuilder.java
 *
 */

package com.tracktopell.dao.builder.dbschema;

import com.tracktopell.dao.builder.metadata.Column;
import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.metadata.Table;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author tracktopell
 */
public abstract class DBBuilder {
    
    /** Creates a new instance of DBBuilder */
    protected DBBuilder() {
    }
    
    public void createDBSchema(String schemaName, DBTableSet dbSet,PrintStream out) {        
        List<Table> lt=dbSet.getTablesSortedForCreation();
		StringBuilder sbFaults=new StringBuilder();
		int numFaults=0;
		for(Table t: lt) {
			Collection<Column> pks = t.getPrimaryKeys();
			for(Column c: pks){
				if(c.isPrimaryKey() && c.isAutoIncremment()){
					if(		!c.getJavaClassType().equals("java.lang.Integer")	&&
							!c.getJavaClassType().equals("int")					&&
							!c.getJavaClassType().equals("java.lang.Long")		&&
							!c.getJavaClassType().equals("long")				&&
							!c.getJavaClassType().equals("java.lang.Short")		&&
							!c.getJavaClassType().equals("short")){
						numFaults++;
						String faultDesc="=> PK "+t.getName()+"."+c.getName()+" IS AUTOINCREMENT BUT NOT NUMERIC VALID TYPE:"+c.getSqlType()+" -> Java:"+c.getJavaClassType();
						System.err.println(faultDesc);
						sbFaults.append(faultDesc+"\r\n");
					}
				}
			}            
        }
		if(numFaults>0){
			throw new IllegalStateException("CREATION VALIDATIONS: Faults:"+numFaults);
		}
		
        out.println("-- ============================= CREACION DEL ESQUEMA DE LA BASE DE DATOS ====================");        
        printDefinitionSchema(schemaName,dbSet,out);
        out.println("-- ============================= TABLES ("+lt.size()+") =======================");
        
        for(Table t: lt) {			
            printDefinitionTable(t,out);
        }
        
        out.println("-- =================================== CONSTRAINTS ==============================");
        
        for(Table t: lt) {
            printAddPKContraints(t,out);            
        }
        
        for(Table t: lt) {
            printAddFKContraints(t,out);            
        }
		
		for(Table t: lt) {
            printAddUniqueContraints(t,out);            
        }
        
        for(Table t: lt) {
            printAddIndexes(t,out);            
        }
    }
	
	protected void printDropSchema(String schemaName,DBTableSet dbSet,PrintStream out) {

		List<Table> lt=dbSet.getTablesSortedForDrop();
		
        out.println("-- ============================= ELIMINADO DEL ESQUEMA DE LA BASE DE DATOS ====================");        
        printDefinitionSchema(schemaName,dbSet,out);
        out.println("-- ===================================== TABLES ("+lt.size()+") ===============================");
        
        for(Table t: lt) {            
            out.println("DROP TABLE "+t.getName()+";");
			out.println("");
        }
    
	}
    
    protected abstract void printDefinitionSchema(String schemaName,DBTableSet dbSet,PrintStream out) ;
	
    protected abstract void printDefinitionTable(Table currentTable, PrintStream out) ;
    
    protected abstract void printAddPKContraints(Table currentTable, PrintStream out) ;    

    protected abstract void printAddFKContraints(Table currentTable, PrintStream out) ;
	
	protected abstract void printAddUniqueContraints(Table currentTable, PrintStream out) ;

    protected abstract void printAddIndexes(Table currentTable, PrintStream out);
}
