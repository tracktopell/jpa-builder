package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.EntrdaSalidaEstado;
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
public interface EntrdaSalidaEstadoFacadeRemote {

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
