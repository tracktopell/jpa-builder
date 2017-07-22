package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.Promocion;
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
public interface PromocionFacadeRemote {

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
