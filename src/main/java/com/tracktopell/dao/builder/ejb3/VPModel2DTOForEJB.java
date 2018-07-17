package com.tracktopell.dao.builder.ejb3;

import com.tracktopell.dao.builder.metadata.DBTableSet;
import com.tracktopell.dao.builder.parser.VP6Parser;
import com.tracktopell.dao.builder.parser.VPModel;
import java.io.FileInputStream;
import java.util.Hashtable;

/**
 * com.tracktopell.dao.builder.ejb3.VPModel2DTOForEJB
 */
public class VPModel2DTOForEJB {

    public static void main(String[] args) {
        String   pathToVPProject  = null;
		String   schemmaName      = null;
        String   dtoPackageBeanMember= null;
		String   asmPackageBeanMember= null;
		String   jpaPackageBeanMember= null;
		String   esbPackageBeanMember= null;
		String   rsbPackageBeanMember= null;
		String   lsbPackageBeanMember= null;
        String   basePathJPA         = null;
		String   basePathDTO         = null;
		String   basePathASM         = null;
		String   basePathESB         = null;
		String   basePathRSB         = null;
		String   basePathLSB         = null;
		String   jpaPU               = null;
		String   interfaceToImpl     = null;
        String[] tableNames2Gen   = null;
        boolean  flatDTOs         = false;
		try {
            if( args.length != 18 ) {
                System.err.println("use: <java ...> VPModel2DTOForEJB  "+
						"pathToVPProject SCHEMA "+
						"dtoPackageBeanMember asmPackageBeanMember jpaPackageBeanMember rsbPackageBeanMember lsbPackageBeanMember esbPackageBeanMember "+
						"basePathDTO          basePathASM          basePathJPA          basePathRSB          basePathLSB          basePathESB "+
						"jpaPU  flatDTOs [ @Remote | @Local ] [ tableNames2GenList,Separated,By,Comma | {all} ]" );
                System.exit(1);
            }

            pathToVPProject		= args[0];
			schemmaName         = args[1];
			
			dtoPackageBeanMember= args[2];
            asmPackageBeanMember= args[3];
			jpaPackageBeanMember= args[4];
			rsbPackageBeanMember= args[5];
			lsbPackageBeanMember= args[6];
			esbPackageBeanMember= args[7];
			
			basePathDTO         = args[8];
			basePathASM         = args[9];			
            basePathJPA			= args[10];						
			basePathRSB         = args[11];
			basePathLSB         = args[12];
			basePathESB         = args[13];
			
			jpaPU				= args[14];
			flatDTOs			= args[15].trim().equalsIgnoreCase("true");
			interfaceToImpl		= args[16];
            tableNames2Gen		= args[17].split(",");

            System.err.println("====================== [ com.tracktopell.dao.builder.jpa.VPModel2DTOAndBeans ]========================");
            Hashtable<String, VPModel> vpModels;
            vpModels = VP6Parser.loadVPModels(new FileInputStream(pathToVPProject));

            DBTableSet dbSet;
            dbSet = VP6Parser.loadFromXMLWithVPModels(new FileInputStream(pathToVPProject), vpModels);

            if(!tableNames2Gen[0].equals("{all}")){
                dbSet = dbSet.copyJustSelectedNames(tableNames2Gen);
            }

            System.err.println("====================== END PARSE XML ========================");
            System.out.println("->" + dbSet);
			            
			DTOBeanBuilder.buildMappingDTOsForJPABeans(dbSet, dtoPackageBeanMember, jpaPackageBeanMember, basePathDTO, flatDTOs );
			
			DTOBeanBuilder.buildDTOsAssembler(dbSet, asmPackageBeanMember,dtoPackageBeanMember, jpaPackageBeanMember, basePathASM);
			
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.exit(2);
        }
    }
}
