package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.Producto;
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
public interface ProductoFacadeRemote {

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
