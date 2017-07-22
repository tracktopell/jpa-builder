package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.UsuarioPerfilPK;
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
public interface UsuarioPerfilPKFacadeRemote {

	UsuarioPerfilPK create(UsuarioPerfilPK entity);

	UsuarioPerfilPK edit(UsuarioPerfilPK entity);

	void remove(UsuarioPerfilPK entity);

	UsuarioPerfilPK findByPK(Object id);

	List<UsuarioPerfilPK> findAllLike(UsuarioPerfilPK entity);

	List<UsuarioPerfilPK> findAll();

	List<UsuarioPerfilPK> findRange(int[] range);

	Long count();

	Long countAll();

}
