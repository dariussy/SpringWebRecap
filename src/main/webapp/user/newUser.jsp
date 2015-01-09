<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New User</title>
</head>
<body>

	<h2 class="form-signin-heading">Edit and Create User</h2>
	<form:form commandName="user" action="saveUser.do">
		<form:hidden path="id"/>
		<div>
			<label for="firstname">Prenom</label>
			<form:input type="text" path="firstname" id="firstname" value=""
				placeholder="john" />
			<form:errors path="firstname" />
		</div>
		<div>
			<label for="lastname">Nom</label>
			<form:input type="text" path="lastname" id="lastname" value=""
				placeholder="DOE" />
			<form:errors path="lastname" />
		</div>
		<div>
			<label for="email">email</label>
			<form:input type="email" path="email" id="email" value=""
				placeholder="mail@mail.com" />
			<form:errors path="email" />
		</div>
		<div>
			<label for="login">login</label>
			<form:input type="text" path="login" id="login" value=""
				placeholder="login" />
			<form:errors path="login" />
		</div>
		<div>
			<label for="password">password</label>
			<form:input type="password" path="password" id="password" value=""
				placeholder="password" />
			<form:errors path="password" />
		</div>
		<div>
			<button type="submit">Create</button>
		</div>
	</form:form>

</body>
</html>