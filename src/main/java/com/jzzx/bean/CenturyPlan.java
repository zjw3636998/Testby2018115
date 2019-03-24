package com.jzzx.bean;
	/**
	 *百年计划类 
	 **/
public class CenturyPlan {
	
	private int id;
	private int planSource;//用户来源1为公众号2为小程序
	private String name;	
	private String phone;
	private String company;
	private String submittime;//提交时间
	private int grade;//1育鹰2雏鹰3飞鹰4雄鹰
	private String openid;//用户标识
	private String orderid;//订单号
	private int dealState;//处理状态 0为未处理，1为已处理
	private String assignEmp;//分配人
	private String assignTime;//分配时间
	private String dealEmp;//处理人
	private String remake;//备注
	
	public CenturyPlan() {
		super();
	}
	/*微信公众号*/
	public CenturyPlan(int id, int planSource, String name, String phone, String company, String submittime, int grade,int dealState,
			String assignEmp, String assignTime, String dealEmp, String remake) {
		super();
		this.id = id;
		this.planSource = planSource;
		this.name = name;
		this.phone = phone;
		this.company = company;
		this.submittime = submittime;
		this.grade = grade;
		this.dealState=dealState;
		this.assignEmp = assignEmp;
		this.assignTime = assignTime;
		this.dealEmp = dealEmp;
		this.remake = remake;
	}
	/*微信小程序*/
	public CenturyPlan(int id, int planSource, String name, String phone, String submittime, int grade, String openid,
			String orderid, int dealState,String assignEmp, String assignTime, String dealEmp, String remake) {
		super();
		this.id = id;
		this.planSource = planSource;
		this.name = name;
		this.phone = phone;
		this.submittime = submittime;
		this.grade = grade;
		this.openid = openid;
		this.orderid = orderid;
		this.dealState=dealState;
		this.assignEmp = assignEmp;
		this.assignTime = assignTime;
		this.dealEmp = dealEmp;
		this.remake = remake;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlanSource() {
		return planSource;
	}
	public void setPlanSource(int planSource) {
		this.planSource = planSource;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSubmittime() {
		return submittime;
	}
	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getAssignEmp() {
		return assignEmp;
	}
	public void setAssignEmp(String assignEmp) {
		this.assignEmp = assignEmp;
	}
	public String getAssignTime() {
		return assignTime;
	}
	public void setAssignTime(String assignTime) {
		this.assignTime = assignTime;
	}
	public String getDealEmp() {
		return dealEmp;
	}
	public void setDealEmp(String dealEmp) {
		this.dealEmp = dealEmp;
	}
	public String getRemake() {
		return remake;
	}
	public void setRemake(String remake) {
		this.remake = remake;
	}
	public int getDealState() {
		return dealState;
	}
	public void setDealState(int dealState) {
		this.dealState = dealState;
	}
	@Override
	public String toString() {
		return "CenturyPlan [id=" + id + ", planSource=" + planSource + ", name=" + name + ", phone=" + phone
				+ ", company=" + company + ", submittime=" + submittime + ", grade=" + grade + ", openid=" + openid
				+ ", orderid=" + orderid + ", dealState=" + dealState + ", assignEmp=" + assignEmp + ", assignTime="
				+ assignTime + ", dealEmp=" + dealEmp + ", remake=" + remake + "]";
	}
	
	
	
	
}
