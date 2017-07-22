package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.ConfiguracionProovedorCfd;
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
public interface ConfiguracionProovedorCfdFacadeRemote {

	ConfiguracionProovedorCfd create(ConfiguracionProovedorCfd entity);

	ConfiguracionProovedorCfd edit(ConfiguracionProovedorCfd entity);

	void remove(ConfiguracionProovedorCfd entity);

	ConfiguracionProovedorCfd findByPK(Object id);

	List<ConfiguracionProovedorCfd> findAllLike(ConfiguracionProovedorCfd entity);

	List<ConfiguracionProovedorCfd> findAll();

	List<ConfiguracionProovedorCfd> findRange(int[] range);

	Long count();

	Long countAll();

}
