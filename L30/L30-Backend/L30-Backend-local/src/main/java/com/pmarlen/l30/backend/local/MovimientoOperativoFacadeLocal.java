package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.MovimientoOperativo;
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
public interface MovimientoOperativoFacadeLocal {

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
