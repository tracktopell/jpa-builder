package com.pmarlen.l30.backend.ejb;

import com.pmarlen.l30.helper.DataSortedModel;
import com.pmarlen.l30.helper.SortField;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	public List<T> findAllOrderBy(String field) {
		CriteriaBuilder   criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery     criteriaQuery   = criteriaBuilder.createQuery();
		Root<T>           from            = criteriaQuery.from(entityClass);
		CriteriaQuery<T> selectOrderBy = criteriaQuery.select(from).orderBy(criteriaBuilder.asc(from.get(field)));
		TypedQuery<T> typedQuery1 = getEntityManager().createQuery(selectOrderBy);
		List<T> resultlist1= typedQuery1.getResultList();
		
		return resultlist1;
	}
	
	@TransactionAttribute(SUPPORTS)
	public List<T> findAllOrder(DataSortedModel<T> dsm) {
		System.err.println("-->>>"+getClass().getName()+".findAllOrder("+dsm+")");
		
		StringBuilder sb=new StringBuilder("select x from ");
		sb.append(entityClass.getSimpleName()).append(" x ");
		
		final Map<String, Object> filters = dsm.getFilters();
		
		if(!filters.isEmpty()){			
			sb.append(" where ( 1=1 ");
			int nc=1;
			for(String k:filters.keySet()){
				Object v=filters.get(k);
				System.err.println("-->> where "+k+"="+v);
				
				sb.append(" and x.").append(k);
				
				if(v instanceof String){
					System.err.println("\tstring");
					sb.append(" like :").append(k);
				} else {
					System.err.println("\tstring");
					sb.append(" = :").append(k);
				}
				nc++;
			}
			sb.append(" ) ");
		}
		
		final List<SortField> sortFieldsList = dsm.getSortFieldsList();
		
		if(!sortFieldsList.isEmpty()) {
			sb.append(" order by  ");
			int nc=1;
			for(SortField sf: sortFieldsList){			
				if(nc>1){
					sb.append(",");
				}
				if(sf.getSortOrder() == SortField.SORT_ASC){
					sb.append(sf.getFieldName()).append(" asc");
				} else if(sf.getSortOrder() == SortField.SORT_DES){
					sb.append(sf.getFieldName()).append(" desc");
				}
				nc++;
			}
		}
		
		final String jpaQuery = sb.toString();		
		System.err.println("--->>jpaQuery="+jpaQuery);				
		TypedQuery<T> query = getEntityManager().createQuery(jpaQuery,entityClass);

		if(!filters.isEmpty()){			
			System.err.println("--->>Injecting values:="+jpaQuery);
			sb.append(" where ( 1=1 ");
			int nc=1;
			for(String k:filters.keySet()){
				Object v=filters.get(k);
				System.err.println("-->> where "+k+"="+v);
				
				sb.append(" and x.").append(k);
				
				if(v instanceof String){
					System.err.println("\tstring");
					sb.append(" like :").append(k);
					query.setParameter(k, "%"+v+"%");
				} else {
					System.err.println("\tstring");
					query.setParameter(k, v);
				}
				nc++;
			}
			sb.append(" ) ");
		}
		
		List<T> resultlist1 = query.getResultList();
		dsm.setResultList(resultlist1);
		return resultlist1;
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
