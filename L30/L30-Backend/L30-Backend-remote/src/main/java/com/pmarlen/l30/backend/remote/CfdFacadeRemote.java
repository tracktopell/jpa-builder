package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.Cfd;
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
public interface CfdFacadeRemote {

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
