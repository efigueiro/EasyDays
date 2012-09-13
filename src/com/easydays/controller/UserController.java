package com.easydays.controller;

import com.easydays.entity.User;
import com.easydays.model.UserModel;

/**
 * Classe respons�vel por manipular dados do banco.
 * 
 * @author �verson Figueir�
 * @version 1.0
 */
public class UserController {

	private static UserController userController;

	private UserController() {
	}

	public static UserController getInstance() {
		if (userController == null) {
			userController = new UserController();
		}
		return userController;
	}

	public User retrieveById(int userId) throws Exception {
		return UserModel.getInstance().retrieveById(userId);
	}

}
