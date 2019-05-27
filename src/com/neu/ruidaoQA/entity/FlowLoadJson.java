package com.neu.ruidaoQA.entity;

public class FlowLoadJson {
	private String s[];//返回每页的问题数组
	private int pages;//返回页数
	public String[] getS() {
		return s;
	}
	public void setS(String[] s) {
		this.s = s;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public FlowLoadJson(String[] s, int pages) {
		super();
		this.s = s;
		this.pages = pages;
	}
	public FlowLoadJson() {
		
	}
	
}
