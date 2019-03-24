package com.jzzx.controller;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jzzx.bean.OfflinePay;
import com.jzzx.bean.OrderTable;
import com.jzzx.bean.SuggestionTable;
import com.jzzx.bean.WeChatUser;
import com.jzzx.service.WechatUserService;
import com.jzzx.util.PageUtil;

/**
'微信公众号用户管理
'============================================================================
'api说明：
'selWechatUser 查询微信公众号用户
'addWechatRemake 添加微信公众号用户备注信息
'selSuggestion 查询意见反馈信息
'delSuggestion 删除反馈意见
'selYyzx 查询线上咨询业务
'updConsult 修改线上业务负责人
'selXxzx 查询线下咨询业务
	
'============================================================================
'*/
@Controller
public class WechatUserController {
	private WechatUserService wechatUserService; 
	@Autowired
	public void setWechatUserService(WechatUserService wechatUserService) {
		this.wechatUserService = wechatUserService;
	}
	private String time;//时间
	/**
	 * @param pageNum(String) searchContent(String) searchType(String)
	 * @return list<WeChatUser>
	 * @throws UnsupportedEncodingException 
	 * */
	@RequestMapping("/selWechatUser.do")
	public String selWechatUser(Model model,String pageNum,
			String searchContent,String searchType) throws UnsupportedEncodingException{
		int currentPage = 1;//第一页
		if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        } 
		if (searchContent != null && !"".equals(searchContent)) {  
			searchContent = java.net.URLDecoder.decode(searchContent, "utf-8"); 
        } 
		 PageUtil pageUtil = new PageUtil(10, wechatUserService.weChatCount(searchType,searchContent), currentPage);  
	     List<WeChatUser> list = wechatUserService.getPageWeChatUser(pageUtil.getFromIndex(), pageUtil.getPageSize(),searchType,searchContent); 
	     model.addAttribute("wechatList",list);
	     model.addAttribute("currentPage",currentPage);
	     model.addAttribute("totalPage",pageUtil.getPageCount());
		return "pages/gzhTable/wechatUser.jsp";
	}
	/**
	 * @param id(String) uName(String) psMessage(String)
	 * @return selWechatUser.do
	 * */
	@RequestMapping("/addWechatRemake.do")
	public String addWechatRemake(@RequestParam("")String id,@RequestParam("")String uName,@RequestParam("")String psMessage){
		int wId=Integer.parseInt(id);
		time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String psContent=time+"上传备注："+psMessage+"("+uName+")";//备注内容
		wechatUserService.addWechatPs(wId,psContent);
		return "selWechatUser.do";
	}
	/**
	 * @param 
	 * @return list<SuggestionTable>
	 **/
	@RequestMapping("/selSuggestion.do")
	public String selSuggestion(Model model,String openid,String pageNum){
		int currentPage = 1;//第一页
		if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        }
		PageUtil pageUtil = new PageUtil(10, wechatUserService.selectSuggestion(openid), currentPage);  
	    List<SuggestionTable> list = wechatUserService.getPageSuggestion(pageUtil.getFromIndex(), pageUtil.getPageSize(),openid); 
	    model.addAttribute("suggestionList",list);
	    model.addAttribute("currentPage",currentPage);
	    model.addAttribute("totalPage",pageUtil.getPageCount());
		return "pages/gzh/suggestion.jsp";
	}
	/**
	 * @param stId(String)
	 * @return "selSuggestion.do"
	 * */
	@RequestMapping("/delSuggestion.do")
	public String delSuggestion(String stId){
		if (stId != null && !"".equals(stId)){
			int st_id=Integer.parseInt(stId);
			wechatUserService.delSuggestion(st_id);
		}
		return "selSuggestion.do";
	}
	/**
	 * @param pageNum(String) searchContent(String) searchType(String) orderType(String)
	 * @return orderList<OrderTable>
	 * */
	@RequestMapping("/selYyzx.do")
	public String selYyzx(Model model,String pageNum,
			String searchContent,String searchType,String orderType) throws UnsupportedEncodingException{
		int currentPage = 1;//第一页
		if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        } 
		if (searchContent != null && !"".equals(searchContent)) {  
			searchContent = java.net.URLDecoder.decode(searchContent, "utf-8"); 
        }
		int order_Type=Integer.parseInt(orderType);//线上付费类型
		PageUtil pageUtil = new PageUtil(10, wechatUserService.YyzxCount(searchType,searchContent,order_Type), currentPage);  
	    List<OrderTable> list = wechatUserService.getPageYyzx(pageUtil.getFromIndex(), pageUtil.getPageSize(),searchType,searchContent,order_Type); 
	    model.addAttribute("orderList",list);
	    model.addAttribute("currentPage",currentPage);
	    model.addAttribute("totalPage",pageUtil.getPageCount());
	    String pageUrl="";//跳转路径
	    if(order_Type==1){
	    	pageUrl="pages/gzhTable/yyzxView.jsp";
	    }else if(order_Type==2){
	    	pageUrl="pages/gzhTable/wyzxView.jsp";
	    }
	    return pageUrl;
	}
	/**
	 * @param empName(String) cid(String)
	 * @return jsonObject<JSONOject>
	 * */
	@RequestMapping("/updConsult.do")
	@ResponseBody
	public JSONObject updConsult(String empName,String cid){
		JSONObject jsonObject = new JSONObject();
		int c_id=0;
		if(cid != null && !"".equals(cid)){
			c_id=Integer.parseInt(cid);
		}
		try {
			wechatUserService.updConsult(empName,c_id);
			jsonObject.put("success", 200);
		} catch (Exception e) {
			jsonObject.put("success", 400);
		}
		return jsonObject;
	}
	/**
	 * @param pageNum(String) searchContent(String) searchType(String)
	 * @return orderList<OfflinePay>
	 * */
	@RequestMapping("/selXxzx.do")
	public String selXxzx(Model model,String pageNum,
			String searchContent,String searchType) throws UnsupportedEncodingException{
		int currentPage = 1;//第一页
		if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        } 
		if (searchContent != null && !"".equals(searchContent)) {  
			searchContent = java.net.URLDecoder.decode(searchContent, "utf-8"); 
        }
		PageUtil pageUtil = new PageUtil(10, wechatUserService.XxzxCount(searchType,searchContent), currentPage);  
	    List<OfflinePay> list = wechatUserService.getPageXxzx(pageUtil.getFromIndex(), pageUtil.getPageSize(),searchType,searchContent); 
	    model.addAttribute("orderList",list);
	    model.addAttribute("currentPage",currentPage);
	    model.addAttribute("totalPage",pageUtil.getPageCount());
	    return "pages/gzhTable/xxzxView.jsp";
	}
	/**
	 * @param empName(String) cid(String)
	 * @return jsonObject<JSONObecjt>
	 * */
	@RequestMapping("/updXxzx.do")
	@ResponseBody
	public JSONObject updXxzx(String empName,String cid){
		JSONObject jsonObject = new JSONObject();
		int c_id=0;
		if(cid != null && !"".equals(cid)){
			c_id=Integer.parseInt(cid);
		}
		try {
			wechatUserService.updXxzx(empName,c_id);
			jsonObject.put("success", 200);
		} catch (Exception e) {
			jsonObject.put("success", 400);
		}
		return jsonObject;
	}
	/**
	 * 
	 **/
}
