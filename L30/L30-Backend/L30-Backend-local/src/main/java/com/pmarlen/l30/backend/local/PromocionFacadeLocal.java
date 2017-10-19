package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.Promocion;
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
public interface PromocionFacadeLocal {

	Promocion create(Promocion entity);

	Promocion edit(Promocion entity);

	void remove(Promocion entity);

	Promocion findByPK(Object id);

	List<Promocion> findAllLike(Promocion entity);

	List<Promocion> findAll();

	List<Promocion> findRange(int[] range);

	Long count();

	Long countAll();

}
