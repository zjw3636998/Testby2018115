package com.jzzx.bean;
/**
 * 线下咨询(系统及深度咨询)
 * */
public class OfflinePay {
	private int op_id; 
	private String op_name;	
	private String op_phone;
	private int op_type;	//类型  1为系统咨询 2位为深度咨询
	private String op_createtime;
	private int op_dealState;
	private String op_deal;	
	private String op_dealtime;
	private String op_resp;
	private String op_ps;
	
	public OfflinePay() {
		super();
	}
	

	public OfflinePay(int op_id, String op_name, String op_phone, int op_type, String op_createtime,
			int op_dealState, String op_deal, String op_dealtime, String op_resp, String op_ps) {
		super();
		this.op_id = op_id;
		this.op_name = op_name;
		this.op_phone = op_phone;
		this.op_type = op_type;
		this.op_createtime = op_createtime;
		this.op_dealState = op_dealState;
		this.op_deal = op_deal;
		this.op_dealtime = op_dealtime;
		this.op_resp = op_resp;
		this.op_ps = op_ps;
	}


	public int getOp_id() {
		return op_id;
	}

	public void setOp_id(int op_id) {
		this.op_id = op_id;
	}

	public String getOp_name() {
		return op_name;
	}

	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}

	public String getOp_phone() {
		return op_phone;
	}

	public void setOp_phone(String op_phone) {
		this.op_phone = op_phone;
	}

	public int getOp_type() {
		return op_type;
	}

	public void setOp_type(int op_type) {
		this.op_type = op_type;
	}

	public String getOp_createtime() {
		return op_createtime;
	}

	public void setOp_createtime(String op_createtime) {
		this.op_createtime = op_createtime;
	}

	public String getOp_deal() {
		return op_deal;
	}

	public void setOp_deal(String op_deal) {
		this.op_deal = op_deal;
	}

	public String getOp_dealtime() {
		return op_dealtime;
	}

	public void setOp_dealtime(String op_dealtime) {
		this.op_dealtime = op_dealtime;
	}

	public String getOp_resp() {
		return op_resp;
	}

	public void setOp_resp(String op_resp) {
		this.op_resp = op_resp;
	}

	public String getOp_ps() {
		return op_ps;
	}

	public void setOp_ps(String op_ps) {
		this.op_ps = op_ps;
	}
	public int getOp_dealState() {
		return op_dealState;
	}
	public void setOp_dealState(int op_dealState) {
		this.op_dealState = op_dealState;
	}
	@Override
	public String toString() {
		return "OfflinePay [op_id=" + op_id + ", op_name=" + op_name + ", op_phone=" + op_phone + ", op_type=" + op_type
				+ ", op_createtime=" + op_createtime + ", op_dealState=" + op_dealState + ", op_deal=" + op_deal
				+ ", op_dealtime=" + op_dealtime + ", op_resp=" + op_resp + ", op_ps=" + op_ps + "]";
	}
	
	
}
