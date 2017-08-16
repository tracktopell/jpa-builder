package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.CorteCaja;
import com.pmarlen.l30.backend.remote.CorteCajaFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table CORTE_CAJA.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class CorteCajaFacade extends AbstractFacade<CorteCaja> implements CorteCajaFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CorteCajaFacade() {
		super(CorteCaja.class);
	}

	@Override
	public List<CorteCaja> findAllLike(CorteCaja x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM CorteCaja x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getSucursalsucursal() != null){
			    paramAsigned++;
			    sbq.append(" and x.sucursalsucursal = :sucursalsucursal");
			}
			if(x.getTipoEvento() != 0){
			    paramAsigned++;
			    sbq.append(" and x.tipoEvento = :tipoEvento");
			}
			if(x.getUsuariousuario() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuariousuario = :usuariousuario");
			}
			if(x.getFecha() != null){
			    paramAsigned++;
			    sbq.append(" and x.fecha = :fecha");
			}
			if(x.getFechaUap() != null){
			    paramAsigned++;
			    sbq.append(" and x.fechaUap = :fechaUap");
			}
			if(x.getSaldoInicial() != null){
			    paramAsigned++;
			    sbq.append(" and x.saldoInicial = :saldoInicial");
			}
			if(x.getSaldoFinal() != null){
			    paramAsigned++;
			    sbq.append(" and x.saldoFinal = :saldoFinal");
			}
			if(x.getUsuariousuarioAutorizo() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuariousuarioAutorizo = :usuariousuarioAutorizo");
			}
			if(x.getComentarios() != null){
			    paramAsigned++;
			    sbq.append(" and x.comentarios = :comentarios");
			}
			if(x.getCaja() != 0){
			    paramAsigned++;
			    sbq.append(" and x.caja = :caja");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<CorteCaja> nq = em.createQuery(sbq.toString(), CorteCaja.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getSucursalsucursal() != null){
			    nq.setParameter("sucursalsucursal",x.getSucursalsucursal());
			}
			if(x.getTipoEvento() != (0) ){
			    nq.setParameter("tipoEvento",x.getTipoEvento());
			}
			if(x.getUsuariousuario() != null){
			    nq.setParameter("usuariousuario",x.getUsuariousuario());
			}
			if(x.getFecha() != null){
			    nq.setParameter("fecha",x.getFecha());
			}
			if(x.getFechaUap() != null){
			    nq.setParameter("fechaUap",x.getFechaUap());
			}
			if(x.getSaldoInicial() != null){
			    nq.setParameter("saldoInicial",x.getSaldoInicial());
			}
			if(x.getSaldoFinal() != null){
			    nq.setParameter("saldoFinal",x.getSaldoFinal());
			}
			if(x.getUsuariousuarioAutorizo() != null){
			    nq.setParameter("usuariousuarioAutorizo",x.getUsuariousuarioAutorizo());
			}
			if(x.getComentarios() != null){
			    nq.setParameter("comentarios",x.getComentarios());
			}
			if(x.getCaja() != (0) ){
			    nq.setParameter("caja",x.getCaja());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<CorteCaja> findAll() {
		TypedQuery<CorteCaja> nq = em.createNamedQuery("CorteCaja.findAll", CorteCaja.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("CorteCaja.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
