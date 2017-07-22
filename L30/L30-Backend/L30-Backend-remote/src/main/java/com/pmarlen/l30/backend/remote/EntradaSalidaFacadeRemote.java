package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.EntradaSalida;
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
public interface EntradaSalidaFacadeRemote {

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
