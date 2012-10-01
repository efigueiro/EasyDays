<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.easydays.entity.*"%>
<%@ page import="com.easydays.model.*"%>
<%@ page import="com.easydays.controller.*"%>
<%@page import="com.easydays.util.PropertiesUtil"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<ul>
		<li><a href="<%=request.getContextPath()%>/modules/main.jsp"><%=PropertiesUtil.getProperty("menu.mainPage")%></a></li>
		<li><a href="<%=request.getContextPath()%>/modules/article/retrieveArticle.jsp"><%=PropertiesUtil.getProperty("menu.retrieveArticle")%></a></li>
		<li><a href="<%=request.getContextPath()%>/modules/article/createArticle.jsp"><%=PropertiesUtil.getProperty("menu.createArticle")%></a></li>
	</ul>
</body>
</html>