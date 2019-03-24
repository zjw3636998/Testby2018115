package com.jzzx.service;

import java.util.List;

import com.jzzx.bean.Article;
/**
 * 策略功能
 */
public interface ArticleService {
	/* 分页查询文章数量 */
	int totalCount(int i);
	List<Article> getPageUtilsArticle(int fromIndex, int pageSize);
	/* 发表文章 */
	void addArticle(Article art);
	/* 删除文章&&恢复文章 */
	void delArticle(int articleId, int art_state);
	/* 查询文章全部内容 */
	String searchArticleContent(int articleId);
	/* 查询预删除文章 */
	List<Article> searchDeleteArticle(int fromIndex, int pageSize, int art_state);
	int delArticleTotal(int i);
	/* 完全删除文章 */
	void completelyDeleted(int articleId);

}
