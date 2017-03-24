<%@page import="domain.Bus"%>
<%@page import="java.util.List"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
</HEAD>
<body>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/selectUserServlet"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查
							询 条 件</strong></td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									ID：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="userID"  value="" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								</td>
								<td class="ta_01" bgColor="#ffffff"></td>
							</tr>
							
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									用户名：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="username" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								</td>
								<td class="ta_01" bgColor="#ffffff"></td>
							</tr>
							
							
							<tr>
								<td align="center" bgColor="#ffffff" class="ta_01"><br>
									<br></td>
								<td align="center" bgColor="#ffffff" class="ta_01">
									<button type="submit" id="search" name="search"
										value="&#26597;&#35810;" class="button_view">
										&#26597;&#35810;</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="reset" name="reset" value="&#37325;&#32622;"
									class="button_view" />
								</td>
							</tr>
						</table>
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>管理员信息列表</strong>
					</TD>
				</tr>
				<!-- <tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="&#28155;&#21152;"
							class="button_add" onclick="addProduct()">&#28155;&#21152;
						</button>
					</td>
				</tr> -->
				<tr>
				
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="30%">ID</td>
								<td align="center" width="14%">用户名</td>
								<td align="center" width="14%">密码</td>
								<td align="center" width="14%">管理权限</td>
								<td align="center" width="14%">编辑</td>
								<td align="center" width="14%">删除</td>
							</tr>

							<c:forEach items="${user }" var="list">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23" id="username">${list.userID }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23" id="username">${list.username }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23" id="password">${list.password }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${list.permission }</td>
									<td align="center" style="HEIGHT: 22px" width="7%">
									<a href="${pageContext.request.contextPath }/editUserServlet?userID=${list.userID }">
									<img src="${pageContext.request.contextPath}/admin/images/i_edit.gif" border="0" style="CURSOR: hand" />
									</a></td>

									<td align="center" style="HEIGHT: 22px" width="7%">
										<a href="javascript:if(confirm('确实要删除该内容吗?'))location='${pageContext.request.contextPath }/deleteUserServlet?userID=${list.userID }'">
												<img src="${pageContext.request.contextPath}/admin/images/i_del.gif"
													width="16" height="16" border="0" style="CURSOR: hand" />
										</a>
									</td>
								</tr>
							</c:forEach>

						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

