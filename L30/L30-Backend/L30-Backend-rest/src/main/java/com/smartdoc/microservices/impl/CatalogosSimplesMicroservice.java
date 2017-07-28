package com.smartdoc.microservices.impl;

import com.pmarlen.l30.api.CatalogosSimplesService;
import com.pmarlen.l30.backend.assembler.EstadoAssembler;
import com.pmarlen.l30.backend.dto.EstadoDTO;
import com.pmarlen.l30.backend.entity.Estado;
import com.pmarlen.l30.backend.remote.EstadoFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author alfredo.estrada
 */
@Path("catalogos")
@Named("catalogosSimplesMicroservice")
public class CatalogosSimplesMicroservice  implements CatalogosSimplesService {

	@Context
	private UriInfo context;
	
	//			   java:global/L30-Backend-ear-ear-1.0-SNAPSHOT/L30-Backend-ear-ejb-1.0-SNAPSHOT/EstadoFacade!com.smartdoc.backend.ejb.EstadoFacadeRemote
	//			   java:global/L30-Backend-ear-ear-1.0-SNAPSHOT/L30-Backend-ear-ejb-1.0-SNAPSHOT/EstadoFacade
	//			   java:module/EstadoFacade
	@EJB(lookup = "java:global/L30-Backend-ear-ear-1.0-SNAPSHOT/L30-Backend-ear-ejb-1.0-SNAPSHOT/EstadoFacade")	
	EstadoFacadeRemote estadoFacade;
	
	/**
	 * Creates a new instance of CatalogosResource
	 */
	public CatalogosSimplesMicroservice() {
	}

	/**
	 * Retrieves representation of an instance of com.smartdoc.services.CatalogosSimplesMicroservice
	 * @return an instance of java.lang.String
	 */
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("estados")
	public List<EstadoDTO> getEstados() {
		List<EstadoDTO> estadoDTOList = new ArrayList<>();
		if(estadoFacade != null){
			final List<Estado> rolesList = estadoFacade.findAll();
			for(Estado r: rolesList){
				System.out.println("\t->Estados:"+r);
				estadoDTOList.add(EstadoAssembler.buildDTOEntity(r));
			}			
		} else {
			System.err.println("->rolesFacade is null");
		}
		return estadoDTOList;
	}

}
