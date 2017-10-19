package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.ConfiguracionProovedorCfd;
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
public interface ConfiguracionProovedorCfdFacadeLocal {

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
