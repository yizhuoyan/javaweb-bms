<%@page import="com.valentinalee.bms.vo.BorrowVO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add2.jsp' starting page</title>
    
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
    <div class="nav">
		<a href="jsp/welcome.jsp">首页</a> <span>»</span>借阅登记<span>»</span>登记图书
	</div>
	<!-- 展示学生未归还记录 -->
	<div class="box radius">
		<div class="box-head radius">
			<div style="text-align: center">
				<h3>学生借阅未归还信息</h3>
			</div>
		</div>
		<div class="box-body radius">
			<table class="dataList">
				<thead>
					<tr>
						<th width="14px">No.</th>
						<th width="80px">学号</th>
						<th width="80px">姓名</th>
						<th width="80px">图书名</th>
						<th width="160px">图书ISBN号</th>
						<th width="160px">借出时间</th>
						<th width="160px">实际归还时间</th>
						<th width="160px">异常描述</th>
						<th width="160px">借出管理员</th>
					</tr>
				</thead>
	
				<tbody>
					<%
						List<BorrowVO> borrowVOs=(List<BorrowVO>)request.getAttribute("borrowVOs");
						if (borrowVOs == null) {
					%>
					<tr>
						<td colspan='99'>该生暂时没有借阅未归还书籍</td>
					</tr>
					<%
						
							return; 
						}else{
							if(borrowVOs.size()==0){
								%>
								<tr>
									<td colspan='99'>该生暂时没有借阅未归还书籍</td>
								</tr>
								<%
								return;
							}
						}
	
						BorrowVO borrowVO = null;
						for (int i = 0; i < borrowVOs.size(); i++) {
							borrowVO = borrowVOs.get(i);
							pageContext.setAttribute("borrowVO", borrowVO);
							
					%>
					<tr <%=i % 2 == 0 ? "class='odd'" : ""%>>
						<td>
							<%=i+1%>
						</td>
						<td>${borrowVO.student.no}</td>
						<td>${borrowVO.student.name}</td>
						<td>${borrowVO.book.name}</td>
						<td>${borrowVO.book.ISBN}</td>
						<td>${borrowVO.borrowOutTime}</td>
						<td>${borrowVO.giveBackTime}</td>
						<td>${borrowVO.remark}</td>
						<td>${borrowVO.borrowOutManager.name}</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	
	
	<div class="box-body-input">
		<form id="queryForm" method="post" action="borrow/add.do">
			<input type="hidden" name="pageSize" value="10"> 
			<input type="hidden" name="pageNo" value="1">
			<input type="hidden" name="studentId" value="${studentVO.id}">
			<table>
				<tr>
					<td colspan="2" class="ac"><strong> ${message}</strong></td>
				</tr>
				<tr>
					<td class="label">借阅学生:</td>
					<td>${studentVO.name}（${studentVO.no}）</td> 
				</tr>
				<%
				Integer noGiveBackBooksAmount=(Integer)request.getAttribute("noGiveBackBooksAmount");
				if(noGiveBackBooksAmount==null)noGiveBackBooksAmount=0;
				
				while(noGiveBackBooksAmount<3){
				%>
				<tr>
					<td class="label">isbn:</td>
					<td><input name="isbn" type="text" ></td> 
				</tr>
				<%
						noGiveBackBooksAmount++;
					} 
				%>
				<tr>
					<td colspan="2">
						<button type="submit">确定</button>
						<button type="button" onclick="window.history.back()">返回</button>
					</td>
				</tr>
			</form>
		</table>
	</div>
  </body>
</html>
