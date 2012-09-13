package com.easydays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.easydays.entity.Category;
import com.easydays.entity.Project;
import com.easydays.entity.User;

/**
 * Classe responsável por manipular dados do banco.
 * 
 * @author Éverson Figueiró
 * @version 1.0
 */
public class ProjectModel extends BaseModel {

	private static ProjectModel projectModel;

	private ProjectModel() {
	}

	public static ProjectModel getInstance() {
		if (projectModel == null) {
			projectModel = new ProjectModel();
		}
		return projectModel;
	}

	public String create(Project project) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "insert into project(name, description, creation_date, user_id)" + "values(?,?,?,?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, project.getName());
			pstm.setString(2, project.getDescription());
			pstm.setString(3, project.getCreationDate());
			pstm.setInt(4, project.getUser().getUserId());
			pstm.execute();
			pstm.close();
			conn.close();

			message = "Project created!";
		} catch (Exception e) {
			message = e + " The system encountered problems to perform this action!";
			conn.close();
		}
		return message;
	}

	public Project retrieveById(int projectId) throws Exception {
		Connection conn = this.getConnection();
		Project selectedProject = new Project();
		String sql = "select * from project where project_id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, projectId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				selectedProject.setProjectId(rs.getInt("project_id"));
				selectedProject.setCreationDate(rs.getString("creation_date"));
				selectedProject.setDescription(rs.getString("description"));
				selectedProject.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return selectedProject;
	}

	public Project retrieveByName(String name) throws Exception {
		Connection conn = this.getConnection();
		Project selectedProject = new Project();
		String sql = "select * from project where name = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				selectedProject.setProjectId(rs.getInt("project_id"));
				selectedProject.setCreationDate(rs.getString("creation_date"));
				selectedProject.setDescription(rs.getString("description"));
				selectedProject.setName(rs.getString("name"));
			}
			rs.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {

		}
		return selectedProject;
	}

	public String deleteById(int projectId) throws Exception {
		Connection conn = this.getConnection();
		String sql = "delete from project where project_id = ?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, projectId);
			pstm.execute();
			return "Deleted!";
		} catch (Exception e) {
			conn.close();
		}
		return null;
	}

	public List<Project> retrieveAll(User authenticated) throws Exception {
		Connection conn = this.getConnection();
		List<Project> projectList = new ArrayList<Project>();
		String sql = "select * from project where user_id = ? order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, authenticated.getUserId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Project project = new Project();
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				project.setProjectId(rs.getInt("project_id"));
				project.setCreationDate(rs.getString("creation_date"));
				project.setDescription(rs.getString("description"));
				project.setName(rs.getString("name"));
				project.setUser(user);
				projectList.add(project);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return projectList;
	}

	public List<Project> retrieveByFilter(String keyword, User authenticated) throws Exception {
		Connection conn = this.getConnection();
		List<Project> projectList = new ArrayList<Project>();
		String sql = "select * from project where name ilike ?" + "and user_id = ? order by name";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + keyword + "%");
			pstm.setInt(2, authenticated.getUserId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Project project = new Project();
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				project.setUser(user);
				project.setProjectId(rs.getInt("project_id"));
				project.setCreationDate(rs.getString("creation_date"));
				project.setDescription(rs.getString("description"));
				project.setName(rs.getString("name"));
				projectList.add(project);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.close();
		}
		return projectList;
	}

	public String update(Project project) throws Exception {
		String message = "";
		Connection conn = this.getConnection();
		String sql = "update project set project_id=?, creation_date=?, description=?, name=?" + "where project_id=?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, project.getProjectId());
			pstm.setString(2, project.getCreationDate());
			pstm.setString(3, project.getDescription());
			pstm.setString(4, project.getName());
			pstm.setInt(5, project.getProjectId());
			pstm.execute();
			pstm.close();
			conn.close();

			message = "Project updated!";
		} catch (Exception e) {
			message = e + " The system encountered problems to perform this action!";
			conn.close();
		}
		return message;
	}

}
