package com.jzzx.bean;
/**
 * 浏览人
 * */
public class Visited {
	private int t_id;
	private String t_name;
	private int t_count;
	public Visited() {
		super();
	}
	public Visited(int t_id, String t_name, int t_count) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_count = t_count;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public int getT_count() {
		return t_count;
	}
	public void setT_count(int t_count) {
		this.t_count = t_count;
	}
	
}
