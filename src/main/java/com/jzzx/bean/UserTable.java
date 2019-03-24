package com.jzzx.bean;
	/**
	 * 用户表
	 * */
public class UserTable {
	private int u_id;
	private String u_account; //账号
	private String u_password;//密码
	private String u_name;//姓名
	private String u_phone;//电话
	private String u_headimg;//头像路径
	private String u_createtime; //创建时间
	private String u_newtime;//最近登陆时间
	private String u_cancel;//注销时间
	
	public UserTable() {
		super();
	}
	public UserTable(int u_id, String u_account, String u_password, String u_name, String u_phone, String u_headimg,
			String u_createtime, String u_newtime, String u_cancel) {
		super();
		this.u_id = u_id;
		this.u_account = u_account;
		this.u_password = u_password;
		this.u_name = u_name;
		this.u_phone = u_phone;
		this.u_headimg = u_headimg;
		this.u_createtime = u_createtime;
		this.u_newtime = u_newtime;
		this.u_cancel = u_cancel;
	}
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_account() {
		return u_account;
	}
	public void setU_account(String u_account) {
		this.u_account = u_account;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_headimg() {
		return u_headimg;
	}
	public void setU_headimg(String u_headimg) {
		this.u_headimg = u_headimg;
	}
	public String getU_createtime() {
		return u_createtime;
	}
	public void setU_createtime(String u_createtime) {
		this.u_createtime = u_createtime;
	}
	public String getU_newtime() {
		return u_newtime;
	}
	public void setU_newtime(String u_newtime) {
		this.u_newtime = u_newtime;
	}
	public String getU_cancel() {
		return u_cancel;
	}
	public void setU_cancel(String u_cancel) {
		this.u_cancel = u_cancel;
	}
	
}
