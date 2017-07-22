package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.FormaDePago;
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
public interface FormaDePagoFacadeRemote {

	FormaDePago create(FormaDePago entity);

	FormaDePago edit(FormaDePago entity);

	void remove(FormaDePago entity);

	FormaDePago findByPK(Object id);

	List<FormaDePago> findAllLike(FormaDePago entity);

	List<FormaDePago> findAll();

	List<FormaDePago> findRange(int[] range);

	Long count();

	Long countAll();

}
