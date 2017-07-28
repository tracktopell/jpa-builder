package com.pmarlen.l30.backend.remote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.SUPPORTS;

/**
 * ESB JPA Entity AbstractFacade.
 * 
 * @author Tracktopell::jpa-builder @see  https://github.com/tracktopell/jpa-builder
 * @version 1.12.8
 * @date 2017/07/27 19:58
 */

public abstract class AbstractFacade<T> {

	private Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	@TransactionAttribute(REQUIRED)
	public T create(T entity) {
		getEntityManager().persist(entity);
		getEntityManager().flush();
		return entity;
	}

	@TransactionAttribute(REQUIRED)
	public T edit(T entity) {
		getEntityManager().merge(entity);
		getEntityManager().flush();
		return entity;
	}

	@TransactionAttribute(REQUIRED)
	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
		getEntityManager().flush();
	}

	@TransactionAttribute(SUPPORTS)
	public T findByPK(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	@TransactionAttribute(SUPPORTS)
	public abstract List<T> findAllLike(T entity);

	@TransactionAttribute(SUPPORTS)
	public abstract List<T> findAll();

	@TransactionAttribute(SUPPORTS)
	public List<T> findRange(int[] range) {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}
	
	@TransactionAttribute(SUPPORTS)
	public Long count() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return (Long) q.getSingleResult();
	}

	@TransactionAttribute(SUPPORTS)
	public abstract Long countAll();

}
