package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.Sucursal;
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
public interface SucursalFacadeLocal {

	Sucursal create(Sucursal entity);

	Sucursal edit(Sucursal entity);

	void remove(Sucursal entity);

	Sucursal findByPK(Object id);

	List<Sucursal> findAllLike(Sucursal entity);

	List<Sucursal> findAll();

	List<Sucursal> findRange(int[] range);

	Long count();

	Long countAll();

}
