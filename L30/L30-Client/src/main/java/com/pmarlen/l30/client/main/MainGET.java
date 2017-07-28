/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmarlen.l30.client.main;

/**
 *
 * @author alfredo
 */
public class MainGET {
	public static void main(String[] args) {			
		anotherCall();
	}
	
	private static void anotherCall(){
		CatalogosSimplesService catalogosSimplesServicePROXY = 
				new CatalogosSimplesJacksonProxyService("http://localhost:8080/SmartdocJEE7v5-ms1-1.0-SNAPSHOT/restapi/catalogos");
		
		System.out.println(catalogosSimplesServicePROXY.getRoles().toString());
	}	
}
