package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.EntradaSalida;
import com.pmarlen.l30.backend.remote.EntradaSalidaFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table ENTRADA_SALIDA.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class EntradaSalidaFacade extends AbstractFacade<EntradaSalida> implements EntradaSalidaFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public EntradaSalidaFacade() {
		super(EntradaSalida.class);
	}

	@Override
	public List<EntradaSalida> findAllLike(EntradaSalida x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM EntradaSalida x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getTipoMov() != 0){
			    paramAsigned++;
			    sbq.append(" and x.tipoMov = :tipoMov");
			}
			if(x.getFechaCreo() != null){
			    paramAsigned++;
			    sbq.append(" and x.fechaCreo = :fechaCreo");
			}
			if(x.getEstadoestadoActual() != null){
			    paramAsigned++;
			    sbq.append(" and x.estadoestadoActual = :estadoestadoActual");
			}
			if(x.getClientecliente() != null){
			    paramAsigned++;
			    sbq.append(" and x.clientecliente = :clientecliente");
			}
			if(x.getFormaDePagoformaDePago() != null){
			    paramAsigned++;
			    sbq.append(" and x.formaDePagoformaDePago = :formaDePagoformaDePago");
			}
			if(x.getMetodoDePagometodoDePago() != null){
			    paramAsigned++;
			    sbq.append(" and x.metodoDePagometodoDePago = :metodoDePagometodoDePago");
			}
			if(x.getUsuariousuarioCreo() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuariousuarioCreo = :usuariousuarioCreo");
			}
			if(x.getUsuariousuario() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuariousuario = :usuariousuario");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<EntradaSalida> nq = em.createQuery(sbq.toString(), EntradaSalida.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getTipoMov() != (0) ){
			    nq.setParameter("tipoMov",x.getTipoMov());
			}
			if(x.getFechaCreo() != null){
			    nq.setParameter("fechaCreo",x.getFechaCreo());
			}
			if(x.getEstadoestadoActual() != null){
			    nq.setParameter("estadoestadoActual",x.getEstadoestadoActual());
			}
			if(x.getClientecliente() != null){
			    nq.setParameter("clientecliente",x.getClientecliente());
			}
			if(x.getFormaDePagoformaDePago() != null){
			    nq.setParameter("formaDePagoformaDePago",x.getFormaDePagoformaDePago());
			}
			if(x.getMetodoDePagometodoDePago() != null){
			    nq.setParameter("metodoDePagometodoDePago",x.getMetodoDePagometodoDePago());
			}
			if(x.getUsuariousuarioCreo() != null){
			    nq.setParameter("usuariousuarioCreo",x.getUsuariousuarioCreo());
			}
			if(x.getUsuariousuario() != null){
			    nq.setParameter("usuariousuario",x.getUsuariousuario());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<EntradaSalida> findAll() {
		TypedQuery<EntradaSalida> nq = em.createNamedQuery("EntradaSalida.findAll", EntradaSalida.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("EntradaSalida.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
