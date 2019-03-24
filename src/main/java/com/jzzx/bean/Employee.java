package com.jzzx.bean;

public class Employee {
	private int emp_id;//员工ID
	private int user_id;//账号ID
	private String empName;//员工名称
	private String entry_time;//入职时间
	private String regular_time;//转正时间
	private String department;//所属部门
	private String education;//学历
	private int level;	//职级
	private String dimission;//离职时间
	private String upd_emp;//最后修改人
	private String upd_time;//修改时间
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(String entry_time) {
		this.entry_time = entry_time;
	}
	public String getRegular_time() {
		return regular_time;
	}
	public void setRegular_time(String regular_time) {
		this.regular_time = regular_time;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getDimission() {
		return dimission;
	}
	public void setDimission(String dimission) {
		this.dimission = dimission;
	}
	public String getUpd_emp() {
		return upd_emp;
	}
	public void setUpd_emp(String upd_emp) {
		this.upd_emp = upd_emp;
	}
	public String getUpd_time() {
		return upd_time;
	}
	public void setUpd_time(String upd_time) {
		this.upd_time = upd_time;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", user_id=" + user_id + ", empName=" + empName + ", entry_time="
				+ entry_time + ", regular_time=" + regular_time + ", department=" + department + ", education="
				+ education + ", level=" + level + ", dimission=" + dimission + ", upd_emp=" + upd_emp + ", upd_time="
				+ upd_time + "]";
	}
	
	
}
