
package com.pmarlen.l30.helper;

import java.io.Serializable;

/**
 *
 * @author alfredo
 */
public class SortField implements Serializable{

	public static final int SORT_ASC =  1;
	
	public static final int SORT_DES = -1;
	
	private int    sortOrder;
	
	private String fieldName;

	public SortField(int sortOrder, String fieldName) {
		this.sortOrder = sortOrder;
		this.fieldName = fieldName;
	}

	public SortField(String fieldName) {
		this.sortOrder = SORT_ASC;
		this.fieldName = fieldName;
	}
	
	/**
	 * @return the sortOrder
	 */
	public int getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
