package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.MovimientoOperativo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table MOVIMIENTO_OPERATIVO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class MovimientoOperativoFacade extends AbstractFacade<MovimientoOperativo> implements MovimientoOperativoFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MovimientoOperativoFacade() {
		super(MovimientoOperativo.class);
	}

	@Override
	public List<MovimientoOperativo> findAllLike(MovimientoOperativo x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM MovimientoOperativo x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getMotivo() != null){
			    paramAsigned++;
			    sbq.append(" and x.motivo = :motivo");
			}
			if(x.getFecha() != null){
			    paramAsigned++;
			    sbq.append(" and x.fecha = :fecha");
			}
			if(x.getSucursalsucursalOrigen() != null){
			    paramAsigned++;
			    sbq.append(" and x.sucursalsucursalOrigen = :sucursalsucursalOrigen");
			}
			if(x.getAlmacenOrigen() != null){
			    paramAsigned++;
			    sbq.append(" and x.almacenOrigen = :almacenOrigen");
			}
			if(x.getSucursalsucursalDestino() != null){
			    paramAsigned++;
			    sbq.append(" and x.sucursalsucursalDestino = :sucursalsucursalDestino");
			}
			if(x.getAlmacenDestino() != null){
			    paramAsigned++;
			    sbq.append(" and x.almacenDestino = :almacenDestino");
			}
			if(x.getTipoMov() != 0){
			    paramAsigned++;
			    sbq.append(" and x.tipoMov = :tipoMov");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<MovimientoOperativo> nq = em.createQuery(sbq.toString(), MovimientoOperativo.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getMotivo() != null){
			    nq.setParameter("motivo",x.getMotivo());
			}
			if(x.getFecha() != null){
			    nq.setParameter("fecha",x.getFecha());
			}
			if(x.getSucursalsucursalOrigen() != null){
			    nq.setParameter("sucursalsucursalOrigen",x.getSucursalsucursalOrigen());
			}
			if(x.getAlmacenOrigen() != null){
			    nq.setParameter("almacenOrigen",x.getAlmacenOrigen());
			}
			if(x.getSucursalsucursalDestino() != null){
			    nq.setParameter("sucursalsucursalDestino",x.getSucursalsucursalDestino());
			}
			if(x.getAlmacenDestino() != null){
			    nq.setParameter("almacenDestino",x.getAlmacenDestino());
			}
			if(x.getTipoMov() != (0) ){
			    nq.setParameter("tipoMov",x.getTipoMov());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<MovimientoOperativo> findAll() {
		TypedQuery<MovimientoOperativo> nq = em.createNamedQuery("MovimientoOperativo.findAll", MovimientoOperativo.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("MovimientoOperativo.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
