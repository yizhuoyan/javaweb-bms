<%@page import="com.valentinalee.bms.vo.StudentVO"%>
<%@page contentType="text/html; charset=utf-8" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>学生列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<script type="text/javascript" src="js/common.js"></script>
		<script type="text/javascript" src="js/student/list.js"></script>


	</head>

	<body class="layoutv">
		<div class="head nav">
			<a href="jsp/welcome.jsp">首页</a><span>»</span>学生管理
		</div>
		<div class="body" style="top: 2em; bottom: 0">
			<div class="layoutv">
				<div class="head floatBox clear" style="height: 3em">
					<div class="left" style="line-height: 3em">
						<label>
							学生列表
						</label>
						<span>┇</span>
						<a href="jsp/student/add.jsp">添加</a>
						<span>┇</span>
						<a href="javascript:fDelStudent()">删除</a>
						<span>┇</span>
					</div>

					<div class="right">
						<form id="queryForm" style="line-height: 3em" method="post" action="student/query.do">
							<input name="key"  type="text"  value="${key}">
							<input type="hidden" name="pageSize" value="10">
							<input type="hidden" name="pageNo" value="1">
							<button style="line-height: 2em;" type="submit">
								查询
							</button>
						</form>
					</div>
				</div>
				<div class="body" style="top: 3em; bottom: 2em">
					<form id="deleteForm" action="student/delete.do" method="post">
						<table border="1" class="dataList">
							<thead>
								<tr>
									<th width="14px">
										No.
									</th>
									<th width="13px">
										<input onclick="fToggleCheckRow()" title="全选/全不选"
											type="checkbox">
									</th>
									<th width="80px">
										操作
									</th>
									<th width="80px">
										学号
									</th>
									<th width="80px">
										姓名
									</th>
									<th width="80px">
										性别
									</th>
									<th width="160px">
										入学时间
									</th>
									<th width="160px">
										毕业时间
									</th>
								</tr>
							</thead>

							<tbody>
								<%
									List<StudentVO> vos = (List<StudentVO>) request.getAttribute("pageData");
									if (vos == null || vos.size() == 0) {
								%>
								<tr>
									<td colspan='99'>
										没有找到数据
									</td>
								</tr>
								<%
									return;
									}
									
									StudentVO vo = null;
									for (int i = 0; i < vos.size(); i++) {
										vo = vos.get(i);
								%>
								<tr <%=i % 2 == 0 ? "class='odd'" : ""%>>
									<td>
										<%=i + 1%>
									</td>
									<td>
										<input name="studentId" type="checkbox"
											value="<%=vo.getId()%>">
									</td>
									<td>
										<a href="student/show.do?id=<%=vo.getId()%>">查看/修改</a>
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


				<div class="foot" style="line-height: 2em">
					<div id="paginationBox" class="clear">
						<div class="total">
							<span>每页<input id="pageSizeInput" type="text"
									maxlength="2" onblur="checkPageSizeValid(this)" class="small"
									value="${pageSize}">条 </span>
							<span>共${totalNo}页</span>
							<span>跳到 <input id="jumpPageNoInput" type="text"
									maxlength="3" onblur="checkPageNoValid(this)"
									totalNo="${totalNo}" class="small">页 </span>

							<span><a class="btn" href="javascript:fJumpPage()">GO</a>
							</span>
						</div>
						<div class="jumping">
							<%
								int currentPageNo = (Integer) request.getAttribute("currentPageNo");
								if (currentPageNo == 1) {
							%>
							<a>第一页</a>
							<a>上一页</a>
							<%
								} else {
							%>
							<a class="active" href="javascript:fJumpPage(1)">第一页</a>
							<a class="active" href="javascript:fJumpPage(${currentPageNo-1})">上一页</a>
							<%
								}
							%>

							<span> ${currentPageNo} </span>
							<%
								int totalNo = (Integer) request.getAttribute("totalNo");
								
								if (totalNo == currentPageNo) {
							%>
							<a>下一页</a>
							<a>最末页</a>
							<%
								} else {
							%>
							<a class="active"
								href="javascript:fJumpPage(${currentPageNo+1 })">下一页</a>
							<a class="active" href="javascript:fJumpPage(${totalNo})">最末页</a>

							<%
								}
							%>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>


</html>
