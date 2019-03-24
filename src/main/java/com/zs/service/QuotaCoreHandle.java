package com.zs.service;

import com.zs.entity.QuotaCoreData;

/**
 *
 * 这里是处理具体指标的接口文件
 * 返回的是一个指标12个月的数据
 * @author it023
 *
 */
public interface QuotaCoreHandle {
	
	
	/**
	 * 计算人均维护量
	 * 张顺
	 */
	public int reckonRJWH(String dId);
	
	/**
	 * 计算账号维护及时率
	 * 张顺
	 * @return 一个指标12个月的数据（以下不再赘述）
	 */
	public int reckonZHWH(String dId);
	
	/**
	 * 计算故障维护及时率
	 * 张顺
	 * @return 一个指标12个月的数据（以下不再赘述）
	 */
	public int reckonGZWH(String dId);
	
	/**
	 * 计算人均操作设备维护量
	 * 张顺
	 * @return 一个指标12个月的数据（以下不再赘述）
	 */
	public int reckonRJCZ(String dId);
	
	/**
	 * 计算巴枪平均维修时效
	 * 张顺
	 * @return 一个指标12个月的数据（以下不再赘述）
	 */
	public int reckonBQPJ(String dId);
	
	/**
	 * 计算设备巡检
	 * 张顺
	 * @return 一个指标12个月的数据（以下不再赘述）
	 */
	public int reckonSBXJ(String dId);
	
	/**
	 * 计算核心应用系统的故障趋势
	 * 张顺
	 * @return 一个指标12个月的数据（以下不再赘述）
	 */
	public int reckonHXYY(String dId);
	
}
