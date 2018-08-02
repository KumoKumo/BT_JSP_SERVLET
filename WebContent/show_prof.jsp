<%@ include file="header.jsp"%>

<body>
	<div class="content">
		<div class="header">
			<img src="images/header.jpg">
		</div>
		<div class="body">
			<div class="show">
				<c:choose>
					<c:when test="${prof.status == 1}">
    					${prof.name } +${prof.email } +${prof.address }  <br>
					</c:when>
					<c:otherwise>
        				No info.
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