package com.jzzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jzzx.bean.Article;

public interface ArticleDao {
	int totalCount(@Param("state")int i);
	List<Article> getPageUtilsArticle(@Param("fromIndex")int fromIndex,@Param("pageSize")int pageSize);
	void addArticle(Article art);
	void delArticle(@Param("article_id")int article_id, @Param("art_state")int art_state);
	String searchArticleContent(@Param("article_id")int articleId);
	List<Article> searchDeleteArticle(@Param("fromIndex")int fromIndex,@Param("pageSize")int pageSize,@Param("state")int art_state);
	int delArticleTotal(@Param("state")int i);
	void completelyDeleted(@Param("article_id")int articleId);
}
