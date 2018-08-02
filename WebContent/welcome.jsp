<%@ include file="header.jsp"%>

<body>
	<div class="content">
		<div class="header">
			<img src="images/header.jpg">
		</div>
		<div class="body">
			<div class="show">
				<p>Welcome!! ${userAcc.username}</p>
			</div>
			<div class="menu">
				<ul>
					<li><a class="active" href="welcome.jsp">WELCOME</a></li>
					<li><a href="showacc">LIST</a></li>
					<li><a href="logOut">Log Out</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>