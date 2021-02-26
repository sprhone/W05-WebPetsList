<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Oh, you want to edit a pet...</title>
		<!--  Author:  Sterling Rhone
				Date:	   25Feb21-->
	</head>
	<body>
		<form action = "editPetServlet" method="post">
		Owner: <input type ="text" name = "owner" value = "${petToEdit.owner}">
		Type: <input type = "text" name = "type" value = "${petToEdit.type}">
		Name: <input type ="text" name = "name" value = "${petToEdit.name}">
		<input type = "hidden" name = "id" value="${petToEdit.id}">
		<input type = "submit" value="Save Edited Pet">
		</form>
	</body>
</html>