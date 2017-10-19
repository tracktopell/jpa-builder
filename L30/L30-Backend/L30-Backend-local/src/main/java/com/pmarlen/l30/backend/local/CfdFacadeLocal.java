package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.Cfd;
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
public interface CfdFacadeLocal {

	Cfd create(Cfd entity);

	Cfd edit(Cfd entity);

	void remove(Cfd entity);

	Cfd findByPK(Object id);

	List<Cfd> findAllLike(Cfd entity);

	List<Cfd> findAll();

	List<Cfd> findRange(int[] range);

	Long count();

	Long countAll();

}
