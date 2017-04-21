<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<script type="text/javascript" src="js/common.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<style type="text/css">

</style>
	</head>
	<body class="layoutv">
		<div class="head">
			<div class="logoBox">
				<h1>
					BMS
				</h1>
				<h2>
					图书管理系统
				</h2>
			</div>
			<div class="quickLinks">
				欢迎您
				<a href="#"><b> ${sessionScope.currentManager.name} </b> </a>
				<span>┇</span>
				<a href="jsp/manager/update.jsp">修改密码</a>
				<span>┇</span>
				<a href="javascript:">帮助</a>
				<span>┇</span>
				<a href="logout.do">退出</a>
			</div>
		</div>

		<div class="body" style="top: 5em; bottom: 0">
			<div class="layouth">
				<div class="left menu" style="width: 150px">
					<ul id="menu">
						<li url="student/query.do">
							<strong>✧</strong>学生管理
						</li>
						<li url="book/query.do">
							<strong>✧</strong>图书管理
						</li>
						<li url="borrow/queryStudent.do">
							<strong>✧</strong>借阅登记
						</li>
						<li url="borrow/queryStudent.do">
							<strong>✧</strong>归还
						</li>
						<li url="borrow/queryStudent.do">
							<strong>✧</strong>借阅查询
						</li>
					</ul>
				</div>
				<div class="right" style="left:150px">
					<div class="frameBox">
						<iframe id="mainFrame" width="100%" height="100%" src="jsp/welcome.jsp"
							frameborder="0" name="mainFrame"></iframe>
					</div>
				</div>
			</div>
		</div>

	</body>
</html>