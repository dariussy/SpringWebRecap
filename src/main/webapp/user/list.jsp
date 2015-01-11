
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<jsp:include page="/tamplate/header.jsp">
	<jsp:param value="Login Page" name="title" />
</jsp:include>

<section>
	<h1>nbUsers: ${nbUsers}</h1>
	<table>
		<c:forEach items="${users}" var="u">
			<tr>

				<td>${u.id}</td>
				<td>${u.firstname}</td>
				<td>${u.lastname}</td>
				<td>${u.login}</td>
				<td>${u.email}</td>
				<td><a href="editUser.do?UserId=${u.id}">edit</a></td>
			</tr>

		</c:forEach>
	</table>
</section>


<jsp:include page="/tamplate/footer.jsp"/>
