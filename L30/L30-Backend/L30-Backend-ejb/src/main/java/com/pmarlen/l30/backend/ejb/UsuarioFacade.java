package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.Usuario;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * ESB JPA Entity of Table USUARIO.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeRemote {

	@PersistenceContext(unitName = "L30_PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UsuarioFacade() {
		super(Usuario.class);
	}

	@Override
	public List<Usuario> findAllLike(Usuario x){
		//return null;
		
		StringBuilder sbq=new StringBuilder("SELECT x FROM Usuario x WHERE ");
		int paramAsigned=0;
		if(x != null){
			sbq.append(" 1=1 ");
			if(x.getId() != null){
			    paramAsigned++;
			    sbq.append(" and x.id = :id");
			}
			if(x.getEmail() != null){
			    paramAsigned++;
			    sbq.append(" and x.email = :email");
			}
			if(x.getPassword() != null){
			    paramAsigned++;
			    sbq.append(" and x.password = :password");
			}
			if(x.getTelefonos() != null){
			    paramAsigned++;
			    sbq.append(" and x.telefonos = :telefonos");
			}
			if(x.getHabilitado() != 0){
			    paramAsigned++;
			    sbq.append(" and x.habilitado = :habilitado");
			}
			if(x.getNombre() != null){
			    paramAsigned++;
			    sbq.append(" and x.nombre = :nombre");
			}
			if(x.getApellidoPaterno() != null){
			    paramAsigned++;
			    sbq.append(" and x.apellidoPaterno = :apellidoPaterno");
			}
			if(x.getApellidoMaterno() != null){
			    paramAsigned++;
			    sbq.append(" and x.apellidoMaterno = :apellidoMaterno");
			}
			if(x.getFechaRegistro() != null){
			    paramAsigned++;
			    sbq.append(" and x.fechaRegistro = :fechaRegistro");
			}
			if(x.getFechaUltCambio() != null){
			    paramAsigned++;
			    sbq.append(" and x.fechaUltCambio = :fechaUltCambio");
			}
			if(x.getSucursalsucursal() != null){
			    paramAsigned++;
			    sbq.append(" and x.sucursalsucursal = :sucursalsucursal");
			}
			
		} else {
			sbq.append(" 1=2 ");
		}
		
		TypedQuery<Usuario> nq = em.createQuery(sbq.toString(), Usuario.class);
		
		if(paramAsigned>0){
			if(x.getId() != null){
			    nq.setParameter("id",x.getId());
			}
			if(x.getEmail() != null){
			    nq.setParameter("email",x.getEmail());
			}
			if(x.getPassword() != null){
			    nq.setParameter("password",x.getPassword());
			}
			if(x.getTelefonos() != null){
			    nq.setParameter("telefonos",x.getTelefonos());
			}
			if(x.getHabilitado() != (0) ){
			    nq.setParameter("habilitado",x.getHabilitado());
			}
			if(x.getNombre() != null){
			    nq.setParameter("nombre",x.getNombre());
			}
			if(x.getApellidoPaterno() != null){
			    nq.setParameter("apellidoPaterno",x.getApellidoPaterno());
			}
			if(x.getApellidoMaterno() != null){
			    nq.setParameter("apellidoMaterno",x.getApellidoMaterno());
			}
			if(x.getFechaRegistro() != null){
			    nq.setParameter("fechaRegistro",x.getFechaRegistro());
			}
			if(x.getFechaUltCambio() != null){
			    nq.setParameter("fechaUltCambio",x.getFechaUltCambio());
			}
			if(x.getSucursalsucursal() != null){
			    nq.setParameter("sucursalsucursal",x.getSucursalsucursal());
			}
			
		}		
		return nq.getResultList();
		
	}

	@Override
	public List<Usuario> findAll() {
		TypedQuery<Usuario> nq = em.createNamedQuery("Usuario.findAll", Usuario.class);		
		return nq.getResultList();
	}
	
	@Override
	public Long countAll() {
		TypedQuery<Long> nq = em.createNamedQuery("Usuario.countAll", Long.class);		
		return (Long)nq.getSingleResult().longValue();
	}
	
}
