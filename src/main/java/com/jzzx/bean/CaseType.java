package com.jzzx.bean;
/**
 * 案例类型
 * */
public class CaseType {
	private int caseType_id;
	private String caseType_name;
	private String caseType_img;
	private String keyword;
	
	public CaseType() {
		super();
	}
	
	public CaseType(int caseType_id, String caseType_name, String keyword) {
		super();
		this.caseType_id = caseType_id;
		this.caseType_name = caseType_name;
		this.keyword = keyword;
	}

	public CaseType(int caseType_id, String caseType_name, String caseType_img, String keyword) {
		super();
		this.caseType_id = caseType_id;
		this.caseType_name = caseType_name;
		this.caseType_img = caseType_img;
		this.keyword = keyword;
	}

	public int getCaseType_id() {
		return caseType_id;
	}
	public void setCaseType_id(int caseType_id) {
		this.caseType_id = caseType_id;
	}
	public String getCaseType_name() {
		return caseType_name;
	}
	public void setCaseType_name(String caseType_name) {
		this.caseType_name = caseType_name;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCaseType_img() {
		return caseType_img;
	}
	public void setCaseType_img(String caseType_img) {
		this.caseType_img = caseType_img;
	}
	
}
