/**
 * 
 */
package com.sb.test.common.models;

import java.util.List;

/**
 * @author Venkatesh_Urlana
 *
 */
public class PaginationResult<T> {
	
	private List<T> data;
	private long totalSize;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}
	public PaginationResult(List<T> data, long totalSize) {
		super();
		this.data = data;
		this.totalSize = totalSize;
	}
	
	
}
