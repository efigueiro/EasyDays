<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.easydays.entity.*"%>
<%@ page import="com.easydays.model.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<ul>
		<li><a href="<%=request.getContextPath()%>/modules/main.jsp">Main Page</a></li>
		<li><a href="<%=request.getContextPath()%>/modules/article/retrieveArticle.jsp">Articles</a></li>
		<li><a href="<%=request.getContextPath()%>/modules/task/createTask.jsp">Tasks</a></li>
		<li><a href="<%=request.getContextPath()%>/modules/category/retrieveCategory.jsp">Categories</a></li>
		<li><a href="<%=request.getContextPath()%>/modules/project/retrieveProject.jsp">Projects</a></li>
	</ul>
</body>
</html>