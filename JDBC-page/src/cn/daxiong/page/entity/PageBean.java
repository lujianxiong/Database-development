package cn.daxiong.page.entity;

import java.util.List;

public class PageBean<T> {
	private int pc;  //当前页码page code
//	private int tp;  //总页数total page  【这个数据应该由计算而来，不能随意设置】
	private int tr;  //总记录数total record
	private int ps;  //每页记录数page size
	private List<T> beanList;  //当前页的记录
	
	public int getPc() {
		return pc;
	}
	
	public void setPc(int pc) {
		this.pc = pc;
	}
	
	//我们自己计算总页数
	//通过总记录数和每页记录数来计算总页数
	public int getTp() {
		int tp = tr / ps;  //这里我们要考虑余数的问题
		return tr%ps == 0?tp:tp+1;  
	}
	
//	public void setTp(int tp) {
//		this.tp = tp;
//	}
	
	public int getTr() {
		return tr;
	}
	
	public void setTr(int tr) {
		this.tr = tr;
	}
	
	public int getPs() {
		return ps;
	}
	
	public void setPs(int ps) {
		this.ps = ps;
	}
	
	public List<T> getBeanList() {
		return beanList;
	}
	
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
}
