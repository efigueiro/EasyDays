package com.easydays.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.easydays.controller.LoginController;
import com.easydays.entity.User;
import com.easydays.util.PropertiesUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User authenticated = new User();
		authenticated = (User) request.getSession().getAttribute("authenticated");
		String action = request.getParameter("action");
		String loginMessage = "";

		if (authenticated == null || action.equals("logout")) {
			request.getSession().invalidate();
			loginMessage = PropertiesUtil.getProperty("message.sessionClosed");
			request.setAttribute("loginMessage", loginMessage);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginMessage;

		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		if (email.equals("") || password.equals("")) {
			loginMessage = PropertiesUtil.getProperty("message.emptyField");
			request.setAttribute("loginMessage", loginMessage);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			User authenticated = new User();
			try {
				authenticated = LoginController.getInstance().authentication(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!StringUtils.isEmpty(authenticated.getEmail())) {
				HttpSession session = request.getSession();
				session.setAttribute("authenticated", authenticated);
				request.getRequestDispatcher("modules/main.jsp").forward(request, response);
			} else {
				loginMessage = PropertiesUtil.getProperty("message.userNotFound");
				request.setAttribute("loginMessage", loginMessage);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}
}
