<%@page import="com.valentinalee.bms.vo.PublisherVO"%>
<%@page import="com.valentinalee.bms.vo.TypeVO"%>
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

<title>图书列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/book/list.css">
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/book/list.js"></script>
</head>

<body>
	<div class="nav">
		<a href="jsp/welcome.jsp">首页</a><span>»</span>图书管理
	</div>
	<div class="box radius">
		<div class="box-head radius">
			<div class="left">
				<label>图书列表</label> <span>┇</span> <a href="jsp/book/add.jsp">添加</a>
				<span>┇</span> <a href="javascript:fDelBook()">删除</a> <span>┇</span>
			</div>
		</div>

		<div class="box-body radius">
			<div>
				<form id="queryForm" action="book/query.do" method="post">
					<input type="hidden" name="pageSize" value="10" /> 
					<input type="hidden" name="pageNo" value="1">
					<table>
						<tr>
							<td align="right">图书名称:</td>
							<td><input type="text" name="name" value="${name}" /></td>
							<td align="right">图书ISBN号:</td>
							<td><input type="text" name="isbn" value="${isbn}" /></td>
							<td align="right">图书作者:</td>
							<td><input type="text" name="author" value="${author}" /></td>
						</tr>
						<tr>
							<td align="right">出版社:</td>
							<td><select name="publisher">
									<option value="">---请选择---</option>
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
							</select></td>

							<td align="right">图书库存:</td>
							<td colspan="3"><input type="text" name="minStoreAmount" value="${minStoreAmount}" />
								<span>-</span> <input type="text" name="maxStoreAmount" value="${maxStoreAmount}" /></td>
						</tr>
						<tr>
							<td align="right">图书类型:</td>
							<td colspan="5">
								<%
									List<TypeVO> bookTypes=(List<TypeVO>)application.getAttribute("BOOK-TYPES");
									String[] checkedTypes=(String[])request.getAttribute("checkedTypes");
									String type=null;
									for(TypeVO typeVO:bookTypes){
										type=typeVO.getType();
								%> 
									<input type="checkbox" name="checkedTypes"
								<%
										if(checkedTypes!=null){
											for(String checkedType:checkedTypes){
													if(checkedType.equals(type)){
															out.print("checked='checked'");
															break;
													}
											}
										} 
								%>
										value="<%=type%>"><%=type%>
								
								 <%
										}
								%>
							</td>
						</tr>
						<tr>
							<td colspan="6" class="ac">
								<button type="submit">查询</button>
								<button type="reset">重置条件</button>
							</td>
						</tr>
					</table>
				</form>
			</div>

			<form id="deleteForm" action="book/delete.do" method="post">
				<table class="dataList">
					<thead>
						<tr>
							<th width="14px">No.</th>
							<th width="13px"><input onclick="fToggleCheckRow()"
								title="全选/全不选" type="checkbox"></th>
							<th width="80px">操作</th>
							<th>图书名</th>
							<th width="80px">ISBN号</th>
							<th width="80px">作者</th>
							<th>出版社</th>
							<th width="80px">图书类型</th>
							<th width="80px">图书价格</th>
							<th width="80px">库存量</th>
							<th width="80px">副本数量</th>
						</tr>
					</thead>

					<tbody>
						<%
							List<BookVO> vos = (List<BookVO>) request
																	.getAttribute("pageData");
															if (vos == null||vos.size()==0) {
						%>
						<tr>
							<td colspan='99'>没有找到数据</td>
						</tr>
						<%
							return;
															}
											
															BookVO vo = null;
															for (int i = 0; i < vos.size(); i++) {
																vo = vos.get(i);
						%>
						<tr <%=i % 2 == 0 ? "class='odd'" : ""%>>
							<td><%=i+1%></td>
							<td><input name="bookId" type="checkbox"
								value="<%=vo.getId()%>"></td>
							<td><a href="book/show.do?id=<%=vo.getId()%>">查看/修改</a></td>
							<td><%=vo.getName()%></td>
							<td><%=vo.getISBN()%></td>
							<td><%=vo.getAuthor()%></td>
							<td><%=vo.getPublisher()%></td>
							<td><%=vo.getBookType()%></td>
							<td><%=vo.getPrice()%></td>
							<td><%=vo.getStoreAmount()%></td>
							<td><%=vo.getLeftAmount()%></td>
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
				<span>每页<input id="pageSizeInput" maxlength="2"
					onblur="checkPageSizeValid(this)" class="small"
					value="${pageSize}">条
				</span> <span>共${totalNo}页
				</span> <span>跳到 <input id="jumpPageNoInput" maxlength="3"
					onblur="checkPageNoValid(this)" totalNo="${totalNo}"
					class="small">页
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
