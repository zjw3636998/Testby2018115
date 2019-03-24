package com.jzzx.bean;
/**
 * 线上订单表
 * */
public class OrderTable {
	private int order_id;//订单ID
	private int order_type;//订单类型
	private String order_content;//订单内容
	private String openid;//openid
	private String out_trade_no;//订单单号
	private String order_createtime;//下单时间
	private int order_pay;//支付金额
	private int order_state;//订单状态
	private String order_deal;//订单负责人
	private String order_ps;
	public OrderTable() {
		super();
	}
	public OrderTable(int order_id, int order_type, String order_content, String openid, String out_trade_no,
			String order_createtime, int order_pay, int order_state, String order_deal, String order_ps) {
		super();
		this.order_id = order_id;
		this.order_type = order_type;
		this.order_content = order_content;
		this.openid = openid;
		this.out_trade_no = out_trade_no;
		this.order_createtime = order_createtime;
		this.order_pay = order_pay;
		this.order_state = order_state;
		this.order_deal = order_deal;
		this.order_ps = order_ps;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOrder_type() {
		return order_type;
	}
	public void setOrder_type(int order_type) {
		this.order_type = order_type;
	}
	public String getOrder_content() {
		return order_content;
	}
	public void setOrder_content(String order_content) {
		this.order_content = order_content;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getOrder_createtime() {
		return order_createtime;
	}
	public void setOrder_createtime(String order_createtime) {
		this.order_createtime = order_createtime;
	}
	public int getOrder_pay() {
		return order_pay;
	}
	public void setOrder_pay(int order_pay) {
		this.order_pay = order_pay;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public String getOrder_deal() {
		return order_deal;
	}
	public void setOrder_deal(String order_deal) {
		this.order_deal = order_deal;
	}
	
	public String getOrder_ps() {
		return order_ps;
	}
	public void setOrder_ps(String order_ps) {
		this.order_ps = order_ps;
	}

	@Override
	public String toString() {
		return "OrderTable [order_id=" + order_id + ", order_type=" + order_type + ", order_content=" + order_content
				+ ", openid=" + openid + ", out_trade_no=" + out_trade_no + ", order_createtime=" + order_createtime
				+ ", order_pay=" + order_pay + ", order_state=" + order_state + ", order_deal=" + order_deal
				+ ", order_dealtime=" + order_ps + "]";
	}
}
