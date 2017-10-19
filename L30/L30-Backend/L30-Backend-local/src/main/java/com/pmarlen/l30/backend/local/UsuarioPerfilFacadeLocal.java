package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.UsuarioPerfil;
import java.util.List;
import javax.ejb.Local;

/**
 * JPA Entity @Local Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.14.1
 * @date 2017/10/19 00:02
 */
@Local
public interface UsuarioPerfilFacadeLocal {

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
