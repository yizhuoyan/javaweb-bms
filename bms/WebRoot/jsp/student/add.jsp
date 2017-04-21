<%@page import="com.valentinalee.bms.vo.StudentVO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>添加学生</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="<%=path%>/js/calendar/WdatePicker.js"></script>
</head>

<body>
	<div class="nav">
		<a href="jsp/welcome.jsp">首页</a> <span>»</span><a
			href="student/query.do">学生管理</a> <span>»</span>添加学生
	</div>

	<form class="cu"  action="student/add.do" method="post">
		<table>
			<tr>
				<td colspan="2" align="center"><strong> ${message}fdf</strong></td>
			</tr>
			<tr>
				<td class="label">学号:</td>
				<td><input  type="text" name="no" maxlength="32" /></td>
			</tr>
			<tr>
				<td class="label">姓名:</td>
				<td><input  type="text" name="name" maxlength="10" /></td>
			</tr>

			<tr>
				<td class="label">性别:</td>
				<td><input type="radio" name="sex" value="男" checked="checked" />男
					<em class="ii"></em>
					<input type="radio" name="sex" value="女" />女
					</td>
			</tr>
			<tr>
				<td class="label">入学时间:</td>
				<td><input  class="Wdate"   type="text" name="enterDay" 
					onClick="WdatePicker({lang:'zh-cn'})" readonly="readonly"  /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">添加</button>
					<button class="mlr2" type="reset">重置</button>
					<a class="btn" href="student/query.do">返回</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
