package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.ProductoSucursal;
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
public interface ProductoSucursalFacadeRemote {

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
