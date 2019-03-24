package com.jzzx.bean;
/**
'微信公众号用户管理及反馈意见管理
'*/
public class WeChatUser {
	private int id;//标识
	private String nickname;//昵称
	private int sex;//性别
	private String country;//国家
	private String province;//省份
	private String city;//城市
	private String headimgurl;//头像路径
	private String phone;//电话
	private String company;//公司
	private String logintime;//最近登陆时间
	private int level;//等级
	private String openid;//openid
	private String ps;//附加信息
	
	public WeChatUser() {
		super();
	}
	public WeChatUser(int id, String nickname, int sex, String country, String province, String city,
			String headimgurl, String phone, String company, String logintime, int level, String openid, String ps) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.headimgurl = headimgurl;
		this.phone = phone;
		this.company = company;
		this.logintime = logintime;
		this.level = level;
		this.openid = openid;
		this.ps = ps;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
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
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public int getlevel() {
		return level;
	}
	public void setLeavel(int leavel) {
		this.level = leavel;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	@Override
	public String toString() {
		return "{id=" + id + ", nickname=" + nickname + ", sex=" + sex + ", country=" + country
				+ ", province=" + province + ", city=" + city + ", headimgurl=" + headimgurl + ", phone=" + phone
				+ ", company=" + company + ", logintime=" + logintime + ", level=" + level + ", openid=" + openid
				+ ", ps=" + ps + "}";
	}
	
}
