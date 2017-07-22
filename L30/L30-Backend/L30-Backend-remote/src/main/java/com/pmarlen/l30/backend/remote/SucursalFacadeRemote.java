package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.Sucursal;
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
public interface SucursalFacadeRemote {

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
