
package com.pmarlen.l30.client.main;

import com.pmarlen.l30.api.CatalogosSimplesService;
import com.pmarlen.l30.api.proxyclient.CatalogosSimplesJacksonProxyService;

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
				new CatalogosSimplesJacksonProxyService("http://localhost:8080/L30-Backend-rest-11.0.1/restapi/catalogos");
		
		//System.out.println(catalogosSimplesServicePROXY.countEstados());
		System.out.println(catalogosSimplesServicePROXY.getEstados().toString());
	}	
}
