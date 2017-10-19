package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.EntradaSalida;
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
public interface EntradaSalidaFacadeLocal {

	EntradaSalida create(EntradaSalida entity);

	EntradaSalida edit(EntradaSalida entity);

	void remove(EntradaSalida entity);

	EntradaSalida findByPK(Object id);

	List<EntradaSalida> findAllLike(EntradaSalida entity);

	List<EntradaSalida> findAll();

	List<EntradaSalida> findRange(int[] range);

	Long count();

	Long countAll();

}
