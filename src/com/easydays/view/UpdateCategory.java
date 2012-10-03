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
import com.easydays.util.PropertiesUtil;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/updateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String categoryId = (String) request.getParameter("categoryId");
		Category selectedCategory = new Category();

		if (StringUtils.isNotEmpty(categoryId)) {
			try {
				selectedCategory = CategoryController.getInstance().retrieveByCategoryId(Integer.valueOf(categoryId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		request.setAttribute("selectedCategory", selectedCategory);
		request.getRequestDispatcher("modules/category/updateCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		String name = (String) request.getParameter("name");
		String categoryId = (String) request.getParameter("categoryId");
		String description = (String) request.getParameter("description");

		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(description)) {
			message = PropertiesUtil.getProperty("message.emptyFiled");
			request.setAttribute("message", message);
			request.getRequestDispatcher("modules/category/updateCategory.jsp").forward(request, response);
		} else {
			// create category
			Category category = new Category();

			// loading category from database
			try {
				category = CategoryController.getInstance().retrieveByCategoryId(Integer.valueOf(categoryId));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// set category with new values
			category.setDescription(description);
			category.setName(name);

			// update category into database
			try {
				message = CategoryController.getInstance().update(category);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// load updated category
			try {
				CategoryController.getInstance().retrieveByCategoryId(Integer.valueOf(categoryId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("message", message);
			request.setAttribute("selectedCategory", category);
			request.getRequestDispatcher("modules/category/updateCategory.jsp").forward(request, response);
		}
	}

}
