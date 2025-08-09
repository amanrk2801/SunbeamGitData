package org.example.domain;

import java.sql.Date;
import java.util.Objects;

public class Employee{
	private int empId;
	private String name;
	private String jobName;
	private int managerId;
	private Date hireDate;
	private float salary;
	private float commission;
	private int deptId;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee( int empid ) {
		this.empId = empid;
	}
	public Employee(int empId, String name, String jobName, int managerId, Date hireDate, float salary,
			float commission, int deptId) {
		this.empId = empId;
		this.name = name;
		this.jobName = jobName;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commission = commission;
		this.deptId = deptId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getCommission() {
		return commission;
	}
	public void setCommission(float commission) {
		this.commission = commission;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId;
	}
	@Override
	public String toString() {
		return String.format("%-10d%-15s%-15s%-10d%-15s%-10.2f%-8.2f%-6d", this.empId, this.name, this.jobName, this.managerId, this.hireDate, this.salary, this.commission, this.deptId);
	}
}
