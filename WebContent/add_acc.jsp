<%@ include file="header.jsp"%>

<body>
	<div class="content">
		<div class="header">
			<img src="images/header.jpg">
		</div>
		<div class="body">
			<div class="show">
				<form id="add_form" action="add" method="post">
					<div id=username_div>
						<label for="username">Username</label>
						<input id="add_username" type="text" name="username"><br>
					</div>
					<div id="password_div">
						<label for="password">Password</label>
						<input id="add_password" type="text" name="password"><br>
					</div>
					<label for="role">Role</label> 
							<select name="role">
  								<option value="1">Manager</option>
  								<option value="2">Normal Account</option>
							</select>
					<br>
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