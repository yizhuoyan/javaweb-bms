<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%
		Object message=request.getAttribute("message");
		if(message!=null){
	%>
	<strong> <%=message%> </strong>
	<%	
		}
	%>
    <form action="manager/update.do" method="post">
    	<p>新密码:<input type="password" name="newPassword"/></p>
    	<p>确认新密码:<input type="password" /></p>
    	<p><button type="submit" >确认修改</button></p>
    </form>
  </body>
</html>
