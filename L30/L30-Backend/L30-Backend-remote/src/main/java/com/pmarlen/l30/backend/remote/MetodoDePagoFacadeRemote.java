package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.MetodoDePago;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Remote
public interface MetodoDePagoFacadeRemote {

	MetodoDePago create(MetodoDePago entity);

	MetodoDePago edit(MetodoDePago entity);

	void remove(MetodoDePago entity);

	MetodoDePago findByPK(Object id);

	List<MetodoDePago> findAllLike(MetodoDePago entity);

	List<MetodoDePago> findAll();

	List<MetodoDePago> findRange(int[] range);

	Long count();

	Long countAll();

}
