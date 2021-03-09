<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create a new list</title>
		<!--  Author:  Sterling Rhone
				Date:	   04Mar21-->
	</head>
	<body>
		<form action = "createNewListServlet" method="post">
			List Name: <input type ="text" name = "listName"><br />
			Lore Name: <input type = "text" name = "loreName"><br />
			Available Pets:<br />
			<select name="allPetsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allPets}" var="currentpet">
			<option value = "${currentpet.id}">${currentpet.owner} | ${currentpet.type} | ${currentpet.name}</option>
			</c:forEach>
			</select>
			<br />
			<input type = "submit" value="Create List and Add Pets">
		</form>
		<a href = "index.html">Go add new pets instead.</a>
	</body>
</html>