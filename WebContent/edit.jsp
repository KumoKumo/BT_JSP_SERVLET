<%@ include file="header.jsp"%>
<body>
	<c:set var="id" value="${param.id}"></c:set>
	<div class="content">
		<div class="header">
			<img src="images/header.jpg">
		</div>
		<div class="body">
			<div class="show">
				<form action="edit" method="post">
					<input type="hidden" name="id" value="${id}"> 
					Username: <input type="text" name="username" value="${param.username}"><br>
					Password: <input type="text" name="password" value="${param.password}"><br> 
					Name: <input type="text" name="name"><br> 
					Email: <input type="text" name="email"><br> 
					Address: <input type="text" name="address"><br> <input type="submit">
				</form>
			</div>
			<div class="menu">
				<ul>
					<li><a href="welcome.jsp">WELCOME</a></li>
					<li><a class="active" href="showacc">LIST</a></li>
					<li><a href="logOut">Log Out</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>