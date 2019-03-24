 package com.jzzx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jzzx.bean.Article;
import com.jzzx.bean.UserTable;
import com.jzzx.service.ArticleService;
import com.jzzx.util.PageUtil;
import com.jzzx.util.RandomUtil;
/**
'策略文章管理
'@author yyq
'============================================================================
'searchArticle 查询策略
'addArticle  添加策略
'delArticle 删除策略
'searchDeleteArticle 查询预删除策略
'recoverArticle 恢复策略
'completelyDeleted 完全删除策略
'searchDeleteArticle 查询预删除策略
'searchArticleContent 查询策略内容
'============================================================================
'*/

@Controller
public class ArticleController {
	private ArticleService articleService;
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	/**
	 * 查询案例（分页）
	 * @param pageNum
	 * @return list<Article>
	 * @return currentpage 
	 * @return totalPage 
	 */
	@RequestMapping("/searchArticle.do")
	public String searchArticle(String pageNum,HttpServletRequest req,Model model){
		int currentPage = 1;
        if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        }  
        PageUtil pageUtil = new PageUtil(10, articleService.totalCount(0), currentPage);  
        List<Article> lists = articleService.getPageUtilsArticle(pageUtil.getFromIndex(), pageUtil.getPageSize()); 
        model.addAttribute("articleList",lists);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPage",pageUtil.getPageCount());
		return "pages/gzhArticle/gzhArticle.jsp";
	}
	/**
	 * 添加案例
	 * @param title 
	 * @param content 
	 * @param articleImg
	 * @param emp
	 * @returnUrl searchArticle.do
	 */
	@RequestMapping(value="/addArticle.do",method = RequestMethod.POST)
	public String addArticle(String arttitle,String content,String imglink,HttpSession session,Model model){
		UserTable ut=(UserTable) session.getAttribute("userTable");
		System.out.println(arttitle+imglink+ut.getU_name());
		String time=RandomUtil.getDataFormat();
		int reader=0;//阅读量
		int state=0;//状态
		Article art=new Article(arttitle,imglink,ut.getU_name(),content,time,reader,state);
		articleService.addArticle(art);
		return "searchArticle.do";
	}
	/**
	 * 删除案例
	 * @param article_id 
	 * @return
	 */
	@RequestMapping("/delArticle.do")
	public String delArticle(String article_id){
		int articleId=Integer.parseInt(article_id);
		int art_state=1;//案例状态
		articleService.delArticle(articleId,art_state);
		return "searchArticle.do";
	}
	/**
	 *查询内容
	 *@param article_id 
	 *@return content 
	 */
	@RequestMapping("/searchContent.do")
	public String searchArticleContent(String article_id,Model model){
		int articleId=Integer.parseInt(article_id);
		String content=articleService.searchArticleContent(articleId);
		model.addAttribute("content",content);
		return "pages/gzhArticle/articleContent.jsp";
	}
	/** 
	 * 查询预删除文章
	 * @param pageNum
	 * @return list<Article>
	 */
	@RequestMapping("/searchDelArticle.do")
	public String searchDeleteArticle(Model model,String pageNum){
		int currentPage = 1;
		int art_state=1;//
        if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        }  
        PageUtil pageUtil = new PageUtil(10, articleService.delArticleTotal(0), currentPage);  
        List<Article> lists = articleService.searchDeleteArticle(pageUtil.getFromIndex(), pageUtil.getPageSize(),art_state);  
        model.addAttribute("articleList",lists);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPage",pageUtil.getPageCount());
		return "pages/gzhArticle/delGzhArticle.jsp";
	}
	/**
	 * 恢复预删除策略
	 * @param article_id 
	 * @return 
	 */
	@RequestMapping("/recover.do")
	public String recoverArticle(String article_id){
		int articleId=Integer.parseInt(article_id);
		int art_state=0;
		articleService.delArticle(articleId,art_state);
		return "searchDelArticle.do";
	}
	/** 
	 * 完全删除策略
	 * @param article_id
	 * @return searchDelArticle.do
	 */
	@RequestMapping("/completelyDeleted.do")
	public String completelyDeleted(String article_id){
		int articleId=Integer.parseInt(article_id);
		articleService.completelyDeleted(articleId);
		return "searchDelArticle.do";
	}
}
