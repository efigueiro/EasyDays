package com.easydays.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easydays.controller.CategoryController;
import com.easydays.entity.Category;
import com.easydays.entity.User;

/**
 * Servlet implementation class CreateArticle
 */
@WebServlet("/retrieveCategory")
public class RetrieveCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveCategory() {
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
		List<Category> categoryList = new ArrayList<Category>();
		
		// get user authenticated
		User authenticated = new User();
		authenticated = (User) request.getSession().getAttribute("authenticated");

		try {
			categoryList = CategoryController.getInstance().retrieveByFilter(keyword, authenticated);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("message", message);
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("modules/category/retrieveCategory.jsp").forward(request, response);
	}

}
