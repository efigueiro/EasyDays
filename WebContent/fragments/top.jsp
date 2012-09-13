<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.easydays.entity.*"%>
<%@ page import="com.easydays.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<p><a href="http://www.free-css.com/">Home</a><a href="http://www.free-css.com/">About</a><a href="http://www.free-css.com/">Archive</a><a href="http://www.free-css.com/">Sitemap</a></p>
    <form id="search_engine" method="post" action="http://www.free-css.com/" accept-charset="UTF-8">
      <p>
        <input class="searchfield" name="search_query" type="text" id="keywords" value="Search Keywords" onfocus="document.forms['search_engine'].keywords.value='';" onblur="if (document.forms['search_engine'].keywords.value == '') document.forms['search_engine'].keywords.value='Search Keywords';" />
        <input class="searchbutton" name="submit" type="submit" value="Search" />
      </p>
    </form>
</body>
</html>