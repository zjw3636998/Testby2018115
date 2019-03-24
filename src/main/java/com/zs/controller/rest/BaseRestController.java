package com.zs.controller.rest;

import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;

public interface BaseRestController<T> {
	
	/**
	 * 分页方法 
	 * @param accept
	 * @return
	 */
	public EasyUIPage query(EasyUIAccept<T> accept);
	
	/**
	 * 通过id查询一个对象的方法
	 * @return
	 */
	public Result<T> get(String id);
	
	/**
	 * 添加一个对象的方法
	 * @return
	 */
	public Result<Integer> post(T obj);
	
	/**
	 * 修改一个对象的方法,需要传一个对象的完整信息
	 * @return
	 */
	public Result<Integer> put(T obj);
	
	/**
	 * 通过id删除一个对象的方法
	 * @return
	 */
	public Result<Integer> delete(String id);
	
	
}
