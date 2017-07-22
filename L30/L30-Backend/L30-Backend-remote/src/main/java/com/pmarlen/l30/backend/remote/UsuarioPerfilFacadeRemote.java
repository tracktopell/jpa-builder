package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.UsuarioPerfil;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/21 18:00
 */
@Remote
public interface UsuarioPerfilFacadeRemote {

	UsuarioPerfil create(UsuarioPerfil entity);

	UsuarioPerfil edit(UsuarioPerfil entity);

	void remove(UsuarioPerfil entity);

	UsuarioPerfil findByPK(Object id);

	List<UsuarioPerfil> findAllLike(UsuarioPerfil entity);

	List<UsuarioPerfil> findAll();

	List<UsuarioPerfil> findRange(int[] range);

	Long count();

	Long countAll();

}
