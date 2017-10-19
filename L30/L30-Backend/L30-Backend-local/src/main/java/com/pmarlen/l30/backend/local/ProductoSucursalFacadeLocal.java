package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.ProductoSucursal;
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
public interface ProductoSucursalFacadeLocal {

	ProductoSucursal create(ProductoSucursal entity);

	ProductoSucursal edit(ProductoSucursal entity);

	void remove(ProductoSucursal entity);

	ProductoSucursal findByPK(Object id);

	List<ProductoSucursal> findAllLike(ProductoSucursal entity);

	List<ProductoSucursal> findAll();

	List<ProductoSucursal> findRange(int[] range);

	Long count();

	Long countAll();

}
