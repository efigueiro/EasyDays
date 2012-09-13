package com.easydays.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.easydays.entity.Category;
import com.easydays.entity.Project;
import com.easydays.entity.User;
import com.easydays.model.CategoryModel;
import com.easydays.model.ProjectModel;

/**
 * Classe responsável por manipular dados do banco.
 * 
 * @author Éverson Figueiró
 * @version 1.0
 */
public class ProjectController {

	private static ProjectController projectController;

	private ProjectController() {
	}

	public static ProjectController getInstance() {
		if (projectController == null) {
			projectController = new ProjectController();
		}
		return projectController;
	}

	public String create(Project project) throws Exception {
		if (StringUtils.isNotEmpty(ProjectModel.getInstance().retrieveByName(project.getName()).getName())) {
			return ("This name already exists, please choose another!");
		} else {
			return ProjectModel.getInstance().create(project);
		}
	}

	public List<Project> retrieveByFilter(String keyword, User authenticated) throws Exception {
		return ProjectModel.getInstance().retrieveByFilter(keyword, authenticated);
	}

	public List<Project> retrieveAll(User authenticated) throws Exception {
		return ProjectModel.getInstance().retrieveAll(authenticated);
	}

	public Project retrieveByProjectId(int projectId) throws Exception {
		return ProjectModel.getInstance().retrieveById(projectId);
	}

	public Project retrieveByName(String name) throws Exception {
		return ProjectModel.getInstance().retrieveByName(name);
	}

	public String deleteById(int projectId) throws Exception {
		return ProjectModel.getInstance().deleteById(projectId);
	}

	public String update(Project project) throws Exception {
		return ProjectModel.getInstance().update(project);
	}

}
