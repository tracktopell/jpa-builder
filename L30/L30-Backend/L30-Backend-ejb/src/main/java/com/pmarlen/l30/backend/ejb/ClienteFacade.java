package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.Cliente;
import com.pmarlen.l30.backend.remote.ClienteFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table CLIENTE.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ClienteFacade() {
		super(Cliente.class);
	}

	@Override
	public List<Cliente> findAllLike(Cliente x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Cliente x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getRfc() != null){
			    paramAsigned++;
			    sbq.append(" and x.rfc = :rfc");
			}
			if(x.getRazonSocial() != null){
			    paramAsigned++;
			    sbq.append(" and x.razonSocial = :razonSocial");
			}
			if(x.getNombreEstablecimiento() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombreEstablecimiento = :nombreEstablecimiento");
			}
			if(x.getDireccionFacturacion() != null){
			    paramAsigned++;
			    sbq.append(" and x.direccionFacturacion = :direccionFacturacion");
			}
			if(x.getTelefonos() != null){
			    paramAsigned++;
			    sbq.append(" and x.telefonos = :telefonos");
			}
			if(x.getBanco() != null){
			    paramAsigned++;
			    sbq.append(" and x.banco = :banco");
			}
			if(x.getNumCuenta() != null){
			    paramAsigned++;
			    sbq.append(" and x.numCuenta = :numCuenta");
			}
			if(x.getEmail() != null){
			    paramAsigned++;
			    sbq.append(" and x.email = :email");
			}
			if(x.getReferencia() != null){
			    paramAsigned++;
			    sbq.append(" and x.referencia = :referencia");
			}
			if(x.getContacto() != null){
			    paramAsigned++;
			    sbq.append(" and x.contacto = :contacto");
			}
			if(x.getUbicacionLat() != null){
			    paramAsigned++;
			    sbq.append(" and x.ubicacionLat = :ubicacionLat");
			}
			if(x.getUbicacionLon() != null){
			    paramAsigned++;
			    sbq.append(" and x.ubicacionLon = :ubicacionLon");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Cliente> nq = em.createQuery(sbq.toString(), Cliente.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getRfc() != null){
			    nq.setParameter("rfc",x.getRfc());
			}
			if(x.getRazonSocial() != null){
			    nq.setParameter("razonSocial",x.getRazonSocial());
			}
			if(x.getNombreEstablecimiento() != null){
			    nq.setParameter("nombreEstablecimiento",x.getNombreEstablecimiento());
			}
			if(x.getDireccionFacturacion() != null){
			    nq.setParameter("direccionFacturacion",x.getDireccionFacturacion());
			}
			if(x.getTelefonos() != null){
			    nq.setParameter("telefonos",x.getTelefonos());
			}
			if(x.getBanco() != null){
			    nq.setParameter("banco",x.getBanco());
			}
			if(x.getNumCuenta() != null){
			    nq.setParameter("numCuenta",x.getNumCuenta());
			}
			if(x.getEmail() != null){
			    nq.setParameter("email",x.getEmail());
			}
			if(x.getReferencia() != null){
			    nq.setParameter("referencia",x.getReferencia());
			}
			if(x.getContacto() != null){
			    nq.setParameter("contacto",x.getContacto());
			}
			if(x.getUbicacionLat() != null){
			    nq.setParameter("ubicacionLat",x.getUbicacionLat());
			}
			if(x.getUbicacionLon() != null){
			    nq.setParameter("ubicacionLon",x.getUbicacionLon());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Cliente> findAll() {
		TypedQuery<Cliente> nq = em.createNamedQuery("Cliente.findAll", Cliente.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Cliente.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
