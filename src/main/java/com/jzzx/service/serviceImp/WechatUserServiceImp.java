package com.jzzx.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzzx.bean.OfflinePay;
import com.jzzx.bean.OrderTable;
import com.jzzx.bean.SuggestionTable;
import com.jzzx.bean.WeChatUser;
import com.jzzx.dao.WechatUserDao;
import com.jzzx.service.WechatUserService;

@Service("WechatUserService")
public class WechatUserServiceImp implements WechatUserService {
	private WechatUserDao wechatUserDao;
	@Autowired
	public void setWechatUserDao(WechatUserDao wechatUserDao) {
		this.wechatUserDao = wechatUserDao;
	}

	@Override
	public int weChatCount(String searchType, String searchContent) {
		return wechatUserDao.weChatCount(searchType,searchContent);
	}

	@Override
	public List<WeChatUser> getPageWeChatUser(int fromIndex, int pageSize, String searchType, String searchContent) {
		return wechatUserDao.getPageWeChatUser(fromIndex,pageSize,searchType,searchContent);
	}

	@Override
	public void addWechatPs(int wId, String psContent) {
		wechatUserDao.addWechatPs(wId,psContent);
	}

	@Override
	public int selectSuggestion(String openid) {
		return wechatUserDao.selectSuggestion(openid);
	}

	@Override
	public List<SuggestionTable> getPageSuggestion(int fromIndex, int pageSize, String openid) {
		return wechatUserDao.getPageSuggestion(fromIndex,pageSize,openid);
	}

	@Override
	public void delSuggestion(int st_id) {
		wechatUserDao.delSuggestion(st_id);
	}

	@Override
	public int YyzxCount(String searchType, String searchContent, int orderType) {
		return wechatUserDao.YyzxCount(searchType,searchContent,orderType);
	}

	@Override
	public List<OrderTable> getPageYyzx(int fromIndex, int pageSize, String searchType, String searchContent,
			int orderType) {
		return wechatUserDao.getPageYyzx(fromIndex,pageSize,searchType,searchContent,orderType);
	}

	@Override
	public void updConsult(String empName, int c_id) {
		wechatUserDao.updConsult(empName,c_id);
		
	}

	@Override
	public int XxzxCount(String searchType, String searchContent) {
		return wechatUserDao.XxzxCount(searchType,searchContent);
	}

	@Override
	public List<OfflinePay> getPageXxzx(int fromIndex, int pageSize, String searchType, String searchContent) {
		return wechatUserDao.getPageXxzx(fromIndex,pageSize,searchType,searchContent);
	}

	@Override
	public void updXxzx(String empName, int c_id) {
		wechatUserDao.updXxzx(empName,c_id);
	}

}
