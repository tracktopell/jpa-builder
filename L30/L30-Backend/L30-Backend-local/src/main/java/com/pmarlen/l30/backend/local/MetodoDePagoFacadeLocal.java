package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.MetodoDePago;
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
public interface MetodoDePagoFacadeLocal {

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
