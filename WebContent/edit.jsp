<%@ include file="header.jsp"%>
<body>
	<div class="content">
		<div class="header">
			<img src="images/header.jpg">
		</div>
		<div class="body">
			<div class="show">
				<form action="edit" method="post">
					<input type="hidden" name="id" value="${acc.id}"> 
					Username: <input id="edit_username" type="text" name="username" value="${acc.username}"><br>
					Password: <input id="edit_password" type="text" name="password" value="${acc.password}"><br> 
					Name: <input type="text" name="name" value="${prof.name}"><br> 
					Email: <input id="edit_email" type="text" name="email" value="${prof.email}"><br> 
					Address: <input type="text" name="address" value="${prof.address}"><br>
					Role: 	<select name="role">
  								<option value="1">Manager</option>
  								<option value="2">Normal Account</option>
							</select>
					<input type="submit">
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