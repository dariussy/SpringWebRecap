<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Users</title>
</head>
<body>
	<h1>nbUsers: ${nbUsers}</h1>
	<table>
		<tr>
			<c:forEach items="${users}" var="u">

				<td>${u.id}</td>
				<td>${u.firstname}</td>
				<td>${u.lastname}</td>
				<td>${u.login}</td>
				<td>${u.email}</td>

			</c:forEach>
		</tr>
	</table>

</body>
</html>