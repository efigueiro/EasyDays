package com.easydays.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.easydays.controller.CategoryController;
import com.easydays.entity.Category;
import com.easydays.entity.User;
import com.easydays.util.TimeConverter;

/**
 * Servlet implementation class CreateArticle
 */
@WebServlet("/createCategory")
public class CreateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateCategory() {
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

		String name = (String) request.getParameter("name");
		String description = (String) request.getParameter("description");

		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(description)) {
			message = "Please complete the fields correctly before submit!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("modules/category/createCategory.jsp").forward(request, response);
		} else {
			// create user
			User user = (User) request.getSession().getAttribute("authenticated");

			// create category
			Category category = new Category();
			category.setCreationDate(TimeConverter.getInstance().currentDate());
			category.setDescription(description);
			category.setName(name);
			category.setUser(user);

			try {
				message = CategoryController.getInstance().create(category);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("message", message);
			request.setAttribute("category", category);
			request.getRequestDispatcher("modules/category/createCategory.jsp").forward(request, response);
		}
	}

}
