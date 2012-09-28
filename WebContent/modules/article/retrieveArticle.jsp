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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/combo.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/button.css" type="text/css" />
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
			<a href="/EasyDays/login?action=logout" class="logout">Sair</a>
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
		</div>
		
		<div id="leftside">
		<h2>Busca de artigos:</h2>
			<form style="margin-top:30px; margin-left:20px;" action="/EasyDays/retrieveArticle" method="post">
				<ul style="list-style-type:none;">
					<li><label for="title">Palavra-Chave:</label></li>
					<li><input name="keyword" id="keyword" value="" type="text" class="input" /></li>
					
					<li style="margin-top:5px;"><label for="category">Categoria:</label></li>
					<li>
						<select name="category" class="combo" >
							<option value="all">Todas categorias</option>
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.categoryId}">${category.name}</option>
							</c:forEach>
						</select>
					</li>
					
					<li><input style="margin-top:15px;" name="retrieveArticle" value="Buscar" type="submit" class="button" /></li>
				</ul>
			</form>
			
			<c:if test="${not empty articleList}">
				<table class="table" cellspacing="6">
					<tr>
						<th class="header">Title</th>
						<th class="header">Category</th>
						<th class="header">Date</th>
						<th class="header">Action</th>
					</tr>
					<c:forEach var="article" items="${articleList}">
						<tr>
							<td><a href="/EasyDays/showArticle?articleId=${article.articleId}" title="Clique para visualizar artigo" >${article.title}</a></td>
							<td>${article.category.name}</td>
							<td>${article.creationDate}</td>
							<td>
								<a href="/EasyDays/updateArticle?articleId=${article.articleId}" title="Editar" ><img src="<%=request.getContextPath()%>/images/edit.png" border="0"></a>
								<a href="/EasyDays/deleteArticle?articleId=${article.articleId}" title="Excluir" style="margin-left: 10px;" onclick="return deleteRecord()" ><img src="<%=request.getContextPath()%>/images/delete.png" border="0"></a>
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