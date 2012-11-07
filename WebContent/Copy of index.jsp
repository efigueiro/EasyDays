<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.easydays.entity.*"%>
<%@ page import="com.easydays.model.*"%>
<%@ page import="com.easydays.controller.*"%>
<%@ page import="com.easydays.util.Msg"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><%=Msg.getProperty("system.title")%></title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/input.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/combo.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/button.css" type="text/css" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>

<body>
	<div id="wrapper">
		<div id="headerwrap">
			<div id="header">
				<h1><%=Msg.getProperty("system.title")%></h1>
				<h2><%=Msg.getProperty("system.description")%></h2>
			</div>
		</div>

		<div id="navigationwrap">
			<div id="navigation">
				<p>This is the Menu</p>
			</div>
		</div>

		<div id="contentliquid">
			<div id="contentwrap">
				<div id="content" style="padding:35px; border:none;">
					<h2><%=Msg.getProperty("message.login")%></h2>
					<form style="margin-top:30px; margin-left:20px;" action="/EasyDays/login" method="post">
						<ul style="list-style-type:none;">
							<li>${loginMessage}</li>
					
							<li style="margin-top:5px;"><label for="email"><%=Msg.getProperty("label.email")%></label></li>
							<li><input name="email" id="email" value="" type="text" class="input"/></li>
					
							<li style="margin-top:5px;"><label for="password"><%=Msg.getProperty("label.password")%></label></li>
							<li><input name="password" id="password" value="" type="password" class="input" /></li>
					
							<li style="margin-top:15px;"><input name="enter" value="<%=Msg.getProperty("button.enter")%>" type="submit" class="button" /></li>
						</ul>
					</form>
				</div>
			</div>
		</div>
		
		<div id="leftcolumnwrap" style="display:none;">
			<div id="leftcolumn">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Integer nec odio. Praesent libero. Sed cursus ante dapibus diam.
					Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis
					ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta.
					Mauris massa. Vestibulum lacinia arcu eget nulla.</p>
			</div>
		</div>
		
		<div id="footerwrap">
			<div id="footer">
				<p>&copy; Copyright 2012, EasyDays</p>
			</div>
		</div>
	</div>
</body>
</html>
