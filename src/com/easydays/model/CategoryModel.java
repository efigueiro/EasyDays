package com.easydays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.easydays.entity.Category;
import com.easydays.entity.User;

/**
 * Classe responsável por manipular dados do banco.
 * 
 * @author Éverson Figueiró
 * @version 1.0
 */
public class CategoryModel extends BaseModel {

	private static CategoryModel categoryModel;

	private CategoryModel() {
	}

	public static CategoryModel getInstance() {
		if (categoryModel == null) {
			categoryModel = new CategoryModel();
		}
		return categoryModel;
	}

	public String create(Category category) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into category(name, description, creation_date, user_id)" + "values(?,?,?,?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, category.getName());
			pstm.setString(2, category.getDescription());
			pstm.setString(3, category.getCreationDate());
			pstm.setInt(4, category.getUser().getUserId());
			pstm.execute();
			pstm.close();
			conn.close();

			message = "Category created!";
		} catch (Exception e) {
			message = e + " The system encountered problems to perform this action!";
			conn.close();
		}
		return message;
	}

	public Category retrieveById(int categoryId) throws Exception {
		Connection conn = this.getConnection();
		Category selectedCategory = new Category();
		String sql = "select * from category where category_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, categoryId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				selectedCategory.setCategoryId(rs.getInt("category_id"));
				selectedCategory.setCreationDate(rs.getString("creation_date"));
				selectedCategory.setDescription(rs.getString("description"));
				selectedCategory.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return selectedCategory;
	}

	public Category retrieveByName(String name) throws Exception {
		Connection conn = this.getConnection();
		Category selectedCategory = new Category();
		String sql = "select * from category where name = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				selectedCategory.setCategoryId(rs.getInt("category_id"));
				selectedCategory.setCreationDate(rs.getString("creation_date"));
				selectedCategory.setDescription(rs.getString("description"));
				selectedCategory.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return selectedCategory;
	}

	public String deleteById(int categoryId) throws Exception {
		Connection conn = this.getConnection();
		String sql = "delete from category where category_id = ?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, categoryId);
			pstm.execute();
			return "Deleted!";
		} catch (Exception e) {
			conn.close();
		}
		return null;
	}

	public List<Category> retrieveAll(User authenticated) throws Exception {
		Connection conn = this.getConnection();
		List<Category> categoryList = new ArrayList<Category>();
		String sql = "select * from category where user_id = ? order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, authenticated.getUserId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				category.setCategoryId(rs.getInt("category_id"));
				category.setCreationDate(rs.getString("creation_date"));
				category.setDescription(rs.getString("description"));
				category.setName(rs.getString("name"));
				category.setUser(user);
				categoryList.add(category);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return categoryList;
	}

	public List<Category> retrieveByFilter(String keyword, User authenticated) throws Exception {
		Connection conn = this.getConnection();
		List<Category> categoryList = new ArrayList<Category>();
		String sql = "select * from category where name ilike ?" + "and user_id = ? order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + keyword + "%");
			pstm.setInt(2, authenticated.getUserId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				category.setUser(user);
				category.setCategoryId(rs.getInt("category_id"));
				category.setCreationDate(rs.getString("creation_date"));
				category.setDescription(rs.getString("description"));
				category.setName(rs.getString("name"));
				categoryList.add(category);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return categoryList;
	}

	public String update(Category category) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "update category set category_id=?, creation_date=?, description=?, name=?" + "where category_id=?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, category.getCategoryId());
			pstm.setString(2, category.getCreationDate());
			pstm.setString(3, category.getDescription());
			pstm.setString(4, category.getName());
			pstm.setInt(5, category.getCategoryId());
			pstm.execute();
			pstm.close();
			conn.close();

			message = "Category updated!";
		} catch (Exception e) {
			message = e + " The system encountered problems to perform this action!";
			conn.close();
		}
		return message;
	}

}
