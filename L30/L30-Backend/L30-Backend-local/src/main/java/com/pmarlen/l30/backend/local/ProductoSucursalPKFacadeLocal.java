package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.ProductoSucursalPK;
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
public interface ProductoSucursalPKFacadeLocal {

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
