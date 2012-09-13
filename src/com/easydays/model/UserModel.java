package com.easydays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.easydays.entity.User;

/**
 * Classe responsável por manipular dados do banco.
 * 
 * @author Éverson Figueiró
 * @version 1.0
 */
public class UserModel extends BaseModel {

	private static UserModel userModel;

	private UserModel() {
	}

	public static UserModel getInstance() {
		if (userModel == null) {
			userModel = new UserModel();
		}
		return userModel;
	}
	
	public User retrieveById(int userId) throws Exception {
		Connection conn = this.getConnection();
		User user = new User();
		String sql = "select * from users where user_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				user.setCreationDate(rs.getString("creation_date"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserId(rs.getInt("user_id"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return user;
	}

}
