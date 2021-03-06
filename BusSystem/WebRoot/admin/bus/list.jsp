<%@page import="domain.Bus"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
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
		action="${pageContext.request.contextPath}/selectBusServlet"
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
									汽车编号：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="busNO" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									汽车类型：</td>
								<td class="ta_01" bgColor="#ffffff">
									<select name="bustype">
										<option value="">----请选择----</option>
										<option value="大型">大型</option>
										<option value="中型">中型</option>
										<option value="小型">小型</option>
									</select>
								</td>
							</tr>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									购买日期：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="date"
									name="buydate" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									使用日期：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="date"
									name="usedate"/>
								</td>
							</tr>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									核定载客人数：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="seatnum" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									是否有TV：</td>
								<td class="ta_01" bgColor="#ffffff">
									<select name="TV">
										<option value="">----请选择----</option>
										<option value="是">是</option>
										<option value="否">否</option>
									</select>
								</td>
							</tr>

							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									是否有空调：</td>
								<td class="ta_01" bgColor="#ffffff">
									<select name="aircondition">
										<option value="">----请选择----</option>
										<option value="是">是</option>
										<option value="否">否</option>
									</select>
								</td>
							</tr>
							<tr>
								
								<td align="right" bgColor="#ffffff" class="ta_01"><br>
									<br></td>
								<td align="right" bgColor="#ffffff" class="ta_01">
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
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>汽车信息列表</strong>
					</TD>
				</tr>
				<tr>
					<td align="center" ><font color="red">${msg_delete }</font></td>
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
								<td align="center" width="25%">汽车编号</td>
								<td align="center" width="10%">汽车类型</td>
								<td align="center" width="10%">购买时间</td>
								<td align="center" width="10%">使用时间</td>
								<td align="center" width="8%">核定载客数量</td>
								<td align="center" width="6%">是否有TV</td>
								<td align="center" width="6%">是否有空调</td>
								<td align="center" width="15%">备注</td>
								<td align="center" width="5%">编辑</td>
								<td align="center" width="5%">删除</td>
							</tr>

							<c:forEach items="${bus }" var="list">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23" id="busNO">${list.busNO }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${list.bustype }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${list.buydate }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${list.usedate }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${list.seatnum }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${list.TV }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${list.aircondition }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${list.busmemo }</td>
									<td align="center" style="HEIGHT: 22px" >
									<a href="${pageContext.request.contextPath }/editBusServlet?busNO=${list.busNO }">
									<img src="${pageContext.request.contextPath}/admin/images/i_edit.gif" border="0" style="CURSOR: hand">
									</a></td>

									<td align="center" style="HEIGHT: 22px" >
										<a href="javascript:if(confirm('确实要删除该内容吗?'))location='${pageContext.request.contextPath }/deleteBusServlet?busNO=${list.busNO }'">
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

