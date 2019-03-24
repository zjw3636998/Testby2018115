package com.jzzx.bean;
/**
 * 会议类型表
 * */
public class MeetingType {
	
	private int mt_id;
 	private String mt_name;
	private String mt_ps;
	
	public MeetingType() {
		super();
	}
	public MeetingType(int mt_id, String mt_name, String mt_ps) {
		super();
		this.mt_id = mt_id;
		this.mt_name = mt_name;
		this.mt_ps = mt_ps;
	}
	public int getMt_id() {
		return mt_id;
	}
	public void setMt_id(int mt_id) {
		this.mt_id = mt_id;
	}
	public String getMt_name() {
		return mt_name;
	}
	public void setMt_name(String mt_name) {
		this.mt_name = mt_name;
	}
	public String getMt_ps() {
		return mt_ps;
	}
	public void setMt_ps(String mt_ps) {
		this.mt_ps = mt_ps;
	}
	@Override
	public String toString() {
		return "MeetingType [mt_id=" + mt_id + ", mt_name=" + mt_name + ", mt_ps=" + mt_ps + "]";
	}
}
