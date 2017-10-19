package com.pmarlen.l30.backend.local;

import com.pmarlen.l30.backend.entity.Cliente;
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
public interface ClienteFacadeLocal {

	Cliente create(Cliente entity);

	Cliente edit(Cliente entity);

	void remove(Cliente entity);

	Cliente findByPK(Object id);

	List<Cliente> findAllLike(Cliente entity);

	List<Cliente> findAll();

	List<Cliente> findRange(int[] range);

	Long count();

	Long countAll();

}
