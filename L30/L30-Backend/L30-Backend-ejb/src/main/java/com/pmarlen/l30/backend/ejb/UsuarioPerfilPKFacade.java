package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.UsuarioPerfilPK;
import com.pmarlen.l30.backend.remote.UsuarioPerfilPKFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table USUARIO_PERFIL_P_K.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class UsuarioPerfilPKFacade extends AbstractFacade<UsuarioPerfilPK> implements UsuarioPerfilPKFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UsuarioPerfilPKFacade() {
		super(UsuarioPerfilPK.class);
	}

	@Override
	public List<UsuarioPerfilPK> findAllLike(UsuarioPerfilPK x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM UsuarioPerfilPK x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getUsuarioId() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuarioId = :usuarioId");
			}
			if(x.getPerfil() != null){
			    paramAsigned++;
			    sbq.append(" and x.perfil = :perfil");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<UsuarioPerfilPK> nq = em.createQuery(sbq.toString(), UsuarioPerfilPK.class);
		
		if(paramAsigned>0){
			if(x.getUsuarioId() != null){
			    nq.setParameter("usuarioId",x.getUsuarioId());
			}
			if(x.getPerfil() != null){
			    nq.setParameter("perfil",x.getPerfil());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<UsuarioPerfilPK> findAll() {
		TypedQuery<UsuarioPerfilPK> nq = em.createNamedQuery("UsuarioPerfilPK.findAll", UsuarioPerfilPK.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("UsuarioPerfilPK.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
