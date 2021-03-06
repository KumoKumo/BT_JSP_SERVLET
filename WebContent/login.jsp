<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css/login.css" rel="stylesheet">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="javascript/jquery-3.2.1.js"></script>
	<script src="javascript/login.js"></script>
	<title>Kotori no Kusuri</title>
</head>
<body>
	<c:if test='${not empty sessionScope["userAcc"]}'>
		<c:redirect url="welcome.jsp" />
	</c:if>
	<div class="background-image"></div>
	<div class="content">
		<div class="header">
			<!-- <br /><br /><p class="logo">Database System</p> -->
		</div>
		<form id="loginForm" action="login" method="post">
			<div id=username_div>
				<label class="blah" for="username">Username</label>
				<input id="username" class="blah input_txt" type="text" name="username"><br>
			</div>
			<div id="password_div">
				<label class="blah" for="password">Password</label>
				<input id="password" class="blah input_txt" type="password" name="password"><br>
			</div>
			<input id="submit" class="form-submit-button blah" type="submit" value="Log in">
		</form>
	</div>
</body>
</html>