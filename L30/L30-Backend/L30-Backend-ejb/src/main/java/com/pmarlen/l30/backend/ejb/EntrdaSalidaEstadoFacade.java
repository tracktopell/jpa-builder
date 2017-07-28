package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.EntrdaSalidaEstado;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table ENTRDA_SALIDA_ESTADO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class EntrdaSalidaEstadoFacade extends AbstractFacade<EntrdaSalidaEstado> implements EntrdaSalidaEstadoFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public EntrdaSalidaEstadoFacade() {
		super(EntrdaSalidaEstado.class);
	}

	@Override
	public List<EntrdaSalidaEstado> findAllLike(EntrdaSalidaEstado x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM EntrdaSalidaEstado x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getEntradaSalidaentradaSala() != null){
			    paramAsigned++;
			    sbq.append(" and x.entradaSalidaentradaSala = :entradaSalidaentradaSala");
			}
			if(x.getFecha() != null){
			    paramAsigned++;
			    sbq.append(" and x.fecha = :fecha");
			}
			if(x.getComentarios() != null){
			    paramAsigned++;
			    sbq.append(" and x.comentarios = :comentarios");
			}
			if(x.getEstadoestado() != null){
			    paramAsigned++;
			    sbq.append(" and x.estadoestado = :estadoestado");
			}
			if(x.getUsuariousuario() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuariousuario = :usuariousuario");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<EntrdaSalidaEstado> nq = em.createQuery(sbq.toString(), EntrdaSalidaEstado.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getEntradaSalidaentradaSala() != null){
			    nq.setParameter("entradaSalidaentradaSala",x.getEntradaSalidaentradaSala());
			}
			if(x.getFecha() != null){
			    nq.setParameter("fecha",x.getFecha());
			}
			if(x.getComentarios() != null){
			    nq.setParameter("comentarios",x.getComentarios());
			}
			if(x.getEstadoestado() != null){
			    nq.setParameter("estadoestado",x.getEstadoestado());
			}
			if(x.getUsuariousuario() != null){
			    nq.setParameter("usuariousuario",x.getUsuariousuario());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<EntrdaSalidaEstado> findAll() {
		TypedQuery<EntrdaSalidaEstado> nq = em.createNamedQuery("EntrdaSalidaEstado.findAll", EntrdaSalidaEstado.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("EntrdaSalidaEstado.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
