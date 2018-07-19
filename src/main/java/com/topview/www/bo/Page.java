package com.topview.www.bo;

import java.util.List;

/**
 * 用于分页的类
 * @author Pan梓涵
 */
public class Page<T>{
	
	private int pageSize;//每页显示多少条记录
	private int currentPage;//当前第几页数据
	private int totalRecord;//一共多少条记录
	private List<T> list;//当前页记录
	
	public Page() {
		
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getTotalPages() {
	        /*
	         * 计算总页数
	         * 通过总记录数和每页记录数来计算总页数，当存在余数时，总页数 + 1
	         */
	        int totalPages = totalRecord / pageSize;
	        return totalRecord % pageSize == 0 ? totalPages : totalPages + 1;
	 }
	
	 public int getTotalRecord() {
	        return totalRecord;
	 }
	 
	 public void setTotalRecord(int totalRecord) {
	        this.totalRecord = totalRecord;
	 }

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	 
}
