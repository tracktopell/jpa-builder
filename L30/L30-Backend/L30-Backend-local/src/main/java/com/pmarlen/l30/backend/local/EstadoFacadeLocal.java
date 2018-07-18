package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.Estado;
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
public interface EstadoFacadeLocal {

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