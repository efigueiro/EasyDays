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
import com.easydays.util.Msg;
import com.easydays.util.TimeConverter;

/**
 * Servlet implementation class CreateArticle
 */
@WebServlet("/createArticle")
public class CreateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		String title = (String) request.getParameter("title");
		String articleBody = (String) request.getParameter("articleBody");
		String categoryId = (String) request.getParameter("category");

		if (StringUtils.isEmpty(title) || StringUtils.isEmpty(articleBody) || categoryId.equals("default")) {
			message = Msg.getProperty("message.emptyField");
			request.setAttribute("message", message);
			request.getRequestDispatcher("modules/article/createArticle.jsp").forward(request, response);
		} else {
			// create category
			Category category = new Category();
			category.setCategoryId(Integer.valueOf(categoryId));

			// create user
			User user = (User) request.getSession().getAttribute("authenticated");

			// create article
			Article article = new Article();
			article.setCreationDate(TimeConverter.getInstance().currentDate());
			article.setArticleBody(articleBody);
			article.setTitle(title);
			article.setUser(user);
			article.setCategory(category);

			try {
				message = ArticleController.getInstance().create(article);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("message", message);
			request.setAttribute("article", article);
			request.getRequestDispatcher("modules/article/createArticle.jsp").forward(request, response);
		}
	}

}
