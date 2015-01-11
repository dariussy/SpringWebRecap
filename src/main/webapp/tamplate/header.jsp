<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Lobster|Open+Sans' rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/bootstrap-theme.css"/>'>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/css/style.css"/>'>


<title></title>
</head>
<body  class="container-fluid container">
<header class="row page-header">
<div id="logo" class="col-md-4">
	<a href="<c:url value="/index.jsp"/>" >
		<h1 >Site</h1>
		<h2>Web</h2>
	</a>
</div>
<div class="col-md-8">
	<nav>
		<ul  class="nav nav-pills nav-justified" role="tablist">
			<li   ><a href="<c:url value="/index.jsp"/>">Accueil</a></li>
			<li ><a href="<c:url value="/user/newUser.do"/>">New User</a></li>
				<li ><a href="<c:url value="/user/list.do"/>">list User</a></li>
				<li><a href='<c:url value="/j_spring_security_logout"/>'>logout : ${ userName }</a></li>
				<li  class="active" ><a href="<c:url value="/login.jsp"/>">Login</a></li>
		</ul>
	</nav>
</div>
</header>