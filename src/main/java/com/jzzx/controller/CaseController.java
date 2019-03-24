package com.jzzx.controller;
/**
'案例管理类
'@author yyq
'@time 2018/8/2 15:00
'============================================================================
'searchArticle 查询案例
'searchCaseContent  查询案例内容
'delCase 删除案例
'searchCaseType 查询所有行业并进入添加案例页面
'addCase 添加案例
'searchDeleteCase 查询预删除案例
'deletedCase 完全删除案例
'recoverCase 恢复案例
'============================================================================
'*/

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jzzx.bean.CaseTable;
import com.jzzx.bean.CaseType;
import com.jzzx.bean.UserTable;
import com.jzzx.util.PageUtil;
import com.jzzx.util.RandomUtil;
import com.jzzx.service.CaseService;
@Controller
public class CaseController {
	private CaseService caseService;
	@Autowired
	public void setCaseService(CaseService caseService) {
		this.caseService = caseService;
	}
	/**
	 * 查询案例
	 * @param pageNum(String)
	 * @return list<CaseTable>
	 * */
	@RequestMapping("/searchCase.do")
	public String searchArticle(String pageNum,HttpServletRequest req,Model model){
		int currentPage = 1;
		int i=0;//案例状态
        if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        }  
        PageUtil pageUtil = new PageUtil(10, caseService.totalCount(i), currentPage);  
        List<CaseTable> lists = caseService.getPageUtilsCase(pageUtil.getFromIndex(), pageUtil.getPageSize(),i);  
        model.addAttribute("caseList",lists);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPage",pageUtil.getPageCount());
		return "pages/gzhCase/gzhCase.jsp";
	}
	/**
	 * 查询案例内容
	 * @param case_id(String)
	 * @return CaseTable
	 * */
	@RequestMapping("/caseContent.do")
	public String searchCaseContent(String case_id,Model model){
		int caseId=Integer.parseInt(case_id);
		CaseTable caseTable=caseService.searchCaseContent(caseId);
		model.addAttribute("caseTable",caseTable);
		return "pages/gzhCase/caseContent.jsp";
	}
	/**
	 * 删除案例
	 * @param case_id(String)
	 * @return 
	 * */
	@RequestMapping("/delCase.do")
	public String delCase(String case_id){
		int caseId=Integer.parseInt(case_id);
		int case_state=1;
		caseService.delCase(caseId,case_state);
		return "searchCase.do";
	}
	/**
	 * 查询所有行业并进入添加案例页面
	 * @param 
	 * @return CaseType
	 * */
	@RequestMapping("/addCasePage.do")
	public String searchCaseType(Model model){
		List<CaseType> caseType=caseService.searchCaseType();
		model.addAttribute("caseList", caseType);
		return "pages/gzhCase/addCase.jsp";
	}
	/**
	 * 添加案例
	 * @param title(String) caseType(String) descript(String) question(String) answer(String) result(String)
	 * @return 
	 * */
	@RequestMapping("/addCase.do")
	public String addCase(String arttitle,String caseType,String descript,String question,String answer,String result,HttpSession session){
		UserTable emp=(UserTable) session.getAttribute("userTable");
		String submitTime=RandomUtil.getDataFormat();
		int caseType_id=Integer.parseInt(caseType); //案例类型
		int reader=0;							//阅读量
		int case_state=0;						//案例状态 默认0
		CaseTable caseTable=new CaseTable(arttitle,caseType_id,descript,question,answer,result,emp.getU_name(),submitTime,reader,case_state);
		caseService.addCase(caseTable);
		return "searchCase.do";
	}
	/**
	 * 查询预删除案例
	 * @param pageNum(String)
	 * @return List<CaseTable>
	 * */
	@RequestMapping("/searchDeleteCase.do")
	public String searchDeleteCase(Model model,String pageNum){
		int currentPage = 1;
		int case_state=1;//
        if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        }  
        PageUtil pageUtil = new PageUtil(10, caseService.totalCount(case_state), currentPage);  
        List<CaseTable> lists = caseService.getPageUtilsCase(pageUtil.getFromIndex(), pageUtil.getPageSize(),case_state);
        model.addAttribute("caseList",lists);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPage",pageUtil.getPageCount());
		return "pages/gzhCase/delGzhCase.jsp";
	}
	/**
	 * 完全删除案例
	 * @param case_id(String)
	 * @return 
	 * */
	@RequestMapping("/deleteCase.do")
	public String deletedCase(String case_id){
		int caseId=Integer.parseInt(case_id);
		caseService.deleteCase(caseId);
		return "searchDeleteCase.do";
	}
	/**
	 * 恢复案例
	 * @param case_id(String)
	 * @return 
	 * */
	@RequestMapping("/recoverCase.do")
	public String recoverCase(String case_id){
		int caseId=Integer.parseInt(case_id);
		int case_state=0;
		caseService.delCase(caseId,case_state);
		return "searchDeleteCase.do";
	}
}
