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
</head>

<body>
<div id="wrap">

	<div id="top">
		<div class="rights"></div>
		<div id="search"></div>
		<div class="lefts">
			<h1><%=PropertiesUtil.getProperty("system.title")%></h1>
			<h2><%=PropertiesUtil.getProperty("system.description")%></h2>
		</div>
	</div>
	
	<div id="topmenu">
		<div class="rights"></div>
		<div class="lefts">
			<ul>
			</ul>
		</div>
	</div>
	
	<div id="main">
		<div id="rightside">
		</div>
		
		<div id="leftside">
			<h2><%=PropertiesUtil.getProperty("message.login")%></h2>
			<form style="margin-top:30px; margin-left:20px;" action="/EasyDays/login" method="post">
				<ul style="list-style-type:none;">
					<li>${loginMessage}</li>
					
					<li style="margin-top:5px;"><label for="email"><%=PropertiesUtil.getProperty("label.email")%></label></li>
					<li><input name="email" id="email" value="" type="text" class="input"/></li>
					
					<li style="margin-top:5px;"><label for="password"><%=PropertiesUtil.getProperty("label.password")%></label></li>
					<li><input name="password" id="password" value="" type="password" class="input" /></li>
					
					<li style="margin-top:15px;"><input name="enter" value="<%=PropertiesUtil.getProperty("button.enter")%>" type="submit" class="button" /></li>
				</ul>
			</form>
		</div>
	</div>
	
	<div id="footer">
		<div class="rside">&copy; Copyright 2012, <a href="http://www.free-css-templates.com">Easy Days</a> - <a href="http://www.free-css-templates.com/rss/">RSS Feed</a>   <br/>  Designed by <a href="http://www.free-css-templates.com/">Free CSS Templates</a>, Thanks to <a href="http://www.openwebdesign.org/">Website Design</a></div>
	</div>
</div>
	
</body>
</html>