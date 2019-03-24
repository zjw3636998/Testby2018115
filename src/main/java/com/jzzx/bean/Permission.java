package com.jzzx.bean;
/**
 * 权限类
 * */
public class Permission {
	private int per_id;//权限ID
	private int per_parent_id;//权限父ID
	private String per_name;//权限名称
	private String per_url;//对应路径
	private String per_img;//对应图片
	private String per_descrpt;//权限描述
	
	public Permission() {
		super();
	}
	
	public Permission(int per_id, int per_parent_id, String per_name, String per_url, String per_img,
			String per_descrpt) {
		super();
		this.per_id = per_id;
		this.per_parent_id = per_parent_id;
		this.per_name = per_name;
		this.per_url = per_url;
		this.per_img = per_img;
		this.per_descrpt = per_descrpt;
	}

	public int getPer_id() {
		return per_id;
	}
	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}
	public int getPer_parent_id() {
		return per_parent_id;
	}
	public void setPer_parent_id(int per_parent_id) {
		this.per_parent_id = per_parent_id;
	}
	public String getPer_name() {
		return per_name;
	}
	public void setPer_name(String per_name) {
		this.per_name = per_name;
	}
	public String getPer_url() {
		return per_url;
	}
	public void setPer_url(String per_url) {
		this.per_url = per_url;
	}
	public String getPer_descrpt() {
		return per_descrpt;
	}
	public void setPer_descrpt(String per_descrpt) {
		this.per_descrpt = per_descrpt;
	}

	public String getPer_img() {
		return per_img;
	}
	public void setPer_img(String per_img) {
		this.per_img = per_img;
	}
	@Override
	public String toString() {
		return "Permission [per_id=" + per_id + ", per_parent_id=" + per_parent_id + ", per_name=" + per_name
				+ ", per_url=" + per_url + ", per_descrpt=" + per_descrpt + "]";
	}
	
	
}
