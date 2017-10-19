package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.UsuarioPerfilPK;
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
public interface UsuarioPerfilPKFacadeLocal {

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
