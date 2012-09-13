package com.easydays.controller;

import com.easydays.entity.User;
import com.easydays.model.LoginModel;

/**
 * Classe responsável por manipular dados do banco.
 * 
 * @author Éverson Figueiró
 * @version 1.0
 */
public class LoginController {

	private static LoginController loginController;

	private LoginController() {
	}

	public static LoginController getInstance() {
		if (loginController == null) {
			loginController = new LoginController();
		}
		return loginController;
	}

	public User authentication(User user) throws Exception {
		User authenticated = new User();
		authenticated = LoginModel.getInstance().authentication(user);
		return authenticated;
	}

}
