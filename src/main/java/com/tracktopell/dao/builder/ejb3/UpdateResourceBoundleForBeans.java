package com.tracktopell.dao.builder.ejb3;

import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.parser.VP6Parser;
import com.tracktopell.dao.builder.parser.VPModel;
import java.io.FileInputStream;
import java.util.Hashtable;

/**
 * UpdatePersistenceXML
 */
public class UpdateResourceBoundleForBeans {

    public static void main(String[] args) {
        String  pathToVPProject         = null;
		String  basePath                = null;
		String  prefixTableLabel        = null;
        String[]tableNames2Gen          = null;
        try {
		
            if( args.length != 4) {
                System.err.print("use: <java ...> UpdateResourceBoundleForBeans pathToVPProject  basePath  prefixTableLabel [ tableNames2GenList,Separated,By,Comma | {all} ] " );
                System.exit(1);
            }

            pathToVPProject         = args[0];
			basePath                = args[1];
			prefixTableLabel        = args[2];
            tableNames2Gen			= args[3].split(",");

            Hashtable<String, VPModel> vpModels;
            vpModels = VP6Parser.loadVPModels(new FileInputStream(pathToVPProject));
            
            DBTableSet dbSet;
            dbSet = VP6Parser.loadFromXMLWithVPModels(new FileInputStream(pathToVPProject), vpModels);

            if(!tableNames2Gen[0].equals("{all}")){
                dbSet = dbSet.copyJustSelectedNames(tableNames2Gen);
            }

            EJB3Builder.buildReourceBoundleBeans(dbSet, basePath, prefixTableLabel);

        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.exit(2);
        }
    }
}
