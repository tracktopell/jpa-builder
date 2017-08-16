package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.FormaDePago;
import com.pmarlen.l30.backend.remote.FormaDePagoFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table FORMA_DE_PAGO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class FormaDePagoFacade extends AbstractFacade<FormaDePago> implements FormaDePagoFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public FormaDePagoFacade() {
		super(FormaDePago.class);
	}

	@Override
	public List<FormaDePago> findAllLike(FormaDePago x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM FormaDePago x WHERE ");
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
		
		TypedQuery<FormaDePago> nq = em.createQuery(sbq.toString(), FormaDePago.class);
		
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
	public List<FormaDePago> findAll() {
		TypedQuery<FormaDePago> nq = em.createNamedQuery("FormaDePago.findAll", FormaDePago.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("FormaDePago.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
