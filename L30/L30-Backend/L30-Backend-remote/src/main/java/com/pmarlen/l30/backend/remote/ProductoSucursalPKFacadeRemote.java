package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.ProductoSucursalPK;
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
public interface ProductoSucursalPKFacadeRemote {

	ProductoSucursalPK create(ProductoSucursalPK entity);

	ProductoSucursalPK edit(ProductoSucursalPK entity);

	void remove(ProductoSucursalPK entity);

	ProductoSucursalPK findByPK(Object id);

	List<ProductoSucursalPK> findAllLike(ProductoSucursalPK entity);

	List<ProductoSucursalPK> findAll();

	List<ProductoSucursalPK> findRange(int[] range);

	Long count();

	Long countAll();

}
