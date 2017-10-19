package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.Sucursal;
import com.pmarlen.l30.backend.local.SucursalFacadeLocal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table SUCURSAL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */
@Stateless
public class SucursalFacade extends AbstractFacade<Sucursal> implements SucursalFacadeLocal {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public SucursalFacade() {
		super(Sucursal.class);
	}

	@Override
	public List<Sucursal> findAllLike(Sucursal x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Sucursal x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getTipo()  != 0){
			    paramAsigned++;
			    sbq.append(" and x.tipo = :tipo");
			}
			if(x.getClave() != null){
			    paramAsigned++;
			    sbq.append(" and x.clave = :clave");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getDireccion() != null){
			    paramAsigned++;
			    sbq.append(" and x.direccion = :direccion");
			}
			if(x.getTelefonos() != null){
			    paramAsigned++;
			    sbq.append(" and x.telefonos = :telefonos");
			}
			if(x.getDescuentoMyoreoHabilitado()  != 0){
			    paramAsigned++;
			    sbq.append(" and x.descuentoMyoreoHabilitado = :descuentoMyoreoHabilitado");
			}
			if(x.getVentaRegHabilitado()  != 0){
			    paramAsigned++;
			    sbq.append(" and x.ventaRegHabilitado = :ventaRegHabilitado");
			}
			if(x.getVentaOpo()  != 0){
			    paramAsigned++;
			    sbq.append(" and x.ventaOpo = :ventaOpo");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Sucursal> nq = em.createQuery(sbq.toString(), Sucursal.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getTipo()  != 0){
			    nq.setParameter("tipo",x.getTipo());
			}
			if(x.getClave() != null){
			    nq.setParameter("clave",x.getClave());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getDireccion() != null){
			    nq.setParameter("direccion",x.getDireccion());
			}
			if(x.getTelefonos() != null){
			    nq.setParameter("telefonos",x.getTelefonos());
			}
			if(x.getDescuentoMyoreoHabilitado()  != 0){
			    nq.setParameter("descuentoMyoreoHabilitado",x.getDescuentoMyoreoHabilitado());
			}
			if(x.getVentaRegHabilitado()  != 0){
			    nq.setParameter("ventaRegHabilitado",x.getVentaRegHabilitado());
			}
			if(x.getVentaOpo()  != 0){
			    nq.setParameter("ventaOpo",x.getVentaOpo());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Sucursal> findAll() {
		TypedQuery<Sucursal> nq = em.createNamedQuery("Sucursal.findAll", Sucursal.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Sucursal.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
