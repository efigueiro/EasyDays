<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Easy Days</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/input.css" type="text/css" />
</head>

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
			<jsp:include page="../fragments/menu.jsp" />
		</div>
	</div>
	
	<div id="main">
		<div id="rightside">
		<h2>Novos Artigos:</h2>
			<div class="box">
				<jsp:include page="../fragments/articleList.jsp" />
			</div>
		</div>
		
		<div id="leftside">
			<p>${message}</p>
			<h2>${selectedArticle.title}</h2>
			${selectedArticle.articleBody}
		</div>
	</div>
	
	<div id="footer">
		<div class="rside">&copy; Copyright 2012, <a href="http://www.free-css-templates.com">Easy Days</a> - <a href="http://www.free-css-templates.com/rss/">RSS Feed</a>   <br/>  Designed by <a href="http://www.free-css-templates.com/">Free CSS Templates</a>, Thanks to <a href="http://www.openwebdesign.org/">Website Design</a></div>
	</div>
</div>
	
</body>
</html>