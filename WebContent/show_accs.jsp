<%@ include file="header.jsp"%>
<body>
	<div class="content">
		<div class="header">
			<img src="images/header.jpg">
		</div>
		<div class="body">
			<div class="show">
				<form action="search">
				Search :
					<input type="text" name="key"> 
					<input type = "submit" value="SEARCH">
				</form>
				<br>
				<c:choose>
					<c:when test="${userAcc.status == 1 }">
						<a href="add_acc.jsp"><button class = "button">New Account</button></a>
						<br>
						<table>
							<tr>
								<th>Username</th>
								<th>Role</th>
								<th>Action</th>
							</tr>
							<c:forEach items="${accs}" var="acc">
								<tr>
									<td>
										<c:out value="${acc.username}"></c:out>
									</td>
									<td>
										<c:choose>
											<c:when test="${acc.status == 1}">
												Manager
											</c:when>
											<c:otherwise>
												Normal Account
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<form class="inner" action="showprofile" method="post">
											<input type="hidden" name="id" value="${acc.id}">
											<input type="submit" value="Show Profile">
										</form>
	
										<form id="del"+${acc.id} class="inner" action="delacc" method="post">
											<input type="hidden" name="id" value="${acc.id}">
											<input type="submit" value="Delete">
										</form>
	
										<form class="inner" action="edit" method="get">
											<input type="hidden" name="id" value="${acc.id}">
											<input type="submit" value="Edit">
										</form>
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<table>
							<tr>
								<th>Username</th>
								<th>Role</th>
								<th>Action</th>
							</tr>
							<c:forEach items="${accs}" var="acc">
								<tr>
									<td>${acc.username}</td>
									<td>
										<c:choose>
											<c:when test="${acc.status == 1}">
												Manager
											</c:when>
											<c:otherwise>
												Normal Account
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<form action="showprofile" method="post">
											<input type="hidden" name="id" value="${acc.id}">
											<input type="submit" value="Show Profile">
										</form>
									</td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
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