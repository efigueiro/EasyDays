<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.easydays.entity.*"%>
<%@ page import="com.easydays.model.*"%>
<%@ page import="com.easydays.controller.*"%>
<%@ page import="com.easydays.util.PropertiesUtil"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><%=PropertiesUtil.getProperty("system.title")%></title>
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
			<a href="/EasyDays/login?action=logout" class="logout"><%=PropertiesUtil.getProperty("link.logoff")%></a>
		</div>
		<div class="lefts">
			<h1><%=PropertiesUtil.getProperty("system.title")%></h1>
			<h2><%=PropertiesUtil.getProperty("system.description")%></h2>
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
		<h2><%=PropertiesUtil.getProperty("page.retrieveArticle")%></h2>
			<form style="margin-top:30px; margin-left:20px;" action="/EasyDays/retrieveArticle" method="post">
				<ul style="list-style-type:none;">
				
					<li>${message}</li>
					<li><label for="title"><%=PropertiesUtil.getProperty("label.keyword")%></label></li>
					<li><input name="keyword" id="keyword" value="" type="text" class="input" /></li>
					
					<li style="margin-top:5px;"><label for="category"><%=PropertiesUtil.getProperty("label.category")%></label></li>
					<li>
						<select name="category" class="combo" >
							<option value="all"><%=PropertiesUtil.getProperty("label.categories")%></option>
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.categoryId}">${category.name}</option>
							</c:forEach>
						</select>
					</li>
					
					<li><input style="margin-top:15px;" name="retrieveArticle" value="<%=PropertiesUtil.getProperty("button.search")%>" type="submit" class="button" /></li>
				</ul>
			</form>
			
			<c:if test="${not empty articleList}">
				<table class="table" cellspacing="6">
					<tr>
						<th class="header"><%=PropertiesUtil.getProperty("label.title")%></th>
						<th class="header"><%=PropertiesUtil.getProperty("label.category")%></th>
						<th class="header"><%=PropertiesUtil.getProperty("label.date")%></th>
						<th class="header"><%=PropertiesUtil.getProperty("label.action")%></th>
					</tr>
					<c:forEach var="article" items="${articleList}">
						<tr>
							<td><a href="/EasyDays/showArticle?articleId=${article.articleId}" title="<%=PropertiesUtil.getProperty("tip.view")%>" >${article.title}</a></td>
							<td>${article.category.name}</td>
							<td>${article.creationDate}</td>
							<td>
								<a href="/EasyDays/updateArticle?articleId=${article.articleId}" title="<%=PropertiesUtil.getProperty("tip.edit")%>" ><img src="<%=request.getContextPath()%>/images/edit.png" border="0"></a>
								<a href="/EasyDays/deleteArticle?articleId=${article.articleId}" title="<%=PropertiesUtil.getProperty("tip.delete")%>" style="margin-left: 10px;" onclick="return deleteRecord()" ><img src="<%=request.getContextPath()%>/images/delete.png" border="0"></a>
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