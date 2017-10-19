package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.Producto;
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
public interface ProductoFacadeLocal {

	Producto create(Producto entity);

	Producto edit(Producto entity);

	void remove(Producto entity);

	Producto findByPK(Object id);

	List<Producto> findAllLike(Producto entity);

	List<Producto> findAll();

	List<Producto> findRange(int[] range);

	Long count();

	Long countAll();

}
