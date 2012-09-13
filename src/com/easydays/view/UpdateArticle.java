package com.easydays.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.easydays.controller.ArticleController;
import com.easydays.entity.Article;
import com.easydays.entity.Category;
import com.easydays.entity.User;

/**
 * Servlet implementation class CreateArticle
 */
@WebServlet("/updateArticle")
public class UpdateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleId = (String) request.getParameter("articleId");
		Article selectedArticle = new Article();

		if (StringUtils.isNotEmpty(articleId)) {
			try {
				selectedArticle = ArticleController.getInstance().retrieveByArticleId(Integer.valueOf(articleId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		request.setAttribute("selectedArticle", selectedArticle);
		request.getRequestDispatcher("modules/article/updateArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		String articleId = (String) request.getParameter("articleId");
		String title = (String) request.getParameter("title");
		String articleBody = (String) request.getParameter("articleBody");
		String categoryId = (String) request.getParameter("category");

		if (StringUtils.isEmpty(title) || StringUtils.isEmpty(articleBody) || categoryId.equals("default")) {
			message = "Please complete the fields correctly before submit!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("modules/article/updateArticle.jsp").forward(request, response);
		} else {
			// Create category
			Category category = new Category();
			category.setCategoryId(Integer.valueOf(categoryId));

			// Create user
			User user = (User) request.getSession().getAttribute("authenticated");
			
			// load article by id
			Article article = new Article();
			try {
				article = ArticleController.getInstance().retrieveByArticleId(Integer.valueOf(articleId));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// update article and save
			article.setArticleId(Integer.valueOf(articleId));
			article.setArticleBody(articleBody);
			article.setTitle(title);
			article.setUser(user);
			article.setCategory(category);

			try {
				message = ArticleController.getInstance().update(article);
				article = ArticleController.getInstance().retrieveByArticleId(Integer.valueOf(articleId));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("message", message);
			request.setAttribute("article", article);
			request.setAttribute("selectedArticle", article);
			request.getRequestDispatcher("modules/article/updateArticle.jsp").forward(request, response);
		}
	}

}
