package com.smartdoc.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author alfredo.estrada
 */
@javax.ws.rs.ApplicationPath("restapi")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	/**
	 * Do not modify addRestResourceClasses() method.
	 * It is automatically populated with
	 * all resources defined in the project.
	 * If required, comment out calling this method in getClasses().
	 */
	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(com.smartdoc.microservices.impl.CatalogosSimplesMicroservice.class);
	}
	
}
