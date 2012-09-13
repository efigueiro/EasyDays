package com.easydays.entity;

import java.io.Serializable;

public class Search implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyword;
	private String id;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
