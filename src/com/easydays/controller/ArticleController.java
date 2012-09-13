package com.easydays.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.easydays.entity.Article;
import com.easydays.entity.Search;
import com.easydays.entity.User;
import com.easydays.model.ArticleModel;

/**
 * Classe responsável por manipular dados do banco.
 * 
 * @author Éverson Figueiró
 * @version 1.0
 */
public class ArticleController {

	private static ArticleController articleController;

	private ArticleController() {
	}

	public static ArticleController getInstance() {
		if (articleController == null) {
			articleController = new ArticleController();
		}
		return articleController;
	}

	public String create(Article article) throws Exception {
		if (StringUtils.isNotEmpty(ArticleModel.getInstance().retrieveByTitle(article.getTitle()).getTitle())) {
			return ("This title already exists, please choose another!");
		} else {
			return ArticleModel.getInstance().create(article);
		}
	}

	public String update(Article article) throws Exception {
		return ArticleModel.getInstance().update(article);
	}

	public List<Article> retrieveByUser(User authenticated) throws Exception {
		return ArticleModel.getInstance().retrieveByUser(authenticated);
	}

	public Article retrieveByArticleId(int articleId) throws Exception {
		return ArticleModel.getInstance().retrieveById(articleId);
	}

	public Article retrieveByTitle(String title) throws Exception {
		return ArticleModel.getInstance().retrieveByTitle(title);
	}

	public List<Article> retrieveByFilter(Search search, User authenticated) throws Exception {
		if (StringUtils.isNotEmpty(search.getId()) && search.getId().equals("all")) {
			return ArticleModel.getInstance().retrieveByFilter(search.getKeyword(), authenticated);
		} else {
			return ArticleModel.getInstance().retrieveByFilter(search.getKeyword(), Integer.valueOf(search.getId()), authenticated);
		}
	}

	public String delete(int articleId) throws Exception {
		return ArticleModel.getInstance().deleteById(articleId);
	}
}
