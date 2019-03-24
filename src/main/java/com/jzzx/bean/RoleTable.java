package com.jzzx.bean;
/**
 * 角色职位表
 * */
public class RoleTable {
	private int role_id;
	private String role_name;
	private String role_descript;
	private String role_createtime;
	public RoleTable() {
		super();
	}
	public RoleTable(int role_id, String role_name, String role_descript, String role_createtime) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_descript = role_descript;
		this.role_createtime = role_createtime;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_descript() {
		return role_descript;
	}
	public void setRole_descript(String role_descript) {
		this.role_descript = role_descript;
	}
	public String getRole_createtime() {
		return role_createtime;
	}
	public void setRole_createtime(String role_createtime) {
		this.role_createtime = role_createtime;
	}
	@Override
	public String toString() {
		return "RoleTable [role_id=" + role_id + ", role_name=" + role_name + ", role_descript=" + role_descript
				+ ", role_createtime=" + role_createtime + "]";
	}
	
}
