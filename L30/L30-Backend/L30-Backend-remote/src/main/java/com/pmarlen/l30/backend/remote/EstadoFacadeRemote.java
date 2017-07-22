package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.Estado;
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
public interface EstadoFacadeRemote {

	Estado create(Estado entity);

	Estado edit(Estado entity);

	void remove(Estado entity);

	Estado findByPK(Object id);

	List<Estado> findAllLike(Estado entity);

	List<Estado> findAll();

	List<Estado> findRange(int[] range);

	Long count();

	Long countAll();

}
