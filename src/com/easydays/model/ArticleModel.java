package com.easydays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.easydays.controller.CategoryController;
import com.easydays.entity.Article;
import com.easydays.entity.Category;
import com.easydays.entity.User;

/**
 * Classe responsável por manipular dados do banco.
 * 
 * @author Éverson Figueiró
 * @version 1.0
 */
public class ArticleModel extends BaseModel {

	private static ArticleModel articleModel;

	private ArticleModel() {
	}

	public static ArticleModel getInstance() {
		if (articleModel == null) {
			articleModel = new ArticleModel();
		}
		return articleModel;
	}

	public String create(Article article) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into article(title, article_body, creation_date, user_id, category_id)" + "values(?,?,?,?,?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, article.getTitle());
			pstm.setString(2, article.getArticleBody());
			pstm.setString(3, article.getCreationDate());
			pstm.setInt(4, article.getUser().getUserId());
			pstm.setInt(5, article.getCategory().getCategoryId());
			pstm.execute();
			pstm.close();
			conn.close();

			message = "Article created!";
		} catch (Exception e) {
			message = e + " The system encountered problems to perform this action!";
			conn.close();
		}
		return message;
	}
	
	public String update(Article article) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "update article set title=?, article_body=?, creation_date=?, user_id=?, category_id=?" +
				"where article_id=?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, article.getTitle());
			pstm.setString(2, article.getArticleBody());
			pstm.setString(3, article.getCreationDate());
			pstm.setInt(4, article.getUser().getUserId());
			pstm.setInt(5, article.getCategory().getCategoryId());
			pstm.setInt(6, article.getArticleId());
			pstm.execute();
			pstm.close();
			conn.close();

			message = "Article updated!";
		} catch (Exception e) {
			message = e + " The system encountered problems to perform this action!";
			conn.close();
		}
		return message;
	}

	public List<Article> retrieveByUser(User authenticated) throws Exception {
		Connection conn = this.getConnection();
		List<Article> articleList = new ArrayList<Article>();
		String sql = "select * from article where user_id = ? order by title;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, Integer.valueOf(authenticated.getUserId()));
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				Category category = new Category();

				article.setArticleBody(rs.getString("article_body"));
				article.setArticleId(rs.getInt("article_id"));
				category.setCategoryId(rs.getInt("category_id"));
				article.setCategory(category);
				article.setCreationDate(rs.getString("creation_date"));
				article.setTitle(rs.getString("title"));
				article.setUser(authenticated); 
				articleList.add(article);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return articleList;
	}

	public Article retrieveById(int articleId) throws Exception {
		Connection conn = this.getConnection();
		Article article = new Article();
		String sql = "select * from article where article_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, articleId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				article.setArticleBody(rs.getString("article_body"));
				article.setArticleId(rs.getInt("article_id"));
				article.setCreationDate(rs.getString("creation_date"));
				article.setTitle(rs.getString("title"));

				// Load category
				Category category = new Category();
				category = CategoryController.getInstance().retrieveByCategoryId(rs.getInt("category_id"));
				article.setCategory(category);

			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return article;
	}

	public Article retrieveByTitle(String title) throws Exception {
		Connection conn = this.getConnection();
		Article article = new Article();
		String sql = "select * from article where title = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, title);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {

				// carregar artigo aqui...

			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return article;
	}

	// search for all categories
	public List<Article> retrieveByFilter(String keyword, User authenticated) throws Exception {
		Connection conn = this.getConnection();
		List<Article> articleList = new ArrayList<Article>();
		String sql = "select * from article where (title ilike ? or article_body ilike ?) and user_id =? order by title";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + keyword + "%");
			pstm.setString(2, "%" + keyword + "%");
			pstm.setInt(3, authenticated.getUserId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				Category category = new Category();
				User user = new User();

				// Load article
				article.setArticleBody(rs.getString("article_body"));
				article.setArticleId(rs.getInt("article_id"));
				article.setCreationDate(rs.getString("creation_date"));
				article.setTitle(rs.getString("title"));

				// Load category
				category.setCategoryId(rs.getInt("category_id"));
				category = CategoryController.getInstance().retrieveByCategoryId(category.getCategoryId());
				article.setCategory(category);

				// Load user/author
				user.setUserId(rs.getInt("user_id"));
				article.setUser(user);

				// Add article to articleList
				articleList.add(article);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return articleList;
	}

	// search for a specific category
	public List<Article> retrieveByFilter(String keyword, int categoryId, User authenticated) throws Exception {
		Connection conn = this.getConnection();
		List<Article> articleList = new ArrayList<Article>();
		String sql = "select * from article where (title ilike ? or article_body ilike ?) and category_id = ? and user_id =? order by title";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + keyword + "%");
			pstm.setString(2, "%" + keyword + "%");
			pstm.setInt(3, categoryId);
			pstm.setInt(4, authenticated.getUserId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				Category category = new Category();
				User user = new User();

				// Load article
				article.setArticleBody(rs.getString("article_body"));
				article.setArticleId(rs.getInt("article_id"));
				article.setCreationDate(rs.getString("creation_date"));
				article.setTitle(rs.getString("title"));

				// Load category
				category.setCategoryId(rs.getInt("category_id"));
				category = CategoryController.getInstance().retrieveByCategoryId(category.getCategoryId());
				article.setCategory(category);

				// Load user/author
				user.setUserId(rs.getInt("user_id"));
				article.setUser(user);

				// Add article to articleList
				articleList.add(article);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return articleList;
	}

	public String deleteById(int articleId) throws Exception {
		Connection conn = this.getConnection();
		String sql = "delete from article where article_id = ?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, articleId);
			pstm.execute();
			return "Deleted!";
		} catch (Exception e) {
			conn.close();
		}
		return null;
	}

}
