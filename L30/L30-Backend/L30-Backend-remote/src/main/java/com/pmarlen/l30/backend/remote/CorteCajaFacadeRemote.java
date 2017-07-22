package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.CorteCaja;
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
public interface CorteCajaFacadeRemote {

	CorteCaja create(CorteCaja entity);

	CorteCaja edit(CorteCaja entity);

	void remove(CorteCaja entity);

	CorteCaja findByPK(Object id);

	List<CorteCaja> findAllLike(CorteCaja entity);

	List<CorteCaja> findAll();

	List<CorteCaja> findRange(int[] range);

	Long count();

	Long countAll();

}
