/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class Emp implements Serializable{

	private static final long serialVersionUID = 1379054685998909158L;
	
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private Date hireDate;
	private double sal;
	private double comm;
	private int deptNo;
	/**
	 * @return 返回 empNo。
	 */
	public int getEmpNo() {
		return empNo;
	}
	/**
	 * @param empNo 设置 empNo。
	 */
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	/**
	 * @return 返回 eName。
	 */
	public String geteName() {
		return eName;
	}
	/**
	 * @param eName 设置 eName。
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}
	/**
	 * @return 返回 job。
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job 设置 job。
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * @return 返回 mgr。
	 */
	public int getMgr() {
		return mgr;
	}
	/**
	 * @param mgr 设置 mgr。
	 */
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	/**
	 * @return 返回 hireDate。
	 */
	public Date getHireDate() {
		return hireDate;
	}
	/**
	 * @param hireDate 设置 hireDate。
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	/**
	 * @return 返回 sal。
	 */
	public double getSal() {
		return sal;
	}
	/**
	 * @param sal 设置 sal。
	 */
	public void setSal(double sal) {
		this.sal = sal;
	}
	/**
	 * @return 返回 comm。
	 */
	public double getComm() {
		return comm;
	}
	/**
	 * @param comm 设置 comm。
	 */
	public void setComm(double comm) {
		this.comm = comm;
	}
	/**
	 * @return 返回 deptNo。
	 */
	public int getDeptNo() {
		return deptNo;
	}
	/**
	 * @param deptNo 设置 deptNo。
	 */
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
}
