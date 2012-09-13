package com.easydays.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.easydays.entity.Category;
import com.easydays.entity.User;
import com.easydays.model.CategoryModel;

/**
 * Classe responsável por manipular dados do banco.
 * 
 * @author Éverson Figueiró
 * @version 1.0
 */
public class CategoryController {

	private static CategoryController categoryController;

	private CategoryController() {
	}

	public static CategoryController getInstance() {
		if (categoryController == null) {
			categoryController = new CategoryController();
		}
		return categoryController;
	}

	public String create(Category category) throws Exception {
		if (StringUtils.isNotEmpty(CategoryModel.getInstance().retrieveByName(category.getName()).getName())) {
			return ("This name already exists, please choose another!");
		} else {
			return CategoryModel.getInstance().create(category);
		}
	}

	public List<Category> retrieveByFilter(String keyword, User authenticated) throws Exception {
		return CategoryModel.getInstance().retrieveByFilter(keyword, authenticated);
	}

	public List<Category> retrieveAll(User authenticated) throws Exception {
		return CategoryModel.getInstance().retrieveAll(authenticated);
	}

	public Category retrieveByCategoryId(int categoryId) throws Exception {
		return CategoryModel.getInstance().retrieveById(categoryId);
	}

	public Category retrieveByName(String name) throws Exception {
		return CategoryModel.getInstance().retrieveByName(name);
	}

	public String deleteById(int categoryId) throws Exception {
		return CategoryModel.getInstance().deleteById(categoryId);
	}

	public String update(Category category) throws Exception {
		return CategoryModel.getInstance().update(category);
	}

}
