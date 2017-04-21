<%@page import="com.valentinalee.bms.vo.TypeVO"%>
<%@page import="com.valentinalee.bms.vo.PublisherVO"%>
<%@page import="com.valentinalee.bms.vo.BookVO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/book/list.js"></script>
  </head>
  
  <body>
  	<div class="nav">
		<a href="jsp/welcome.jsp">首页</a> <span>»</span><a
			href="book/query.do">图书管理</a> <span>»</span>添加图书
	</div>
  	<%
		Object message=request.getAttribute("message");
	%>
	<%
		BookVO vo=(BookVO)request.getAttribute("vo");
	%>
  	<form action="book/add.do" method="post">
  		<table>
			<tr>
				<td colspan="2" class="ac"><strong> ${message}</strong></td>
			</tr>
  			<tr>
  				<td class="label">图书名:</td>
  				<td><input type="text" name="name" maxlength="10" value="${name}" /></td>
  			</tr>
  			<tr>
  				<td class="label">ISBN号:</td>
  				<td><input type="text" name="isbn"  value="${isbn}" /></td>
  			</tr>
  			<tr>
  				<td class="label">作者:</td>
  				<td><input type="text" name="author"  value="${author}" /></td>
  			</tr>
  			<tr>
  				<td class="label">出版社:</td>
  				<td>
  				<select name="publisher">
									<option  value="">－－－－－－－请选择－－－－－－</option>
									<%
										List<PublisherVO> publishers=(List<PublisherVO>)application.getAttribute("BOOK-PUBLISHERS");
										String selectedPublisher=(String)request.getParameter("publisher");
										PublisherVO publisher=null;	
										for(int i=0;i<publishers.size();i++){
											publisher=publishers.get(i);
											
									%>
									<option  
									<%if(publisher.getPublisher().equals(selectedPublisher)){
										out.print("selected='selected'");
									} %>
									 value="<%=publisher.getPublisher()%>"><%=publisher.getPublisher()%></option>
									<%
										}
									%>
							</select>
  				
  			</tr>
  			<tr>
  				<td class="label">类型:</td>
  				<td>
  				<select name="publisher">
									<option  value="">－－－－－－－请选择－－－－－－</option>
									<%
									List<TypeVO> bookTypes=(List<TypeVO>)application.getAttribute("BOOK-TYPES");
									String checkedType=(String)request.getAttribute("type");
									String type=null;
									for(TypeVO typeVO:bookTypes){
										type=typeVO.getType();
											
									%>
									<option  
									<%if(type.equals(checkedType)){
										out.print("selected='selected'");
									} %>
									 value="<%=type%>"><%=type%></option>
									<%
										}
									%>
							</select>
  			</tr>
  			<tr>
  				<td class="label">价格:</td>
  				<td><input type="text" name="price"  value="${price}" /></td>
  			</tr>
  			<tr>
  				<td class="label">库存量:</td>
  				<td><input type="text" name="storeAmount"  value="${storeAmount}" /></td>
  			</tr>
  			<tr>
  				<td class="label">副本数量:</td>
  				<td><input type="text" name="leftAmount" value="${leftAmount}" /></td>
  			</tr>
  			<tr>
  				<td colspan="2" class="ac">
  					<button type="submit">添加</button>
					<button type="reset">重置</button>
					<a class="btn" href="book/query.do">返回</a>
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>

