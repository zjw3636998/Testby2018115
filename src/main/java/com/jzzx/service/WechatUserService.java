package com.jzzx.service;

import java.util.List;

import com.jzzx.bean.OfflinePay;
import com.jzzx.bean.OrderTable;
import com.jzzx.bean.SuggestionTable;
import com.jzzx.bean.WeChatUser;

public interface WechatUserService {

	int weChatCount(String searchType, String searchContent);

	List<WeChatUser> getPageWeChatUser(int fromIndex, int pageSize, String searchType, String searchContent);

	void addWechatPs(int wId, String psContent);

	int selectSuggestion(String openid);

	List<SuggestionTable> getPageSuggestion(int fromIndex, int pageSize, String openid);

	void delSuggestion(int st_id);
	
	/*线上咨询*/
	int YyzxCount(String searchType, String searchContent, int orderType);
	List<OrderTable> getPageYyzx(int fromIndex, int pageSize, String searchType, String searchContent, int orderType);

	void updConsult(String empName, int c_id);
	/* 线下咨询 */
	int XxzxCount(String searchType, String searchContent);
	List<OfflinePay> getPageXxzx(int fromIndex, int pageSize, String searchType, String searchContent);

	void updXxzx(String empName, int c_id);

}
