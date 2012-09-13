package com.easydays.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easydays.controller.ProjectController;
import com.easydays.entity.Project;
import com.easydays.entity.User;

/**
 * Servlet implementation class CreateArticle
 */
@WebServlet("/retrieveProject")
public class RetrieveProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveProject() {
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
		List<Project> projectList = new ArrayList<Project>();
		
		// get user authenticated
		User authenticated = new User();
		authenticated = (User) request.getSession().getAttribute("authenticated");

		try {
			projectList = ProjectController.getInstance().retrieveByFilter(keyword, authenticated);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("message", message);
		request.setAttribute("projectList", projectList);
		request.getRequestDispatcher("modules/project/retrieveProject.jsp").forward(request, response);
	}

}
