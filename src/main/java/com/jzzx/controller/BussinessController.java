package com.jzzx.controller;
/**
 * 任务分配模块
 * @author yyq
 * @time 2018/8/2 15:00
 * ============================================================================
 * sourceCentury 查询百年计划申请人
 * updDealState 百年计划划分责任人
 * sourceWyzx 查询微云咨询申请人
 * updDealWyzx 微云咨询划分责任人
 * sourceXxzx 查询线下咨询申请人
 * updDealXxzx 线下咨询划分责任人
 * ============================================================================
 * */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jzzx.bean.CenturyPlan;
import com.jzzx.bean.OfflinePay;
import com.jzzx.bean.OrderTable;
import com.jzzx.service.BussinessService;

@Controller
public class BussinessController {
	private BussinessService bussinessService;
	@Autowired
	public void setBussinessService(BussinessService bussinessService) {
		this.bussinessService = bussinessService;
	}
	/**
	 * @param
	 * @return list<centuryPlan>
	 * */
	@RequestMapping("/sourceCentury.do")
	public String sourceCentury(Model model){
		int dealState=2;
		int planSource=2;
		List<CenturyPlan> centuryPlan = bussinessService.sourceCentury(dealState,planSource);
		model.addAttribute("list",centuryPlan);
		return "pages/customer/cusCenturyPlan.jsp";
	}
	/**
	 * @param ds_id(String) ds_state(String)
	 * @return  
	 * */
	@RequestMapping("/updDealState.do")
	public String updDealState(String ds_id,String ds_state){
		int dsId=0;
		if (ds_id != null && !"".equals(ds_id)) { 
			dsId=Integer.parseInt(ds_id);
		}
		int state=Integer.parseInt(ds_state);
		bussinessService.updDealState(dsId,state);
		return "sourceCentury.do";
	}
	/**
	 * @param
	 * @return list<OrderTable>
	 * */
	@RequestMapping("/sourceWyzx.do")
	public String sourceWyzx(Model model){
		int ordertype=2;
		int orderState=2;
		List<OrderTable> orderTable = bussinessService.sourceWyzx(ordertype,orderState);
		model.addAttribute("list",orderTable);
		return "pages/customer/cusWyzx.jsp";
	}
	/**
	 * @param ds_id(String) ds_state(String
	 * @return
	 * */
	@RequestMapping("/updDealWyzx.do")
	public String updDealWyzx(String ds_id,String ds_state){
		int dsId=0;
		if (ds_id != null && !"".equals(ds_id)) { 
			dsId=Integer.parseInt(ds_id);
		}
		int state=Integer.parseInt(ds_state);
		bussinessService.updDealWyzx(dsId,state);
		return "sourceWyzx.do";
	}
	/**
	 * @param
	 * @return list<OfflinePay>
	 * */
	@RequestMapping("/sourceXxzx.do")
	public String sourceXxzx(Model model){
		int orderState=2;
		List<OfflinePay> offlinePay = bussinessService.sourceXxzx(orderState);
		model.addAttribute("list",offlinePay);
		return "pages/customer/cusXxzx.jsp";
	}
	/**
	 * @param ds_id(String) ds_state(String)
	 * @return 
	 * */
	@RequestMapping("/updDealXxzx.do")
	public String updDealXxzx(String ds_id,String ds_state){
		int dsId=0;
		if (ds_id != null && !"".equals(ds_id)) { 
			dsId=Integer.parseInt(ds_id);
		}
		int state=Integer.parseInt(ds_state);
		bussinessService.updDealXxzx(dsId,state);
		return "sourceXxzx.do";
	}
}
