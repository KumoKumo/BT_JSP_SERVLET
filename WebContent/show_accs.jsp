<%@ include file="header.jsp"%>
<body>
	<div class="content">
		<div class="header">
			<img src="images/header.jpg">
		</div>
		<div class="body">
			<div class="show">
				<c:forEach items="${accs}" var="acc">
					${acc.username} 
					<form action="showprofile" method="post">
						<input type="hidden" name="id" value="${acc.id}"> 
						<input type="submit" value="show detail">
					</form>

					<form action="delacc" method="post">
						<input type="hidden" name="id" value="${acc.id}"> 
						<input type="submit" value="Delete">
					</form>

					<form action="edit.jsp" method="post">
						<input type="hidden" name="id" value="${acc.id}"> 
						<input
							type="hidden" name="username" value="${acc.username}"> 
							<input type="hidden" name="password" value="${acc.password}"> 
							<input type="submit" value="Edit">
					</form>
				</c:forEach>
				<br> 
				<a href="add_acc.jsp"><button>New Account</button></a>
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