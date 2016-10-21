<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>
    <title>All</title>
</head>
<body>
<c:url var="logout" value="/logout" />
<c:url var="domains" value="/domain/all/1" />
<c:url var="users" value="/user/all/1" />
<c:url var="login" value="/loginpage" />
<div class="container">
  <div class="page-header">
    <h1>Domain List</h1>
    <sec:authorize access="isAuthenticated()">
		<a href="${logout}" class="btn btn-default">LogOut</a>
	</sec:authorize>
	<a href="${domains}" class="btn btn-success">Domains</a>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">		
		<a href="${users}" class="btn btn-success">All users</a>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<a href="${login}" class="btn btn-success">Login</a>
	</sec:authorize>
	
  </div>
</div>
</body>
</html>