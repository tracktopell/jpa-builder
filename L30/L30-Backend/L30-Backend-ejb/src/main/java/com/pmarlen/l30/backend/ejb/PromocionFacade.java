package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.Promocion;
import com.pmarlen.l30.backend.local.PromocionFacadeLocal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * SSB JPA Entity of Table PROMOCION.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */
@Stateless
public class PromocionFacade extends AbstractFacade<Promocion> implements PromocionFacadeLocal {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PromocionFacade() {
		super(Promocion.class);
	}

	@Override
	public List<Promocion> findAllLike(Promocion x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Promocion x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getReglaAritmetica() != null){
			    paramAsigned++;
			    sbq.append(" and x.reglaAritmetica = :reglaAritmetica");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Promocion> nq = em.createQuery(sbq.toString(), Promocion.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getReglaAritmetica() != null){
			    nq.setParameter("reglaAritmetica",x.getReglaAritmetica());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Promocion> findAll() {
		TypedQuery<Promocion> nq = em.createNamedQuery("Promocion.findAll", Promocion.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Promocion.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
