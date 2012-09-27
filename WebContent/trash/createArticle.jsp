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
<script type="text/javascript" src="<%=request.getContextPath()%>/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
tinyMCE.init({
        mode : "textareas"
});
</script>
</head>

<!-- scripts java -->
<%
	// Retrieve all categories for category combo box.
	List<Category> categoryList = new ArrayList<Category>();
	categoryList = CategoryController.getInstance().retrieveAll((User) request.getSession().getAttribute("authenticated"));
	request.setAttribute("categoryList", categoryList);
	
	// Warning for empty category list
	if(categoryList.isEmpty()){
		request.setAttribute("message", "You need add some category into category menu before create article!");
	}
%>
<!-- end scripts -->

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
			<div id="content" style="width: 890px;">
				<div id="toolBar" style="width: 890px;">
					<a href="<%=request.getContextPath()%>/modules/article/retrieveArticle.jsp">Search Article</a>
				</div>
				<p>${message}</p>
				<fieldset>
					<legend>Create article</legend>
					<form action="/EasyDays/createArticle" method="post">
						<p>
							<label for="title">Title:</label> <input name="title" id="title"
								value="" type="text" style="width: 250px;" />
						</p>

						<p>
							<label for="category">Category:</label> <select
								style="width: 262px;" name="category">
								<c:forEach var="category" items="${categoryList}">
									<option value="${category.categoryId}">${category.name}</option>
								</c:forEach>
							</select>
						</p>

						<p>
							<label for="articleBody">Body:</label>
							<textarea cols="80" rows="20" name="articleBody" id="articleBody"></textarea>
						</p>

						<p>
							<input name="createArticle" style="margin-left: 150px;"
								class="formbutton" value="Create Article" type="submit" />
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
