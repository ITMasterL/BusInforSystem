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
		action="${pageContext.request.contextPath}/selectBuslineServlet"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查
							询 条 件</strong>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									线路编号</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="buslineNO" size="15" value="" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									汽车编号</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="busNO" size="15" value="" class="bg" />
								</td>
							</tr>
							
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									起始站：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="departcity" size="15" value="" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									终点站：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="arrivalcity" size="15" value="" class="bg" />
								</td>
							</tr>
							
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									发车时间：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="time"
									name="departdate"/>
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									到达时间：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="time"
									name="arrivaldate" />
								</td>
							</tr>

							<tr>
								<td class="ta_01" bgColor="#ffffff"><font face="宋体"
									color="red"> &nbsp;</font>
								</td>
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
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>线路信息列表</strong>
					</TD>
				</tr>
				<tr>
					<td align="center"><font color="red">${msg_delete }</font></td>
				</tr>
			<!-- 	<tr>
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
								<td align="center" width="22%">线路编号</td>
								<td align="center" width="8%">起始站</td>
								<td align="center" width="8%">终点站</td>
								<td align="center" width="8%">起始时间</td>
								<td align="center" width="8%">到站时间</td>
								<td align="center" width="22%">汽车编号</td>
								<td align="center" width="14%">备注</td>
								<td align="center" width=5%">编辑</td>
								<td align="center" width="5%">删除</td>
							</tr>

						<c:forEach items="${busline }" var="busline">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										 id="buslineNO">${busline.buslineNO }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										>${busline.departcity }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										>${busline.arrivalcity }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										>${busline.departdate }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										>${busline.arrivaldate }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${busline.busNO }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">
										${busline.buslinememo }</td>
									<td align="center" style="HEIGHT: 22px" ><a
										href="${pageContext.request.contextPath }/editBuslineServlet?buslineNO=${busline.buslineNO }">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>

									<td align="center" style="HEIGHT: 22px" >
											<a href="javascript:if(confirm('确实要删除该内容吗?'))location='${pageContext.request.contextPath }/deleteBuslineServlet?buslineNO=${busline.buslineNO }'">
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

