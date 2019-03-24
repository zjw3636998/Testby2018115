package com.jzzx.bean;
/**
 * 文章表
 **/
public class Article {
		//文章ID
		private int article_id;
		//文章题目
		private String article_title;
		//文章图片
		private String article_img;
		//文章作者
		private String article_author;
		//文章内容
		private String article_content;
		//文章发表时间
		private String article_time;
		//文章阅读量
		private int article_reader;
		//文章状态 0未删除 1已删除
		private int article_state;
		
		public Article() {
			super();
		}
		public Article(int article_id, String article_title, String article_img,String article_author, String article_time,
				int article_reader) {
			super();
			this.article_id = article_id;
			this.article_title = article_title;
			this.article_img=article_img;
			this.article_author = article_author;
			this.article_time = article_time;
			this.article_reader = article_reader;
		}
		
		public Article(String article_title, String article_img, String article_author, String article_content,
				String article_time, int article_reader, int article_state) {
			super();
			this.article_title = article_title;
			this.article_img = article_img;
			this.article_author = article_author;
			this.article_content = article_content;
			this.article_time = article_time;
			this.article_reader = article_reader;
			this.article_state = article_state;
		}

		@Override
		public String toString() {
			return "Article [article_id=" + article_id + ", article_title=" + article_title + ", article_author="
					+ article_author + ", article_content=" + article_content + ", article_time=" + article_time + "]";
		}
		public int getArticle_state() {
			return article_state;
		}
		public void setArticle_state(int article_state) {
			this.article_state = article_state;
		}
		
		public String getArticle_img() {
			return article_img;
		}

		public void setArticle_img(String article_img) {
			this.article_img = article_img;
		}

		public int getArticle_id() {
			return article_id;
		}
		public void setArticle_id(int article_id) {
			this.article_id = article_id;
		}
		public String getArticle_title() {
			return article_title;
		}
		public void setArticle_title(String article_title) {
			this.article_title = article_title;
		}
		public String getArticle_author() {
			return article_author;
		}
		public void setArticle_author(String article_author) {
			this.article_author = article_author;
		}
		public String getArticle_content() {
			return article_content;
		}
		public void setArticle_content(String article_content) {
			this.article_content = article_content;
		}
		public String getArticle_time() {
			return article_time;
		}
		public void setArticle_time(String article_time) {
			this.article_time = article_time;
		}
		public int getArticle_reader() {
			return article_reader;
		}
		public void setArticle_reader(int article_reader) {
			this.article_reader = article_reader;
		}
		
	
}
