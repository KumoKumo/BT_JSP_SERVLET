<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css/style.css" rel="stylesheet">
<link href="css/button.css" rel="stylesheet">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="Cache-Control"
		content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<script src="javascript/jquery-3.2.1.js"></script>
	<script src="javascript/others.js"></script>
	<title>Kotori no Kusuri</title>
</head>
<body>
	<c:if test='${empty sessionScope["userAcc"]}'>
		<c:redirect url="login.jsp" />
	</c:if>
	<div class="background-image"></div>
</body>
</html>