package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.MetodoDePago;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table METODO_DE_PAGO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */
@Stateless
public class MetodoDePagoFacade extends AbstractFacade<MetodoDePago> implements MetodoDePagoFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MetodoDePagoFacade() {
		super(MetodoDePago.class);
	}

	@Override
	public List<MetodoDePago> findAllLike(MetodoDePago x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM MetodoDePago x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getDescripcion() != null){
			    paramAsigned++;
			    sbq.append(" and x.descripcion = :descripcion");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<MetodoDePago> nq = em.createQuery(sbq.toString(), MetodoDePago.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getDescripcion() != null){
			    nq.setParameter("descripcion",x.getDescripcion());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<MetodoDePago> findAll() {
		TypedQuery<MetodoDePago> nq = em.createNamedQuery("MetodoDePago.findAll", MetodoDePago.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("MetodoDePago.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
