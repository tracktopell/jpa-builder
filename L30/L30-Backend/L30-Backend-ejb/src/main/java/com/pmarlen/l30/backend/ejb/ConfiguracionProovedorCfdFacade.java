package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.ConfiguracionProovedorCfd;
import com.pmarlen.l30.backend.remote.ConfiguracionProovedorCfdFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table CONFIGURACION_PROOVEDOR_CFD.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class ConfiguracionProovedorCfdFacade extends AbstractFacade<ConfiguracionProovedorCfd> implements ConfiguracionProovedorCfdFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ConfiguracionProovedorCfdFacade() {
		super(ConfiguracionProovedorCfd.class);
	}

	@Override
	public List<ConfiguracionProovedorCfd> findAllLike(ConfiguracionProovedorCfd x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM ConfiguracionProovedorCfd x WHERE ");
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
			if(x.getPrioridad() != 0){
			    paramAsigned++;
			    sbq.append(" and x.prioridad = :prioridad");
			}
			if(x.getProveedorCfd() != null){
			    paramAsigned++;
			    sbq.append(" and x.proveedorCfd = :proveedorCfd");
			}
			if(x.getUsuarioCfd() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuarioCfd = :usuarioCfd");
			}
			if(x.getPasswordCfd() != null){
			    paramAsigned++;
			    sbq.append(" and x.passwordCfd = :passwordCfd");
			}
			if(x.getSerieCfd() != null){
			    paramAsigned++;
			    sbq.append(" and x.serieCfd = :serieCfd");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<ConfiguracionProovedorCfd> nq = em.createQuery(sbq.toString(), ConfiguracionProovedorCfd.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getSucursalsucursal() != null){
			    nq.setParameter("sucursalsucursal",x.getSucursalsucursal());
			}
			if(x.getPrioridad() != (0) ){
			    nq.setParameter("prioridad",x.getPrioridad());
			}
			if(x.getProveedorCfd() != null){
			    nq.setParameter("proveedorCfd",x.getProveedorCfd());
			}
			if(x.getUsuarioCfd() != null){
			    nq.setParameter("usuarioCfd",x.getUsuarioCfd());
			}
			if(x.getPasswordCfd() != null){
			    nq.setParameter("passwordCfd",x.getPasswordCfd());
			}
			if(x.getSerieCfd() != null){
			    nq.setParameter("serieCfd",x.getSerieCfd());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<ConfiguracionProovedorCfd> findAll() {
		TypedQuery<ConfiguracionProovedorCfd> nq = em.createNamedQuery("ConfiguracionProovedorCfd.findAll", ConfiguracionProovedorCfd.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("ConfiguracionProovedorCfd.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
