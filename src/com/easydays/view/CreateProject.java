package com.easydays.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.easydays.controller.ProjectController;
import com.easydays.entity.Project;
import com.easydays.entity.User;
import com.easydays.util.TimeConverter;

/**
 * Servlet implementation class CreateArticle
 */
@WebServlet("/createProject")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProject() {
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
			request.getRequestDispatcher("modules/project/createProject.jsp").forward(request, response);
		} else {
			// create user
			User user = (User) request.getSession().getAttribute("authenticated");

			// create category
			Project project = new Project();
			project.setCreationDate(TimeConverter.getInstance().currentDate());
			project.setDescription(description);
			project.setName(name);
			project.setUser(user);

			try {
				message = ProjectController.getInstance().create(project);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("message", message);
			request.setAttribute("project", project);
			request.getRequestDispatcher("modules/project/createProject.jsp").forward(request, response);
		}
	}

}
