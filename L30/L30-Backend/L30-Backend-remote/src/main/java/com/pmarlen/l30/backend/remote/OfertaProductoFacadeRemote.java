package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.OfertaProducto;
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
public interface OfertaProductoFacadeRemote {

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
