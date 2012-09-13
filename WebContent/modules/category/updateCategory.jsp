<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.easydays.entity.*"%>
<%@ page import="com.easydays.model.*"%>
<%@ page import="com.easydays.controller.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Easy Days</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/input.css" type="text/css" />
</head>

<body>
	<div id="container">
		<div id="header">
			<a href="/EasyDays/login?action=logout" class="logout">logout</a>
			<label class="labelEmail">${authenticated.email}  | </label>
    		<h1><a href="/">Easy Days</a></h1>
        	<div class="clear"></div>
		</div>
		<div id="nav">
			<jsp:include page="../../fragments/menu.jsp" />
		</div>
		<div id="body">
			<div id="content">
				<div id="toolBar">
					<a href="<%=request.getContextPath()%>/modules/category/retrieveCategory.jsp">Return</a>
				</div>
				<p>${message}</p>
				<fieldset>
					<legend>Update category</legend>
					<form action="/EasyDays/updateCategory" method="post">
						<p>
							 <input name="categoryId" id="categoryId" value="${selectedCategory.categoryId}" type="hidden" style="width: 250px;" />
						</p>
					
						<p>
							<label for="name">Name:</label> <input name="name" id="name"
								value="${selectedCategory.name}" type="text" style="width: 250px;" />
						</p>

						<p>
							<label for="description">Description:</label>
							<textarea cols="47" rows="11" name="description" id="description">${selectedCategory.description}</textarea>
						</p>

						<p>
							<input name="saveArticle" style="margin-left: 150px;"
								class="formbutton" value="Save Article" type="submit" />
						</p>
					</form>
				</fieldset>
			</div>
			<div class="clear"></div>
		</div>

		<div id="footer">
			<div class="footer-content">
				<p>
					&copy; YourSite 2010. Design by <a href="http://www.spyka.net">Free
						CSS Templates</a> | <a href="http://www.justfreetemplates.com">Free
						Web Templates</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
