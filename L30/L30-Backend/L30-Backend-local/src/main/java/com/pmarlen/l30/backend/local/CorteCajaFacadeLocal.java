package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.CorteCaja;
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
public interface CorteCajaFacadeLocal {

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
