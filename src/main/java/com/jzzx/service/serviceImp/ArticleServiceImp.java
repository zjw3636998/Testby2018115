package com.jzzx.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzzx.bean.Article;
import com.jzzx.dao.ArticleDao;
import com.jzzx.service.ArticleService;

@Service("ArticleService")
public class ArticleServiceImp implements ArticleService{
	private ArticleDao articleDao;
	@Autowired
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	public int totalCount(int i) {
		return articleDao.totalCount(i);
	}
	public List<Article> getPageUtilsArticle(int fromIndex, int pageSize) {
		return articleDao.getPageUtilsArticle(fromIndex, pageSize);
	}
	public void addArticle(Article art) {
		articleDao.addArticle(art);
		
	}
	public void delArticle(int article_id,int art_state) {
		articleDao.delArticle(article_id,art_state);
		
	}
	public String searchArticleContent(int articleId) {
		return articleDao.searchArticleContent(articleId);
	}
	public List<Article> searchDeleteArticle(int fromIndex, int pageSize, int art_state) {
		return articleDao.searchDeleteArticle(fromIndex, pageSize,art_state);
	}
	public int delArticleTotal(int i) {
		return articleDao.delArticleTotal(i);
	}
	public void completelyDeleted(int articleId) {
		articleDao.completelyDeleted(articleId);
		
	}


}
