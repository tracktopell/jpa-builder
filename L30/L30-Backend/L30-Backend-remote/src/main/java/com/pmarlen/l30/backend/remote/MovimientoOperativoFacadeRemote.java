package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.MovimientoOperativo;
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
public interface MovimientoOperativoFacadeRemote {

	MovimientoOperativo create(MovimientoOperativo entity);

	MovimientoOperativo edit(MovimientoOperativo entity);

	void remove(MovimientoOperativo entity);

	MovimientoOperativo findByPK(Object id);

	List<MovimientoOperativo> findAllLike(MovimientoOperativo entity);

	List<MovimientoOperativo> findAll();

	List<MovimientoOperativo> findRange(int[] range);

	Long count();

	Long countAll();

}
