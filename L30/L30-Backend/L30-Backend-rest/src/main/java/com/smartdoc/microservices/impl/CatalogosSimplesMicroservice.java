package com.smartdoc.microservices.impl;

import com.pmarlen.l30.api.CatalogosSimplesService;
import com.pmarlen.l30.backend.assembler.EstadoAssembler;
import com.pmarlen.l30.backend.dto.EstadoDTO;
import com.pmarlen.l30.backend.entity.Estado;
import com.pmarlen.l30.backend.remote.EstadoFacadeRemote;
import com.pmarlen.l30.helper.DataSortedModel;
import com.pmarlen.l30.helper.SortField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
//	java:global/L30-Backend-ear-11.0.1/L30-Backend-ejb-11.0.1/EstadoFacade!com.pmarlen.l30.backend.remote.EstadoFacadeRemote
//	java:app/L30-Backend-ejb-11.0.1/EstadoFacade!com.pmarlen.l30.backend.remote.EstadoFacadeRemote
//	java:module/EstadoFacade!com.pmarlen.l30.backend.remote.EstadoFacadeRemote

//	java:jboss/exported/L30-Backend-ear-11.0.1/L30-Backend-ejb-11.0.1/EstadoFacade!com.pmarlen.l30.backend.remote.EstadoFacadeRemote

//* java:global/L30-Backend-ear-11.0.1/L30-Backend-ejb-11.0.1/EstadoFacade
//	java:app/L30-Backend-ejb-11.0.1/EstadoFacade
//	java:module/EstadoFacade
	
	@EJB(lookup = "java:global/L30-Backend-ear-11.0.1/L30-Backend-ejb-11.0.1/EstadoFacade")	
	EstadoFacadeRemote estadoFacade;
	
	/**
	 * Creates a new instance of CatalogosResource
	 */
	public CatalogosSimplesMicroservice() {
	}

	@Override
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
			System.err.println("->estadoFacade is null");
		}
		return estadoDTOList;
	}

	@Override
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("estados/orderby/{field}")
	public List<EstadoDTO> getEstadosOrderBy(@PathParam("field") String field) {
		List<EstadoDTO> estadoDTOList = new ArrayList<>();
		if(estadoFacade != null){
			List<Estado> rolesList = null;
			
			//rolesList = estadoFacade.findAllOrderBy(field);
			List<SortField> sortFieldsList = new ArrayList<>();
			Map<String, Object> filters =new HashMap<>();
			
			sortFieldsList.add(new SortField(field));
			
			filters.put(field, "FACTURADO");
			
			DataSortedModel<Estado> dsm=new DataSortedModel<>(sortFieldsList,filters);
			
			rolesList = estadoFacade.findAllOrder(dsm);
			
			for(Estado r: rolesList){
				System.out.println("\t->EstadosOrderBy("+field+"):"+r);
				estadoDTOList.add(EstadoAssembler.buildDTOEntity(r));
			}			
		} else {
			System.err.println("->estadoFacade is null");
		}
		return estadoDTOList;
	}

	@Override
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("countEstados")
	public int countEstados() {
		int estadoCount = -1;
		if(estadoFacade != null){
			estadoCount = estadoFacade.countAll().intValue();
		} else {
			System.err.println("->rolesFacade is null");
		}
		return estadoCount;
	}

}
