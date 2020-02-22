/*
 * FormatString.java
 *
 */

package com.tracktopell.dao.builder;

import java.text.*;

public class FormatString {
    
    /**
     *
     * @param pCadena String
     * @return String
     */
    public static String getReplaceString(String pCadena) {
        return pCadena.replace('(', '_').replace('/', '_').replace('\\', '_').
                replace('\'', '_')
                .replace('`', '_').replace('~', '_').replace('@', '_').replace('#', '_')
                .replace('$', '_').replace('%', '_').replace('^', '_').replace('&', '_')
                .replace('*', '_').replace(')', '_').replace('-', '_').replace('?', '_')
                .replace('.', '_').replace('>', '_').replace('<', '_').replace(',', '_')
                .replace('=', '_').replace(';', '_').replace(':', '_').replace('+', '_')
                .replace('{', '_').replace('}', '_').replace('[', '_').replace(']', '_');
    }
    
    /**
     *
     * @param sCadena String
     * @return String
     */
    public static String getCadenaHungara(String sCadena) {
        if (sCadena == null || sCadena.trim().length() == 0) {
            return "";
        }
        int iCiclo = 0;
        int iLoop = 0;
        boolean bflag = false;
        sCadena = getReplaceString(sCadena);
        char[] sCadTmp = ( (String) (sCadena.toUpperCase().substring(0, 1) +
                sCadena.toLowerCase().substring(1))).
                toCharArray();
        char[] sCadOut = new char[sCadena.length()];
        
        while (iCiclo < sCadena.length()) {
            if (sCadTmp[iCiclo] != '_') {
                if (bflag) {
                    sCadOut[iLoop++] = String.valueOf(sCadTmp[iCiclo]).toUpperCase().
                            toCharArray()[0];
                    bflag = false;
                } else {
                    sCadOut[iLoop++] = sCadTmp[iCiclo];
                }
            } else {
                bflag = true;
            }
            iCiclo++;
        }
        return String.valueOf(sCadOut).trim();
    }
    
    public static String renameForJavaMethod(String str) {
		//System.out.println("\t\t-->renameForJavaMethod: str="+str);
		if (str == null || str.trim().length() == 0) {
            return "";
        }
        if(str.length()==1){
			return str.substring(0, 1).toLowerCase();
		}
		String out = getCadenaHungara(str);
        out = out.substring(0, 1).toLowerCase() + out.substring(1);
        return out;        
    }
    
    public static String firstLetterLowerCase(String str) {
		//System.out.println("\t\t-->firstLetterLowerCase: str="+str);		
		if (str == null || str.trim().length() == 0) {
            return "";
        }
        if(str.length()==1){
			return str.substring(0, 1).toLowerCase();
		}
		return str.substring(0, 1).toLowerCase() + str.substring(1);
    }
	
	public static String firstLetterUpperCase(String str) {
		//System.out.println("\t\t-->firstLetterUpperCase: str="+str);
		if (str == null || str.trim().length() == 0) {
            return "";
        }
        if(str.length()==1){
			return str.substring(0, 1).toUpperCase();
		}
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
}
