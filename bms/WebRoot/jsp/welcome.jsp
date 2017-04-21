<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>欢迎页面</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    
  </head>
  
  <body>
    	<table class="vhc" >
    		<tr>
    			<td>
    					<h1>欢迎使用,请点击左边菜单开始</h1>
    			</td>
    			
    		</tr>
    	</table>
  </body>
</html>
