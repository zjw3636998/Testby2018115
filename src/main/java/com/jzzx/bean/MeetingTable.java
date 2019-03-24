package com.jzzx.bean;
/**
 * 会议记录表
 * */
public class MeetingTable {
	private int m_id;
	private int m_type;     //会议类型
	private String m_title;		//主题
	private String m_content;	//会议内容
	private String m_begin;		//开始时间
	private String m_end;		//结束时间
	private String m_recorder;	//记录人
	private String m_createtime;//创建时间
	
	public MeetingTable() {
		super();
	}
	
	public MeetingTable(int m_type, String m_title, String m_content, String m_begin, String m_end,
			String m_recorder, String m_createtime) {
		super();
		this.m_type = m_type;
		this.m_title = m_title;
		this.m_content = m_content;
		this.m_begin = m_begin;
		this.m_end = m_end;
		this.m_recorder = m_recorder;
		this.m_createtime = m_createtime;
	}

	public MeetingTable(int m_id, int m_type, String m_title, String m_content, String m_begin, String m_end,
			String m_recorder, String m_createtime) {
		super();
		this.m_id = m_id;
		this.m_type = m_type;
		this.m_title = m_title;
		this.m_content = m_content;
		this.m_begin = m_begin;
		this.m_end = m_end;
		this.m_recorder = m_recorder;
		this.m_createtime = m_createtime;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getM_type() {
		return m_type;
	}
	public void setM_type(int m_type) {
		this.m_type = m_type;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public String getM_begin() {
		return m_begin;
	}
	public void setM_begin(String m_begin) {
		this.m_begin = m_begin;
	}
	public String getM_end() {
		return m_end;
	}
	public void setM_end(String m_end) {
		this.m_end = m_end;
	}
	public String getM_recorder() {
		return m_recorder;
	}
	public void setM_recorder(String m_recorder) {
		this.m_recorder = m_recorder;
	}
	public String getM_createtime() {
		return m_createtime;
	}
	public void setM_createtime(String m_createtime) {
		this.m_createtime = m_createtime;
	}
	
}
