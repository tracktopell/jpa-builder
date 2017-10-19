package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.OfertaProducto;
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
public interface OfertaProductoFacadeLocal {

	OfertaProducto create(OfertaProducto entity);

	OfertaProducto edit(OfertaProducto entity);

	void remove(OfertaProducto entity);

	OfertaProducto findByPK(Object id);

	List<OfertaProducto> findAllLike(OfertaProducto entity);

	List<OfertaProducto> findAll();

	List<OfertaProducto> findRange(int[] range);

	Long count();

	Long countAll();

}
