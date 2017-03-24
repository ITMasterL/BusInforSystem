<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js">
</script>
</HEAD>
<body>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/selectBusticketServlet"
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
									车票编号：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="ticketNO" size="15" value="" id="Form1_userName"
									class="bg" /></td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									线路编号：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="buslineNO" size="15" value="" id="Form1_userName" class="bg" />
								</td>
							</tr>

							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									出发城市：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="departcity" size="15" value="" id="Form1_userName"
									class="bg" /></td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									到达城市：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="arrivalcity" size="15" value="" id="Form1_userName"
									class="bg" /></td>
							</tr>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									购票时间：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="date"
									name="ticketbuydate"/></td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									使用时间：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="date"
									name="ticketusedate" /></td>
							</tr>
							
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									票价：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="ticketprice" size="15" value="" id="Form1_userName"
									class="bg" /></td>
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
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>车票信息列表</strong>
					</TD>
				</tr>
				<!-- 		<tr>
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
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="13%">车票编号</td>
								<td align="center" width="13%">线路编号</td>
								<td align="center" width="8%">出发城市</td>
								<td align="center" width="8%">到达城市</td>
								<td align="center" width="8%">购票日期</td>
								<td align="center" width="8%">乘车日期</td>
								<td align="center" width="8%">发车时间</td>
								<td align="center" width="8%">到达时间</td>
								<td align="center" width="8%">票价</td>
								<td align="center" width="8%">备注</td>
								<td align="center" width="5%">编辑</td>
								<td align="center" width="5%">删除</td>
							</tr>

							<c:forEach items="${busticket }" var="busticket">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										id="ticketNO">${busticket.ticketNO }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										id="buslineNO">${busticket.buslineNO }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										>${busticket.departcity }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										>${busticket.arrivalcity }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										>${busticket.ticketbuydate }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${busticket.ticketusedate }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										>${busticket.departtime }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${busticket.arrivaltime }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${busticket.ticketprice }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${busticket.ticketmemo }</td>
									<td align="center" style="HEIGHT: 22px" ><a
										href="${pageContext.request.contextPath}/editBusticketServlet?ticketNO=${busticket.ticketNO }">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</a></td>

									<td align="center" style="HEIGHT: 22px" >
										<a href="javascript:if(confirm('确实要删除该内容吗?'))location='${pageContext.request.contextPath }/deleteBusticketServlet?ticketNO=${busticket.ticketNO }'">
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

