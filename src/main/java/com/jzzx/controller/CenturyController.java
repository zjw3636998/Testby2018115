package com.jzzx.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jzzx.bean.CenturyPlan;
import com.jzzx.service.CenturyService;
import com.jzzx.util.PageUtil;
import com.jzzx.util.RandomUtil;

/**
 * 百年计划控制类
 * @author yyq
 *'============================================================================
 *'selectCenturyPlan 查询百年计划用户
 *'dealCenturyPlan 处理百年计划
 *'updCenturyPlanPs 上传修改备注消息
 *'updDealMessage 增加负责人
 *'selRemake 查看备注
 *'============================================================================
 * */
@Controller
public class CenturyController {
	private String time;
	private CenturyService centuryService;
	@Autowired
	public void setCenturyService(CenturyService centuryService) {
		this.centuryService = centuryService;
	}
	/**
	 * @param planSource(String) pageNum(String) searchContent(String) searchType(String)
	 * @return list<CenturyPlan>
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/selCenturyPlan.do")
	public String selectCenturyPlan(String planSource,Model model,String pageNum,
			String searchContent,String searchType) throws UnsupportedEncodingException{
		int currentPage = 1;//第一页
		int source=Integer.parseInt(planSource);
		if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        }
		if (searchContent != null && !"".equals(searchContent)) {  
			searchContent = java.net.URLDecoder.decode(searchContent, "utf-8"); 
        } 
		 PageUtil pageUtil = new PageUtil(10, centuryService.centuryCount(source,searchType,searchContent), currentPage);  
	     List<CenturyPlan> list = centuryService.getPageCentury(pageUtil.getFromIndex(), pageUtil.getPageSize(),searchType,searchContent,source);
	     model.addAttribute("centuryList",list);
	     model.addAttribute("currentPage",currentPage);
	     model.addAttribute("totalPage",pageUtil.getPageCount());
		return "pages/xcxUser/xcxUser.jsp";
	}
	/**
	 * @param dealEmp(String) cId(String)
	 * @return 
	 **/
	@RequestMapping(value="/dealCentury.do")
	public JSONObject dealCenturyPlan(String dealEmp,String cId,HttpSession session){
		JSONObject jsonObject = new JSONObject();
		int id=Integer.parseInt(cId);
		time=RandomUtil.getDataFormat();
		//UserTable emp=(UserTable) session.getAttribute("");
		String assignEmp="杨二";//测试
		centuryService.insertDeal(dealEmp,assignEmp,id,time);
		return jsonObject;
	}
	/**
	 * @param remake(String) cId(String)
	 * @return 
	 * */
	@RequestMapping(value="/updCenturyPlanPs.do")
	public String updCenturyPlanPs(String remake,String cId){
		int id=Integer.parseInt(cId);
		time=RandomUtil.getDataFormat();
		//UserTable emp=(UserTable) session.getAttribute("");
		String assignEmp="杨二";//测试
		String content=assignEmp+"于"+time+"上传备注信息为:"+remake;
		centuryService.updCenturyPlanPs(content,id);
		return "";
	}
	/**
	 * 
	 **/
	
	@RequestMapping(value="/updDealMessage.do",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updDealMessage(String empName,String cid){
		JSONObject jsonObject = new JSONObject();
		int c_id=0;
		if(cid != null && !"".equals(cid)){
			c_id=Integer.parseInt(cid);
		}
		try {
			centuryService.updDealMessage(empName,c_id);
			jsonObject.put("success", 200);
		} catch (Exception e) {
			jsonObject.put("success", 400);
		}
		return jsonObject;
	}
	@RequestMapping(value="/delCentury.do")
	public String delCentury(String cid,String source){
		int c_id=0;
		if(cid != null && !"".equals(cid)){
			c_id=Integer.parseInt(cid);
		}
		centuryService.delCentury(c_id);
		return "selCenturyPlan.do?planSource="+source;
	}
	@RequestMapping(value="/selRemake.do",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject selRemake(String cid){
		JSONObject jsonObject = new JSONObject();
		int c_id=0;
		if(cid != null && !"".equals(cid)){
			c_id=Integer.parseInt(cid);
		}
		try {
			String remake=centuryService.selRemake(c_id);
			jsonObject.put("success", 200);
			jsonObject.put("data", remake);
		} catch (Exception e) {
			jsonObject.put("success", 400);
			jsonObject.put("data", "无数据");
		}
		return jsonObject;
	}
	@RequestMapping(value="/addRemake.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addRemake(String cid,String content){
		JSONObject jsonObject=new JSONObject();
		int c_id=0;
		if(cid != null && !"".equals(cid)){
			c_id=Integer.parseInt(cid);
		}
		try {
			centuryService.addRemake(c_id,content);
			jsonObject.put("success", 200);
		} catch (Exception e) {
			jsonObject.put("success", 400);
		}
		return	jsonObject; 
	}
}
