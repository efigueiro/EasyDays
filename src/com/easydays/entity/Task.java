package com.easydays.entity;

import java.io.Serializable;

public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int taskId;
	private String title;
	private String note;
	private String status;
	private String creationDate;
	private String targetDate;
	private Project project;

	
	
}
