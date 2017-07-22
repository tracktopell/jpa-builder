package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.OfertaProducto;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table OFERTA_PRODUCTO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */
@Stateless
public class OfertaProductoFacade extends AbstractFacade<OfertaProducto> implements OfertaProductoFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public OfertaProductoFacade() {
		super(OfertaProducto.class);
	}

	@Override
	public List<OfertaProducto> findAllLike(OfertaProducto x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM OfertaProducto x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getProductoproducto() != null){
			    paramAsigned++;
			    sbq.append(" and x.productoproducto = :productoproducto");
			}
			if(x.getSucursalsucursal() != null){
			    paramAsigned++;
			    sbq.append(" and x.sucursalsucursal = :sucursalsucursal");
			}
			if(x.getPromocionpromocion() != null){
			    paramAsigned++;
			    sbq.append(" and x.promocionpromocion = :promocionpromocion");
			}
			if(x.getFechaInicial() != null){
			    paramAsigned++;
			    sbq.append(" and x.fechaInicial = :fechaInicial");
			}
			if(x.getFechaFinal() != null){
			    paramAsigned++;
			    sbq.append(" and x.fechaFinal = :fechaFinal");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<OfertaProducto> nq = em.createQuery(sbq.toString(), OfertaProducto.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getProductoproducto() != null){
			    nq.setParameter("productoproducto",x.getProductoproducto());
			}
			if(x.getSucursalsucursal() != null){
			    nq.setParameter("sucursalsucursal",x.getSucursalsucursal());
			}
			if(x.getPromocionpromocion() != null){
			    nq.setParameter("promocionpromocion",x.getPromocionpromocion());
			}
			if(x.getFechaInicial() != null){
			    nq.setParameter("fechaInicial",x.getFechaInicial());
			}
			if(x.getFechaFinal() != null){
			    nq.setParameter("fechaFinal",x.getFechaFinal());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<OfertaProducto> findAll() {
		TypedQuery<OfertaProducto> nq = em.createNamedQuery("OfertaProducto.findAll", OfertaProducto.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("OfertaProducto.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
