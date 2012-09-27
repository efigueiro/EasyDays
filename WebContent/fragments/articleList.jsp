<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.easydays.entity.*"%>
<%@ page import="com.easydays.model.*"%>
<%@ page import="com.easydays.controller.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>

<!-- scripts java -->
<%
	// Retrieve all articles by user
	List<Article> articleList = new ArrayList<Article>();
	articleList = ArticleController.getInstance().retrieveByUser((User) request.getSession().getAttribute("authenticated"));
	request.setAttribute("articleList", articleList);
%>
<!-- end scripts -->

<body>
	<form action="/EasyDays/main" method="get">
		<ul>
			<c:forEach var="article" items="${articleList}">
					<li><a href="/EasyDays/main?action=article &articleId=${article.articleId}" >${article.title}</a></li>
			</c:forEach>
		
			<c:if test="${empty articleList}">
		 		Records not found.
			</c:if>
		</ul>	
	</form>
</body>
</html>