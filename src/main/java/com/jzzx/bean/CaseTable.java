package com.jzzx.bean;
/**
 * 案例表
 */
public class CaseTable {
	private int case_id;		//案例ID
	private String case_title;	//案例题目
	private int case_type;		//案例所属行业
	private String case_descript;	//案例背景
	private String case_question;	//问题描述
	private String case_answer;		//问题聚焦
	private String case_result;		//取得效果
	private String case_author;		//作者
	private String case_createTime;	//发表时间
	private int case_reader;    //阅读量
	private int case_state;		//状态
	
	public CaseTable() {
		super();
	}
	public CaseTable(int case_id, String case_title, int case_type, String case_descript, String case_question,
			String case_answer,String case_result, String case_author, String case_createTime, int case_reader, int case_state) {
		super();
		this.case_id = case_id;
		this.case_title = case_title;
		this.case_type = case_type;
		this.case_descript = case_descript;
		this.case_question = case_question;
		this.case_answer = case_answer;
		this.case_result=case_result;
		this.case_author = case_author;
		this.case_createTime = case_createTime;
		this.case_reader = case_reader;
		this.case_state = case_state;
	}
	public CaseTable(String case_title, int case_type, String case_descript, String case_question, String case_answer,
			String case_result,String case_author, String case_createTime, int case_reader, int case_state) {
		super();
		this.case_title = case_title;
		this.case_type = case_type;
		this.case_descript = case_descript;
		this.case_question = case_question;
		this.case_answer = case_answer;
		this.case_result=case_result;
		this.case_author = case_author;
		this.case_createTime = case_createTime;
		this.case_reader = case_reader;
		this.case_state = case_state;
	}
	public CaseTable(int case_id, String case_title, int case_type, String case_author, String case_createTime,
			int case_reader) {
		super();
		this.case_id = case_id;
		this.case_title = case_title;
		this.case_type = case_type;
		this.case_author = case_author;
		this.case_createTime = case_createTime;
		this.case_reader = case_reader;
	}
	public int getCase_id() {
		return case_id;
	}

	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}

	public String getCase_title() {
		return case_title;
	}

	public void setCase_title(String case_title) {
		this.case_title = case_title;
	}

	public int getCase_type() {
		return case_type;
	}

	public void setCase_type(int case_type) {
		this.case_type = case_type;
	}

	public String getCase_descript() {
		return case_descript;
	}

	public void setCase_descript(String case_descript) {
		this.case_descript = case_descript;
	}

	public String getCase_question() {
		return case_question;
	}

	public void setCase_question(String case_question) {
		this.case_question = case_question;
	}

	public String getCase_answer() {
		return case_answer;
	}

	public void setCase_answer(String case_answer) {
		this.case_answer = case_answer;
	}

	public String getCase_result() {
		return case_result;
	}

	public void setCase_result(String case_result) {
		this.case_result = case_result;
	}
	public String getCase_author() {
		return case_author;
	}

	public void setCase_author(String case_author) {
		this.case_author = case_author;
	}

	public String getCase_createTime() {
		return case_createTime;
	}

	public void setCase_createTime(String case_createTime) {
		this.case_createTime = case_createTime;
	}

	public int getCase_reader() {
		return case_reader;
	}

	public void setCase_reader(int case_reader) {
		this.case_reader = case_reader;
	}

	public int getCase_state() {
		return case_state;
	}

	public void setCase_state(int case_state) {
		this.case_state = case_state;
	}
	@Override
	public String toString() {
		return "CaseTable [case_id=" + case_id + ", case_title=" + case_title + ", case_type=" + case_type
				+ ", case_descript=" + case_descript + ", case_question=" + case_question + ", case_answer="
				+ case_answer + ", case_result=" + case_result + ", case_author=" + case_author + ", case_createTime="
				+ case_createTime + ", case_reader=" + case_reader + ", case_state=" + case_state + "]";
	}
}
