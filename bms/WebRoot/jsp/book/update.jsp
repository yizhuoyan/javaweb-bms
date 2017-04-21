<%@page import="com.valentinalee.bms.vo.BookVO"%>
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

<title>修改图书</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/Calendar/Calendar.js"></script>

</head>

<body>
	<div class="nav">
		<a href="jsp/welcome.jsp">首页</a> <span>»</span><a
			href="student/query.do">图书管理</a> <span>»</span>修改图书
	</div>
	<form action="book/update.do" method="post">
		<input type="hidden" name="id" value="${book.id}" />
		<table>
			<tr>
				<td colspan="2" class="ac"><strong> ${message}</strong></td>
			</tr>
			<tr>
				<td class="label">图书名:</td>
				<td><input class="field" type="text" name="name" maxlength="6" value="${book.name}"/></td>
			</tr>
			<tr>
				<td class="label">图书ISBN号:</td>
				<td><input class="field" type="text"  name="isbn" maxlength="16" value="${book.ISBN}" /></td>
			</tr>

			<tr>
				<td class="label">图书作者:</td>
				<td><input class="field" type="text"  name="author" maxlength="10" value="${book.author}" /></td>
			</tr>
			<tr>
				<td class="label">图书出版社:</td>
				<td><input class="field" type="text"  name="publisher" maxlength="32" value="${book.publisher}" /></td>
			</tr>
			<tr>
				<td class="label">图书类型:</td>
				<td><input class="field" type="text"  name="bookType" maxlength="10" value="${book.bookType}" /></td>
			</tr>
			<tr>
				<td class="label">图书价格:</td>
				<td><input class="field" type="text"  name="price" maxlength="10" value="${book.price}" /></td>
			</tr>
			<tr>
				<td class="label">图书库存量:</td>
				<td><input class="field" type="text"  name="storeAmount " maxlength="10" value="${book.storeAmount}" /></td>
			</tr>
			<tr>
				<td class="label">图书副本数:</td>
				<td><input class="field" type="text"  name="leftAmount " maxlength="10" value="${book.leftAmount}" /></td>
			</tr>
			<tr>
				<td colspan="2" class="ac">
					<button type="submit">修改</button>
					<button type="reset">重置</button>
					<a class="btn" href="book/query.do">返回</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>