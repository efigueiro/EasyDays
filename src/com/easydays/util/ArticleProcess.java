package com.easydays.util;

import org.apache.commons.lang3.StringUtils;

import com.easydays.entity.Article;

public class ArticleProcess {

	private static ArticleProcess articleProcess;

	private ArticleProcess() {
	}

	public static ArticleProcess getInstance() {
		if (articleProcess == null) {
			articleProcess = new ArticleProcess();
		}
		return articleProcess;
	}

	public Article articleFormatter(Article article) {

		// Processa o corpo do artigo formatando e devolve artigo.
		if (StringUtils.isNotEmpty(article.getArticleBody())) {
			String articleBodyAux = article.getArticleBody().replace("\n", "<br>");
			articleBodyAux = "<p>" + articleBodyAux + "</p>";
			article.setArticleBody(articleBodyAux);
		}

		return article;

	}

	public Article articleUTF8ToISO(Article article) {
		return article;
	}

}
