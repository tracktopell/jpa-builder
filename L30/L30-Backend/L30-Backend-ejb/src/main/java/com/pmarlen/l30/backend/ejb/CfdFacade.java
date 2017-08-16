package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.Cfd;
import com.pmarlen.l30.backend.remote.CfdFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table CFD.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class CfdFacade extends AbstractFacade<Cfd> implements CfdFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CfdFacade() {
		super(Cfd.class);
	}

	@Override
	public List<Cfd> findAllLike(Cfd x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Cfd x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getCfdcfdOrigen() != null){
			    paramAsigned++;
			    sbq.append(" and x.cfdcfdOrigen = :cfdcfdOrigen");
			}
			if(x.getEntradaSalidaentradaSala() != null){
			    paramAsigned++;
			    sbq.append(" and x.entradaSalidaentradaSala = :entradaSalidaentradaSala");
			}
			if(x.getTipo() != null){
			    paramAsigned++;
			    sbq.append(" and x.tipo = :tipo");
			}
			if(x.getNumCfd() != null){
			    paramAsigned++;
			    sbq.append(" and x.numCfd = :numCfd");
			}
			if(x.getUltimoError() != null){
			    paramAsigned++;
			    sbq.append(" and x.ultimoError = :ultimoError");
			}
			if(x.getContenidoOriginal() != null){
			    paramAsigned++;
			    sbq.append(" and x.contenidoOriginal = :contenidoOriginal");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Cfd> nq = em.createQuery(sbq.toString(), Cfd.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getCfdcfdOrigen() != null){
			    nq.setParameter("cfdcfdOrigen",x.getCfdcfdOrigen());
			}
			if(x.getEntradaSalidaentradaSala() != null){
			    nq.setParameter("entradaSalidaentradaSala",x.getEntradaSalidaentradaSala());
			}
			if(x.getTipo() != null){
			    nq.setParameter("tipo",x.getTipo());
			}
			if(x.getNumCfd() != null){
			    nq.setParameter("numCfd",x.getNumCfd());
			}
			if(x.getUltimoError() != null){
			    nq.setParameter("ultimoError",x.getUltimoError());
			}
			if(x.getContenidoOriginal() != null){
			    nq.setParameter("contenidoOriginal",x.getContenidoOriginal());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Cfd> findAll() {
		TypedQuery<Cfd> nq = em.createNamedQuery("Cfd.findAll", Cfd.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Cfd.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
