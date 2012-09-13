<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.easydays.entity.*"%>
<%@ page import="com.easydays.model.*"%>
<%@ page import="com.easydays.controller.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Easy Days - Task control</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/input.css" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/util.js"></script>
</head>

<body>
	<div id="container">
		<div id="header">
			<a href="/EasyDays/login?action=logout" class="logout">logout</a>
			<label class="labelEmail">${authenticated.email}  | </label>
    		<h1><a href="/">Easy Days</a></h1>
        	<div class="clear"></div>
		</div>
		<div id="nav">
			<jsp:include page="../../fragments/menu.jsp" />
		</div>
		<div id="body">
			<div id="content">
				<div id="toolBar">
					<a href="<%=request.getContextPath()%>/modules/project/createProject.jsp">Add New Project</a>
				</div>
				<p>${message}</p>
				<fieldset>
					<legend>Search project</legend>
					<form action="/EasyDays/retrieveProject" method="post">
						<p>
							<label for="keyword">Keywords:</label> <input name="keyword" id="keyword"
								value="" type="text" style="width: 250px;" />
						</p>

						<p>
							<input name="retrieveProject" style="margin-left: 150px;"
								class="formbutton" value="Search" type="submit" />
						</p>
					</form>
				</fieldset>

				<c:if test="${not empty projectList}">
					<table cellspacing="0">
						<tr>
							<th>Name</th>
							<th>Description</th>
							<th>Date</th>
							<th>Action</th>
						</tr>
						<c:forEach var="project" items="${projectList}">
							<tr>
								<td>${project.name}</td>
								<td>${project.description}</td>
								<td>${project.creationDate}</td>
								<td>
									<a href="/EasyDays/updateProject?projectId=${project.projectId}" title="Edit" ><img src="<%=request.getContextPath()%>/images/pencil.png" border="0"></a>
									<a href="/EasyDays/deleteProject?projectId=${project.projectId}" title="Delete" onclick="return deleteRecord()" ><img src="<%=request.getContextPath()%>/images/delete.png" border="0"></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
			<div class="clear"></div>
		</div>

		<div id="footer">
			<div class="footer-content">
				<p>
					&copy; YourSite 2010. Design by <a href="http://www.spyka.net">Free
						CSS Templates</a> | <a href="http://www.justfreetemplates.com">Free
						Web Templates</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
