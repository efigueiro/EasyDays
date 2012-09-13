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
public class LoginModel extends BaseModel {

	private static LoginModel loginModel;

	private LoginModel() {
	}

	public static LoginModel getInstance() {
		if (loginModel == null) {
			loginModel = new LoginModel();
		}
		return loginModel;
	}

	public User authentication(User user) throws Exception {
		Connection conn = this.getConnection();
		User u = new User();
		String sql = "select * from users where email = ? and password = ?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getEmail());
			pstm.setString(2, user.getPassword());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				u.setUserId(rs.getInt("user_id"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setCreationDate(rs.getString("creation_date"));
			}
			conn.close();
		} catch (Exception e) {
		}
		return u;
	}

}
