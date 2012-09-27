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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/table.css" type="text/css" />
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
<div id="wrap">

	<div id="top">
		<div class="rights"></div>
		<div id="search">
			<label class="labelEmail">${authenticated.email}  | </label>
			<a href="/EasyDays/login?action=logout" class="logout">logout</a>
		</div>
		<div class="lefts">
			<h1>Easy Days</h1>
			<h2>Organizador de tutoriais</h2>
		</div>
	</div>
	
	<div id="topmenu">
		<div class="rights"></div>
		<div class="lefts">
			<jsp:include page="../../fragments/menu.jsp" />
		</div>
	</div>
	
	<div id="main">
		<div id="rightside">
		<h2>Novos Artigos:</h2>
			<div class="box">
				<jsp:include page="../../fragments/articleList.jsp" />
			</div>
		</div>
		
		<div id="leftside">
		<h2>Busca de artigos:</h2>
			<form action="/EasyDays/retrieveArticle" method="post">
				<p>
					<label for="title">Keywords:</label> <input name="keyword" id="keyword" value="" type="text" style="width: 250px;" />
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
					<input name="retrieveArticle" style="width: 70px; margin-top:10px;" class="" value="Buscar" type="submit" />
				</p>
			</form>
			
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
	</div>
	
	<div id="footer">
		<div class="rside">&copy; Copyright 2012, <a href="http://www.free-css-templates.com">Easy Days</a> - <a href="http://www.free-css-templates.com/rss/">RSS Feed</a>   <br/>  Designed by <a href="http://www.free-css-templates.com/">Free CSS Templates</a>, Thanks to <a href="http://www.openwebdesign.org/">Website Design</a></div>
	</div>
</div>
	
</body>
</html>