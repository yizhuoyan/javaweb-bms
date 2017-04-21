<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>图书管理系统</title>
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script type="text/javascript" src="js/common.js"></script>
		<script type="text/javascript">
	window.onload = function() {
		$("@account")[0].focus();
		ifLoginFailed();
	};
	
</script>
	</head>

	<body>
		<div class="top">
			<h1 class="enName">
				BMS
			</h1>
			<h2 class="cnName">
				<span class="c">图书管理系统</span>
			</h2>
		</div>
		<div class="bottom">
			<form class="form" action="login.do" method="post">
				<br />
				<%
					Object message = request.getAttribute("message");
					if (message != null) {
				%>
				<h1 id="messageBox" class="strong"> <%=message%> </h1>
				<%
					}
				%>
				<br />
				<div>
					账号：
					<input type="text" name="account">
					<em class="i"></em>密码：
					<input class="text" type="password" name="password">
				</div>
				<br />
				<button style="width: 200px" type="submit">
					登 录
				</button>
			</form>
		</div>

		<div class="copyright">
			@2000-2013 
		</div>
	</body>
</html>
