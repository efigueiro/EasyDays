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
<div id="container">
	<div id="header">
    	<h1><a href="/">Easy Days</a></h1>
        <div class="clear"></div>
    </div>
    
    <div id="body">
		<div id="content" style="float:left;">
			<p>${loginMessage}</p>
			<fieldset>
                <legend>Login</legend>
                <form action="/EasyDays/login" method="post">
                    <p>
                    	<label for="email">Email:</label> 
                    	<input name="email" id="email" value="" type="text" style="width:250px;"/>
                    </p>
                    <p>
                    	<label for="password">Password:</label> 
                    	<input name="password" id="password" value="" type="password" style="width:250px;" />
                    </p>
                    <p>
						<input name="enter" style="margin-left: 150px;" class="formbutton" value="Enter" type="submit" />
					</p>
                </form>
            </fieldset>
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
