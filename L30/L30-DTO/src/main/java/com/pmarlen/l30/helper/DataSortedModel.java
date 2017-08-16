package com.pmarlen.l30.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alfredo
 */
public class DataSortedModel<T> implements Serializable{

	private List<T> resultList;
	private int     rowCount;
	private int     maxResults;
	private int     firstResult;
	private List<SortField>    sortFieldsList;
	private Map<String,Object> filters;

	public DataSortedModel(List<SortField> sortFieldsList, Map<String, Object> filters) {
		this.resultList = new ArrayList<T>();
		this.rowCount = 0;
		this.sortFieldsList = sortFieldsList;
		this.filters = filters;
	}

	public DataSortedModel(List<SortField> sortFieldsList, Map<String, Object> filters,int maxResults, int firstResult) {
		this.resultList = new ArrayList<T>();
		this.rowCount = 0;
		this.sortFieldsList = sortFieldsList;
		this.filters = filters;
		this.maxResults = maxResults;
		this.firstResult = firstResult;
	}

	
	
	/**
	 * @return the resultList
	 */
	public List<T> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * @return the sortFieldsList
	 */
	public List<SortField> getSortFieldsList() {
		return sortFieldsList;
	}

	/**
	 * @param sortFieldsList the sortFieldsList to set
	 */
	public void setSortFieldsList(List<SortField> sortFieldsList) {
		this.sortFieldsList = sortFieldsList;
	}

	/**
	 * @return the filters
	 */
	public Map<String,Object> getFilters() {
		return filters;
	}

	/**
	 * @param filters the filters to set
	 */
	public void setFilters(Map<String,Object> filters) {
		this.filters = filters;
	}

	/**
	 * @return the maxResults
	 */
	public int getMaxResults() {
		return maxResults;
	}

	/**
	 * @param maxResults the maxResults to set
	 */
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	/**
	 * @return the firstResult
	 */
	public int getFirstResult() {
		return firstResult;
	}

	/**
	 * @param firstResult the firstResult to set
	 */
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

}
