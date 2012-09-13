package com.easydays.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easydays.controller.ArticleController;
import com.easydays.entity.Article;
import com.easydays.entity.Search;
import com.easydays.entity.User;

/**
 * Servlet implementation class CreateArticle
 */
@WebServlet("/retrieveArticle")
public class RetrieveArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveArticle() {
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

		String keyword = (String) request.getParameter("keyword");
		String categoryId = (String) request.getParameter("category");
		List<Article> articleList = new ArrayList<Article>();

		// loading authenticated user from session
		User authenticated = new User();
		authenticated = (User) request.getSession().getAttribute("authenticated");

		// create a search object
		Search search = new Search();
		search.setKeyword(keyword);
		search.setId(categoryId);

		try {
			articleList = ArticleController.getInstance().retrieveByFilter(search, authenticated);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("message", message);
		request.setAttribute("articleList", articleList);
		request.getRequestDispatcher("modules/article/retrieveArticle.jsp").forward(request, response);
	}

}
