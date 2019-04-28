package com.tile;

public class drivercape {
	private int pageSize;
	private int totalRecord;
	private int currentPage;
	public drivercape(int pageSize, int totalRecord, int currentPage){
		this.pageSize=pageSize;
		this.totalRecord=totalRecord;
		setCurrentPage(currentPage);
	}
	
	public drivercape(int pageSize,int totalRecord){
		this(pageSize,totalRecord,1);
	}
	public int getPageCount(){
		int  pageCount=totalRecord/pageSize;
		int mod=totalRecord%pageSize;
		if(mod!=0)
			pageCount++;
		return pageCount;
	}
	public int fromIndex(){
		return (currentPage-1)*pageSize;
	}
	public int toIndex(){
		return pageSize;
	}
	private void setCurrentPage(int currentPage) {
		// TODO Auto-generated method stub
		if(getPageCount()!=0){
			int validPage=currentPage<1?1:currentPage;
			validPage=validPage>getPageCount()?getPageCount():validPage;
			this.currentPage=validPage;
		}
		else{
			this.currentPage=1;
		}
	}
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize=pageSize;
	}
	public int getTotalRecord(){
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord){
		this.totalRecord= totalRecord;
	}
	public int getCurrentPage(){
		return currentPage;
	}

}
