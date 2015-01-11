<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<jsp:include page="/tamplate/header.jsp">
	<jsp:param value="Login Page" name="title" />
</jsp:include>

<section>
	<%-- 	<div class="container-fluid container">
		<div class="col-md-12">
			<form action="j_spring_security_check" method="POST">

				<div class="form-group ">
					<label for="username">Username : </label> <input type="text"
						name="j_username" class="form-control" id="username"
						placeholder="username" />
				</div>
				<div class="form-group ">
					<label for="password">Password : </label> <input type="password"
						name="j_password" class="form-control" id="password"
						placeholder="password" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div> --%>





	<div class="container">

		<form class="form-signin" action="j_spring_security_check"
			method="POST" role="form">
			<h2 class="form-signin-heading">Please sign in</h2>

			<div class="form-group ">
				<label for="username">User : </label> <input class="form-control"
					placeholder="username" id="username" name="username" type="text">
			</div>

			<div class="form-group ">
				<label for="password">Password : </label> <input
					class="form-control" placeholder="Password" id="password"
					name="password" type="password">
			</div>
			<div class="form-group ">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Connection</button>
			</div>
			<div class="form-group ">
				<a href="<c:url value="/createUser.do"/>"
					title="Creation Utilisateur">
					<button type="button" class="btn btn-primary btn-xs">
					<span class="glyphicon glyphicon-plus"></span> NewUser</button>
				</a>
			</div>
		</form>
	</div>


</section>

<jsp:include page="/tamplate/footer.jsp"/>
