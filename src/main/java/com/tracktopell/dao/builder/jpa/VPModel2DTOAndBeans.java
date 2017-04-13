package com.tracktopell.dao.builder.jpa;

import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.parser.VP6Parser;
import com.tracktopell.dao.builder.parser.VPModel;
import java.io.FileInputStream;
import java.util.Hashtable;

/**
 * java com.tracktopell.dao.builder.jpa.VPModel2DTOAndBeans
 * VPModel2SQL
 */
public class VPModel2DTOAndBeans {

    public static void main(String[] args) {
        String   pathToVPProject  = null;
		String   schemmaName      = null;
        String   dtoPackageBeanMember= null;
		String   asmPackageBeanMember= null;
		String   jpaPackageBeanMember= null;
		String   esbPackageBeanMember= null;
		String   rsbPackageBeanMember= null;
        String   basePathJPA         = null;
		String   basePathDTO         = null;
		String   basePathASM         = null;
		String   basePathESB         = null;
		String   basePathRSB         = null;
		String   jpaPU               = null;
        String[] tableNames2Gen   = null;
        boolean  flatDTOs         = false;
		try {
            if( args.length != 15 ) {
                System.err.println("use: <java ...> VPModel2DTOAndBeans  pathToVPProject catalog dtoPackageBeanMember asmPackageBeanMember jpaPackageBeanMember rsbPackageBeanMember esbPackageBeanMember basePathJPA basePathDTO basePathASM basePathRSB basePathESB flatDTOs jpaPU [ tableNames2GenList,Separated,By,Comma | {all} ]" );
                System.exit(1);
            }

            pathToVPProject		= args[0];
			schemmaName         = args[1];
			dtoPackageBeanMember= args[2];
            asmPackageBeanMember= args[3];
			jpaPackageBeanMember= args[4];
			rsbPackageBeanMember= args[5];
			esbPackageBeanMember= args[6];
            basePathJPA			= args[7];
			basePathDTO         = args[8];
			basePathASM         = args[9];
			basePathRSB         = args[10];
			basePathESB         = args[11];
			jpaPU				= args[12];
			flatDTOs			= args[13].trim().equalsIgnoreCase("true");
            tableNames2Gen		= args[14].split(",");

            Hashtable<String, VPModel> vpModels;
            vpModels = VP6Parser.loadVPModels(new FileInputStream(pathToVPProject));

            //System.err.println("DBBuilderFactory ->vpModels=" + vpModels);
            DBTableSet dbSet;
            dbSet = VP6Parser.loadFromXMLWithVPModels(new FileInputStream(pathToVPProject), vpModels);

            if(!tableNames2Gen[0].equals("{all}")){
                dbSet = dbSet.copyJustSelectedNames(tableNames2Gen);
            }

            System.err.println("====================== END PARSE XML ========================");
            //System.out.println("->" + dbSet);
			
			DTOBeanBuilder.buildMappingDTOBeansAndJPABeans(dbSet, dtoPackageBeanMember, jpaPackageBeanMember, basePathDTO, flatDTOs );
			
			DTOBeanBuilder.buildAssembler(dbSet, asmPackageBeanMember,dtoPackageBeanMember, jpaPackageBeanMember, basePathASM);
			
			JPABeanBuilder.buildMappingBeans(dbSet, schemmaName, jpaPackageBeanMember, basePathJPA);
			
			JPABeanBuilder.buildESB(dbSet, jpaPU, jpaPackageBeanMember, rsbPackageBeanMember, esbPackageBeanMember,basePathJPA, basePathRSB, basePathESB);
            
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.exit(2);
        }
    }
}
