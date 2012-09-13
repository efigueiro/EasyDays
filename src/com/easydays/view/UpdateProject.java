package com.easydays.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.easydays.controller.CategoryController;
import com.easydays.controller.ProjectController;
import com.easydays.entity.Category;
import com.easydays.entity.Project;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/updateProject")
public class UpdateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String projectId = (String) request.getParameter("projectId");
		Project selectedProject = new Project();

		if (StringUtils.isNotEmpty(projectId)) {
			try {
				selectedProject = ProjectController.getInstance().retrieveByProjectId(Integer.valueOf(projectId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		request.setAttribute("selectedProject", selectedProject);
		request.getRequestDispatcher("modules/project/updateProject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";

		String name = (String) request.getParameter("name");
		String projectId = (String) request.getParameter("projectId");
		String description = (String) request.getParameter("description");

		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(description)) {
			message = "Please complete the fields correctly before submit!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("modules/project/updateProject.jsp").forward(request, response);
		} else {
			// create project
			Project project = new Project();

			// loading category from database
			try {
				project = ProjectController.getInstance().retrieveByProjectId(Integer.valueOf(projectId));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// set project with new values
			project.setDescription(description);
			project.setName(name);

			// update project into database
			try {
				message = ProjectController.getInstance().update(project);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// load updated project
			try {
				ProjectController.getInstance().retrieveByProjectId(Integer.valueOf(projectId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("message", message);
			request.setAttribute("selectedProject", project);
			request.getRequestDispatcher("modules/project/updateProject.jsp").forward(request, response);
		}
	}

}
