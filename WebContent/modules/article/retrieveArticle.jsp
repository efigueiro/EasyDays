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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/util.js"></script>
</head>

<!-- scripts java -->
<%
	// Retrieve all categories for category combo box.
	List<Category> categoryList = new ArrayList<Category>();
	categoryList = CategoryController.getInstance().retrieveAll((User) request.getSession().getAttribute("authenticated"));
	request.setAttribute("categoryList", categoryList);
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
			<div id="content">
				<div id="toolBar">
					<a href="<%=request.getContextPath()%>/modules/article/createArticle.jsp">Add New Article</a>
				</div>
				<p>${message}</p>
				<fieldset>
					<legend>Search articles</legend>
					<form action="/EasyDays/retrieveArticle" method="post">
						<p>
							<label for="title">Keywords:</label> <input name="keyword" id="keyword"
								value="" type="text" style="width: 250px;" />
						</p>

						<p>
							<label for="category">Category:</label> 
							<select style="width: 262px;" name="category" >
								<option value="all">All categories</option>
								<c:forEach var="category" items="${categoryList}">
									<option value="${category.categoryId}">${category.name}</option>
								</c:forEach>
							</select>
						</p>

						<p>
							<input name="retrieveArticle" style="margin-left: 150px;"
								class="formbutton" value="Search" type="submit" />
						</p>
					</form>
				</fieldset>

				<c:if test="${not empty articleList}">
					<table cellspacing="0">
						<tr>
							<th>Title</th>
							<th>Category</th>
							<th>Date</th>
							<th>Action</th>
						</tr>
						<c:forEach var="article" items="${articleList}">
							<tr>
								<td><a href="/EasyDays/showArticle?articleId=${article.articleId}" title="Click to show article" >${article.title}</a></td>
								<td>${article.category.name}</td>
								<td>${article.creationDate}</td>
								<td>
									<a href="/EasyDays/updateArticle?articleId=${article.articleId}" title="Edit" ><img src="<%=request.getContextPath()%>/images/pencil.png" border="0"></a>
									<a href="/EasyDays/deleteArticle?articleId=${article.articleId}" title="Delete" onclick="return deleteRecord()" ><img src="<%=request.getContextPath()%>/images/delete.png" border="0"></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
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
