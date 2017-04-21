<%@page import="com.valentinalee.bms.vo.StudentVO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>新增借阅</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/borrow/list.js"></script>

</head>

<body>
	<div class="nav">
		<a href="jsp/welcome.jsp">首页</a> <span>»</span>借阅登记<span>»</span>选择学生
	</div>

	<div class="box radius">
		<div class="box-head radius">
			<div class="left">
				<h3>学生列表</h3>
			</div>
			<div class="right">
			<form id="queryForm" method="post" action="borrow/queryStudent.do">
				<input name="key" type="text" style="height: 20px" value="${key}">
				<input type="hidden" name="pageSize" value="10"> <input
					type="hidden" name="pageNo" value="1">
				<button type="submit">查询</button>
			</form>
		</div>
		</div>
		<div class="box-body radius">
			<table class="dataList">
				<thead>
					<tr>
						<th width="14px">No.</th>
						<th width="80px">操作</th>
						<th width="80px">学号</th>
						<th width="80px">姓名</th>
						<th width="80px">性别</th>
						<th width="160px">入学时间</th>
						<th width="160px">毕业时间</th>
					</tr>
				</thead>

				<tbody>
					<%
						List<StudentVO> vos = (List<StudentVO>) request
														.getAttribute("pageData");
												if (vos == null||vos.size()==0) {
					%>
					<tr>
						<td colspan='99'>没有找到数据</td>
					</tr>
					<%
						return;
												}
									
												StudentVO vo = null;
												for (int i = 0; i < vos.size(); i++) {
													vo = vos.get(i);
					%>
					<tr <%=i % 2 == 0 ? "class='odd'" : ""%>>
						<td><%=i+1%></td>
						<td><a href="borrow/queryNoBack.do?studentId=<%=vo.getId()%>">借阅登记</a>
						</td>
						<td><%=vo.getNo()%></td>
						<td><%=vo.getName()%></td>
						<td><%=vo.getSex()%></td>
						<td><%=vo.getEnterDay()%></td>
						<td><%=vo.getGraduateDay()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			</form>
		</div>


		<div class="box-foot">
			<div class="total">
				<span>每页<input id="pageSizeInput" type="text" maxlength="2"
					onblur="checkPageSizeValid(this)" class="small" value="${pageSize}">条
				</span> <span>共${totalNo}页</span> <span>跳到 <input
					id="jumpPageNoInput" type="text" maxlength="3"
					onblur="checkPageNoValid(this)" totalNo="${totalNo}" class="small">页
				</span> <span><a class="btn" href="javascript:fJumpPage()">GO</a> </span>
			</div>
			<div class="jumping">
				<%
					int currentPageNo=(Integer)request.getAttribute("currentPageNo");
									 if(currentPageNo==1){
				%>
				<a>第一页</a> <a>上一页</a>
				<%
					}else{
				%>
				<a class="active" href="javascript:fJumpPage(1)">第一页</a> <a
					class="active" href="javascript:fJumpPage(${currentPageNo-1})">上一页</a>
				<%
					}
				%>

				<span> ${currentPageNo} </span>
				<%
					int totalNo=(Integer)request.getAttribute("totalNo");
										
										 if(totalNo==currentPageNo){
				%>
				<a>下一页</a> <a>最末页</a>
				<%
					}else{
				%>
				<a class="active" href="javascript:fJumpPage(${currentPageNo+1 })">下一页</a>
				<a class="active" href="javascript:fJumpPage(${totalNo})">最末页</a>

				<%
					}
				%>
			</div>
		</div>
	</div>

</body>

<%
	Object message=request.getAttribute("message");
	if(message!=null){
%>
<script type="text/javascript">
	alert("${message}");
</script>
<%
	}
%>
</html>


