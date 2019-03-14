package com.tracktopell.dao.builder.ejb3;

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
		String   dtoPackage          = null;
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
            if( args.length != 19 ) {
                System.err.println("use: <java ...> VPModel2DTOAndBeans  "+
						"pathToVPProject SCHEMA "+
						"dtoPackage dtoPackageBeanMember asmPackageBeanMember jpaPackageBeanMember rsbPackageBeanMember lsbPackageBeanMember esbPackageBeanMember "+
						"basePathDTO          basePathASM          basePathJPA          basePathRSB          basePathLSB          basePathESB "+
						"jpaPU  flatDTOs [ @Remote | @Local ] [ tableNames2GenList,Separated,By,Comma | {all} ]" );
                System.exit(1);
            }
			int arg=0;
            pathToVPProject		= args[arg++];
			schemmaName         = args[arg];
			
			dtoPackage          = args[arg];
			dtoPackageBeanMember= args[arg];
            asmPackageBeanMember= args[arg];
			jpaPackageBeanMember= args[arg];
			rsbPackageBeanMember= args[arg];
			lsbPackageBeanMember= args[arg];
			esbPackageBeanMember= args[arg];
			
			basePathDTO         = args[arg];
			basePathASM         = args[arg];			
            basePathJPA			= args[arg];						
			basePathRSB         = args[arg];
			basePathLSB         = args[arg];
			basePathESB         = args[arg];
			
			jpaPU				= args[arg];
			flatDTOs			= args[arg].trim().equalsIgnoreCase("true");
			interfaceToImpl		= args[arg];
            tableNames2Gen		= args[arg].split(",");

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
			            
			DTOBeanBuilder.buildMappingDTOsForJPABeans(dbSet, dtoPackage, dtoPackageBeanMember, jpaPackageBeanMember, basePathDTO, flatDTOs );
			
			DTOBeanBuilder.buildDTOsAssembler(dbSet, asmPackageBeanMember,dtoPackageBeanMember, jpaPackageBeanMember, basePathASM);
			
			EJB3Builder.buildMappingBeans(dbSet, schemmaName, jpaPackageBeanMember, basePathJPA);
						
            EJB3Builder.buildSSB(interfaceToImpl,dbSet, jpaPU, dtoPackage, jpaPackageBeanMember, rsbPackageBeanMember, esbPackageBeanMember,basePathJPA, basePathRSB, basePathESB);
			
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.exit(2);
        }
    }
}
