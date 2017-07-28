package com.pmarlen.l30.backend.remote;

import com.pmarlen.l30.backend.entity.Cliente;
import java.util.List;
import javax.ejb.Remote;

/**
 * JPA Entity @Remote Facade Interface.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */
@Remote
public interface ClienteFacadeRemote {

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
