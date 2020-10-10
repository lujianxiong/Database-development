package com.daxiong.jdbc.entity;

import java.util.Date;

//实体类
//封装JavaBean （私有属性  无参构造 构造重载 get、set）
//在企业级开发中，JavaBean中只需要写私有属性就可以了，构造方法、get、set方法由框架、插件生成  【loombok插件】

public class Emp {
	private int empno;//员工编号
    private String ename;
    private String job;
    private int mgr;//领导
    private Date hiredate;//入职时间
    private double sal;//薪资
    private double comm;//奖金
    private int depno;//部门编号
	
    
	public Emp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int depno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.depno = depno;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDepno() {
		return depno;
	}
	public void setDepno(int depno) {
		this.depno = depno;
	}
	public Emp() {
		super();
	}
	public Emp(int empno, String ename, String job, double sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return empno+"\t"+ename+"\t"+job+"\t"+sal;   //注意这个转义字符
	}
	
}
