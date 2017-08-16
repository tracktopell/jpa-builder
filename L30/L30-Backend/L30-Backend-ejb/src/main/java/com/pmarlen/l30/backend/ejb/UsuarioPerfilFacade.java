package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.backend.entity.UsuarioPerfil;
import com.pmarlen.l30.backend.remote.UsuarioPerfilFacadeRemote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table USUARIO_PERFIL.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class UsuarioPerfilFacade extends AbstractFacade<UsuarioPerfil> implements UsuarioPerfilFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UsuarioPerfilFacade() {
		super(UsuarioPerfil.class);
	}

	@Override
	public List<UsuarioPerfil> findAllLike(UsuarioPerfil x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM UsuarioPerfil x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getUsuarioPerfilPK() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuarioPerfilPK = :usuarioPerfilPK");
			}
			if(x.getUsuariousuario() != null){
			    paramAsigned++;
			    sbq.append(" and x.usuariousuario = :usuariousuario");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<UsuarioPerfil> nq = em.createQuery(sbq.toString(), UsuarioPerfil.class);
		
		if(paramAsigned>0){
			if(x.getUsuarioPerfilPK() != null){
			    nq.setParameter("usuarioPerfilPK",x.getUsuarioPerfilPK());
			}
			if(x.getUsuariousuario() != null){
			    nq.setParameter("usuariousuario",x.getUsuariousuario());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<UsuarioPerfil> findAll() {
		TypedQuery<UsuarioPerfil> nq = em.createNamedQuery("UsuarioPerfil.findAll", UsuarioPerfil.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("UsuarioPerfil.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
