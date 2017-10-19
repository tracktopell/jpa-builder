package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.EntrdaSalidaEstado;
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
public interface EntrdaSalidaEstadoFacadeLocal {

	EntrdaSalidaEstado create(EntrdaSalidaEstado entity);

	EntrdaSalidaEstado edit(EntrdaSalidaEstado entity);

	void remove(EntrdaSalidaEstado entity);

	EntrdaSalidaEstado findByPK(Object id);

	List<EntrdaSalidaEstado> findAllLike(EntrdaSalidaEstado entity);

	List<EntrdaSalidaEstado> findAll();

	List<EntrdaSalidaEstado> findRange(int[] range);

	Long count();

	Long countAll();

}
