package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.FormaDePago;
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
public interface FormaDePagoFacadeLocal {

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
