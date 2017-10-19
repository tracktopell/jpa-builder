package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.Estado;
import com.pmarlen.l30.backend.local.EstadoFacadeLocal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table ESTADO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> implements EstadoFacadeLocal {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public EstadoFacade() {
		super(Estado.class);
	}

	@Override
	public List<Estado> findAllLike(Estado x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Estado x WHERE ");
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
		
		TypedQuery<Estado> nq = em.createQuery(sbq.toString(), Estado.class);
		
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
	public List<Estado> findAll() {
		TypedQuery<Estado> nq = em.createNamedQuery("Estado.findAll", Estado.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Estado.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
