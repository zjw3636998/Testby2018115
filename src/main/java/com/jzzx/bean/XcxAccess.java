package com.jzzx.bean;
/**
 * 小程序不同计划访问人数
 * */
public class XcxAccess {
	private int access_id;
	private String access_name;
	private int access_time;
	private String access_remake;
	
	
	public XcxAccess() {
		super();
	}
	public XcxAccess(int access_id, String access_name, int access_time, String access_remake) {
		super();
		this.access_id = access_id;
		this.access_name = access_name;
		this.access_time = access_time;
		this.access_remake = access_remake;
	}
	public int getAccess_id() {
		return access_id;
	}
	public void setAccess_id(int access_id) {
		this.access_id = access_id;
	}
	public String getAccess_name() {
		return access_name;
	}
	public void setAccess_name(String access_name) {
		this.access_name = access_name;
	}
	public int getAccess_time() {
		return access_time;
	}
	public void setAccess_time(int access_time) {
		this.access_time = access_time;
	}
	public String getAccess_remake() {
		return access_remake;
	}
	public void setAccess_remake(String access_remake) {
		this.access_remake = access_remake;
	}
	@Override
	public String toString() {
		return "XcxAccess [access_id=" + access_id + ", access_name=" + access_name + ", access_time=" + access_time
				+ ", access_remake=" + access_remake + "]";
	}
	
}
