package com.shetuan.util;
/**
 * 数据库查询时分页信息
 * @author Administrator
 */
public class Page {
	private int itemCont;//数据总数
	private int pageCont;//页面总数
	private int pageCurrent;//当前页
	private int pageSize;//每页的大小
	private int itemStart;//开始索引数


	public Page(){
		pageCurrent=1;
		pageSize=10;
	}

	public int getItemCont() {
		return itemCont;
	}
	public void setItemCont(int itmCont) {
		this.itemCont = itmCont;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getItemStart() {
		return (pageCurrent-1)*pageSize;
	}
	//计算总的页数
	public int getPageCont() {
		return itemCont % pageSize == 0 ? itemCont / pageSize:(itemCont / pageSize +1);
	}
	
}
