package com.convert;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	private int currentPage;
	private int pagesize;
	private int totalsRecord;
	private int totalPages;
	private int start;
	private int end;
	private List<T> list = new ArrayList<>();
	
	public  Page(int totalsRecord,int pagesize){
		this.totalsRecord=totalsRecord;
		this.pagesize=pagesize;
		this.setTotalPages();
	}
	
	public  Page(){

	}
	
	
	public int getStart() {
		return this.start;
	}

	private void setStart(){
		this.start=(this.currentPage-1)*this.pagesize;
	}



	public List<T> getList() {
		List<T> copy = new  ArrayList<>();
		copy.addAll(list);
		return copy;
	}
	
	public void setList(List<T> list){
		this.list.addAll(list);
	}


	public int getEnd() {
		return end;
	}

	private void setEnd(){
		this.end=this.pagesize;
	}

	public void setEnd(int end) {
		this.end = end;
	}



	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		this.setStart();
		this.setEnd();
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalsRecord() {
		return totalsRecord;
	}

	public void setTotalsRecord(int totalsRecord) {
		this.totalsRecord = totalsRecord;
		setTotalPages();
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages() {
		this.totalPages = this.totalsRecord/this.pagesize+((this.totalsRecord%this.pagesize)==0?0:1);
	}
	
}
