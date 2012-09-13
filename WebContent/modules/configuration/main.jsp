<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Easy Days - Task control</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/input.css" type="text/css" />
</head>

<body>
<div id="container">
	<div id="header">
		<a href="/EasyDays/login?action=logout" class="logout">logout</a>
		<label class="labelEmail">${authenticated.email}  | </label>
    	<h1><a href="/">Easy Days</a></h1>
        <h2>Task control</h2>
        <div class="clear"></div>
    </div>
    
    <div id="nav">
    	<jsp:include page="../../fragments/menu.jsp" />
    </div>
    
    <div id="body">
    	
        
        <div class="sidebar" style="float:left;">
            <ul>	
               <li>
               		<h4><span>Category for articles</span></h4>
               		<ul class="blocklist">
                        <li><a href="<%=request.getContextPath()%>/modules/configuration/retrieveCategory.jsp">Search/Edit/Delete</a></li>
						<li><a href="<%=request.getContextPath()%>/modules/configuration/createCategory.jsp">Create a new category</a></li>
                    </ul>
                    
                    <br />
                    
                    <h4><span>Project</span></h4>
               		<ul class="blocklist">
                        <li><a href="<%=request.getContextPath()%>/modules/configuration/retrieveCategory.jsp">Search/Edit/Delete</a></li>
						<li><a href="<%=request.getContextPath()%>/modules/configuration/retrieveCategory.jsp">Create a new project</a></li>
                    </ul>
                    
                    <br/>
                    
               </li>
            </ul> 
        </div>
        
    	<div class="clear"></div>
    </div>

    <div id="footer">
        <div class="footer-content">
			<p>&copy; YourSite 2010. Design by <a href="http://www.spyka.net">Free CSS Templates</a> | <a href="http://www.justfreetemplates.com">Free Web Templates</a></p>
		</div>
    </div>
</div>
</body>
</html>
