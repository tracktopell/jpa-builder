/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmarlen.l30.api.proxyclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author alfredo.estrada
 */
public abstract class JacksonServiceProxy {
	protected Client client = ClientBuilder.newClient();
	protected ObjectMapper mapper = new ObjectMapper();
	protected String serviceEndpointURL = null;
	
	JacksonServiceProxy(String serviceEndpointURL){
		this.client				= ClientBuilder.newClient();
		this.mapper				= new ObjectMapper();
		this.serviceEndpointURL = serviceEndpointURL;	
	}
	
}
