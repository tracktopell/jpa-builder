package com.tracktopell.dao.builder.dbschema;

import com.tracktopell.dao.builder.DBBuilderFactory;
import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.parser.VP6Parser;
import com.tracktopell.dao.builder.parser.VPModel;
import com.tracktopell.util.VersionUtil;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Properties;

/**
 * com.tracktopell.dao.builder.dbschema.VPModel2SQL
 * VPModel2SQL
 */
public class VPModel2SQL {

    public static void main(String[] args) {
        String  pathToVPProject  = null;
        String  rdbms            = null;
        String  schemmaName      = null;
        String  outputPath       = null;
		String  outputDropPath   = null;
        String[]tableNames2Gen   = null;
        try {
			Properties vp=VersionUtil.loadVersionProperties();
			if( args.length != 6) {
				System.err.println("==================== Tracktopell VPModel2SQL ======================");
				System.err.println("\t  BUILD: \t"+vp.getProperty(VersionUtil.BUILT_TIMESTAMP));
				System.err.println("\tVERSION: \t"+vp.getProperty(VersionUtil.PROJECT_VERSION));

                System.err.println("use: <java ...> com.tracktopell.dao.builder.dbschema.VPModel2SQL  pathToVPProject  rdbms  catalog  baseCreatePath baseDropPath [ tableNames2GenList,Separated,By,Comma | {all} ]" );
                System.exit(1);
            }

			
            pathToVPProject  = args[0];
            rdbms            = args[1];
            schemmaName      = args[2];
            outputPath       = args[3];
			outputDropPath   = args[4];
            tableNames2Gen   = args[5].split(",");

            Hashtable<String, VPModel> vpModels;
            vpModels = VP6Parser.loadVPModels(new FileInputStream(pathToVPProject));

            //System.err.println("DBBuilderFactory ->vpModels=" + vpModels);
            DBTableSet dbSet;
            dbSet = VP6Parser.loadFromXMLWithVPModels(new FileInputStream(pathToVPProject), vpModels);

            if(!tableNames2Gen[0].equals("{all}")){
                dbSet = dbSet.copyJustSelectedNames(tableNames2Gen);
            }

            //System.err.println("====================== END PARSE XML ========================");
            //System.err.println("->" + dbSet);

            DBBuilder dbBuilder = null;
            if(rdbms.equalsIgnoreCase("mysql")) {
                dbBuilder = DBBuilderFactory.getInstance("com.tracktopell.dao.builder.dbschema.mysql.MySQLDBBuilder");
            } else if(rdbms.equalsIgnoreCase("mssqlserver")) {
                dbBuilder = DBBuilderFactory.getInstance("com.tracktopell.dao.builder.dbschema.mssqlserver.SQLServerDBBuilder");
            } else if(rdbms.equalsIgnoreCase("derby")) {
                dbBuilder = DBBuilderFactory.getInstance("com.tracktopell.dao.builder.dbschema.derby.DerbyDBBuilder");
            } else {
				throw new IllegalArgumentException("RDBMS not supported:"+rdbms);
			}
            System.out.println("->createDBSchema:");
            dbBuilder.createDBSchema(schemmaName, dbSet, new PrintStream(new FileOutputStream(outputPath)));
			
			System.out.println("->createDropDBSchema:");            
			dbBuilder.printDropSchema(schemmaName, dbSet, new PrintStream(new FileOutputStream(outputDropPath)));
			
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
