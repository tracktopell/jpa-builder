package com.tracktopell.util;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

/**
 *
 * @author alfredo.estrada
 */
public class VersionUtil {
	private static       Properties versionProperties;
	public  static final String VERSION_LOCATION = "/com/tracktopell/jpabuilder/version.properties";
	public  static final String BUILT_TIMESTAMP = "version.build.timestamp";
	public  static final String PROJECT_VERSION = "project.version";
	
	public static Properties loadVersionProperties(){
		if(versionProperties == null){
			versionProperties = new Properties();
			try {
				versionProperties.load(VersionUtil.class.getResourceAsStream(VERSION_LOCATION));				
			}catch(IOException ioe){
				ioe.printStackTrace(System.err);
				versionProperties.put(BUILT_TIMESTAMP, "?");				
				versionProperties.put(PROJECT_VERSION, "?");
			}
		}
		return versionProperties;
	}
}
