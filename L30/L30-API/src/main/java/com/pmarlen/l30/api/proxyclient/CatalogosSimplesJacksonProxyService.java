
package com.pmarlen.l30.api.proxyclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.pmarlen.l30.api.CatalogosSimplesService;
import com.pmarlen.l30.backend.dto.EstadoDTO;
import java.util.List;

/**
 *
 * @author alfredo
 */
public class CatalogosSimplesJacksonProxyService  extends JacksonServiceProxy implements CatalogosSimplesService{

	public CatalogosSimplesJacksonProxyService(String ep){
		super(ep);
	}
	

	@Override
	public List<EstadoDTO> getEstados() {
		List<EstadoDTO> l=null;
		WebTarget target = client.target(serviceEndpointURL+"/estados");
				
		String r = target.request(MediaType.APPLICATION_JSON).get(String.class);

		ObjectMapper mapper = new ObjectMapper();
		try{
			l = mapper.readValue(r, new TypeReference<List<EstadoDTO>>(){});
		}catch(IOException ioe){
			ioe.printStackTrace(System.err);
		}		
		return l;
	}
	
}
