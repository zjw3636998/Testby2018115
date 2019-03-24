package com.zs.entity.other;

import java.util.Map;

/**
 * 用于接收easyui数据表格的所有参数的封装
 * @author it023
 */
public class EasyUIAccept<T> {
	//Integer year,String sort,String order,Integer page,Integer rows
	private String sort;//要排序的列名
	private String order;//正序还是倒叙
	private Integer page;//当前页码
	private Integer rows;//每页数量
	private T obj;//条件查询的参数封装，即实体类
	private Map<String, ?> opt;//其他条件查询的参数，当obj不够用的情况下使用
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	public Map<String, ?> getOpt() {
		return opt;
	}
	public void setOpt(Map<String, ?> opt) {
		this.opt = opt;
	}
	@Override
	public String toString() {
		return "EasyUIAccept [sort=" + sort + ", order=" + order + ", page=" + page + ", rows=" + rows + ", obj=" + obj
				+ ", opt=" + opt + "]";
	}
	
}
