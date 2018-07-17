package com.tracktopell.dao.builder.ejb3;

import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.parser.VP6Parser;
import com.tracktopell.dao.builder.parser.VPModel;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * com.tracktopell.dao.builder.ejb3.VPModel2JPA
 */
public class VPModel2JPA {

    public static void main(String[] args) {
        String  pathToVPProject  = null;
        String  schemmaName      = null;
        String  packageBeanMember= null;
        String  basePath         = null;
        String[]tableNames2Gen   = null;
        String  fetchType        = null;
        try {

            if( args.length < 5 || args.length > 6) {
                System.err.println("bad args:"+Arrays.asList(args));
                System.err.println("use: <java ...> com.tracktopell.dao.builder.ejb3.VPModel2JPA  pathToVPProject  schemmaName packageBeanMember  basePath  tableNames2GenList,Separated,By,Comma [FETCHTYPE_LAZY|FETCHTYPE_EAGER]" );
                System.exit(1);
            }


            pathToVPProject  = args[0];
			schemmaName      = args[1];
            packageBeanMember= args[2];
            basePath         = args[3];
            tableNames2Gen   = args[4].split(",");
            if(args.length == 6){
                fetchType    = args[5];
                if(fetchType.equals(EJB3Builder.FETCHTYPE_LAZY)){
                    EJB3Builder.setDefaultValueFetchType_LAZY();
                    System.out.println("==>>NOW FETCHTYPE_LAZY !");
                } else if(fetchType.equals(EJB3Builder.FETCHTYPE_EAGER)){
                    EJB3Builder.setDefaultValueFetchType_EAGER();
                    System.out.println("==>>NOW FETCHTYPE_EAGER !");
                }
            }

            Hashtable<String, VPModel> vpModels;
            vpModels = VP6Parser.loadVPModels(new FileInputStream(pathToVPProject));

            //System.err.println("DBBuilderFactory ->vpModels=" + vpModels);
            DBTableSet dbSet;
            dbSet = VP6Parser.loadFromXMLWithVPModels(new FileInputStream(pathToVPProject), vpModels);

            if(!tableNames2Gen[0].equals("{all}")){
                dbSet = dbSet.copyJustSelectedNames(tableNames2Gen);
            }

            System.out.println("====================== END PARSE XML ========================");
            System.out.println("->" + dbSet);

            EJB3Builder.buildMappingBeans(dbSet, schemmaName, packageBeanMember, basePath);

        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.exit(2);
        }
    }
}
