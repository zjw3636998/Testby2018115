package com.jzzx.bean;
/**
 * 微信公众号意见反馈表
 * */
public class SuggestionTable {
	private int st_id;
	private String st_content;
	private String st_openid;
	private String st_time;
	
	public SuggestionTable() {
		super();
	}
	public SuggestionTable(int st_id, String st_content, String st_openid, String st_time) {
		super();
		this.st_id = st_id;
		this.st_content = st_content;
		this.st_openid = st_openid;
		this.st_time = st_time;
	}
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public String getSt_content() {
		return st_content;
	}
	public void setSt_content(String st_content) {
		this.st_content = st_content;
	}
	public String getSt_openid() {
		return st_openid;
	}
	public void setSt_openid(String st_openid) {
		this.st_openid = st_openid;
	}
	public String getSt_time() {
		return st_time;
	}
	public void setSt_time(String st_time) {
		this.st_time = st_time;
	}
	@Override
	public String toString() {
		return "SuggestionTable [st_id=" + st_id + ", st_content=" + st_content + ", st_openid=" + st_openid
				+ ", st_time=" + st_time + "]";
	}
	
}
