package com.sxl.entity;

import java.util.List;

public class NewsMessage extends BaseMessage{
	private int ArticleCount;
    private List<News> Articles;
     
    public int getArticleCount(){
    	return ArticleCount;
    	}
    public void setArticleCount(int articleCount){
    	ArticleCount = articleCount;
    }
    public List<News> getArticle(){
    	return Articles;
    }
    public void setArticle(List<News> article){
    	Articles = article;
    }

}
