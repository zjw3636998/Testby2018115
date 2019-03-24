package com.jzzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jzzx.bean.OfflinePay;
import com.jzzx.bean.OrderTable;
import com.jzzx.bean.SuggestionTable;
import com.jzzx.bean.WeChatUser;

public interface WechatUserDao {

	int weChatCount(@Param("searchType")String searchType, @Param("searchContent")String searchContent);
	
	List<WeChatUser> getPageWeChatUser(@Param("fromIndex")int fromIndex, @Param("pageSize")int pageSize, @Param("searchType")String searchType,
			@Param("searchContent")String searchContent);

	void addWechatPs(@Param("wId")int wId, @Param("psContent")String psContent);

	int selectSuggestion(@Param("openid")String openid);

	List<SuggestionTable> getPageSuggestion(@Param("fromIndex")int fromIndex, @Param("pageSize")int pageSize, @Param("openid")String openid);

	void delSuggestion(@Param("st_id")int st_id);
	/* test */
	List<WeChatUser> getWechatUser(@Param("searchContent")String searchContent,@Param("searchType")String searchType);
	/*一元咨询 */
	List<OrderTable> getPageYyzx(@Param("fromIndex")int fromIndex,@Param("pageSize")int pageSize,@Param("searchType")String searchType,
			@Param("searchContent")String searchContent,@Param("orderType")int orderType);
	int YyzxCount(@Param("searchType")String searchType,@Param("searchContent")String searchContent, @Param("orderType")int orderType);

	void updConsult(@Param("empName")String empName, @Param("c_id")int c_id);
	/* 线下咨询 */
	int XxzxCount(@Param("searchType")String searchType,@Param("searchContent")String searchContent);
	List<OfflinePay> getPageXxzx(@Param("fromIndex")int fromIndex,@Param("pageSize")int pageSize,@Param("searchType")String searchType,
			@Param("searchContent")String searchContent);

	void updXxzx(@Param("empName")String empName, @Param("c_id")int c_id);
	
}
