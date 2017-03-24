<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/check.js"></script>

</HEAD>
<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath }/updateBuslineServlet" method="post">
	
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑线路信息</STRONG> </strong></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">线路编号：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="buslineNO" size="30" value="${busline.buslineNO }" readonly="readonly"/>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">汽车编号：</td>
				<td class="ta_01" bgColor="#ffffff">
					<select name="busNO">
						<option value="${busline.busNO }">------请选择------</option>
					<c:forEach items="${bus }" var="bus">
						<option value="${bus.busNO }">${bus.busNO }</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">起始站：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="departcity" value="${busline.departcity }"
					class="bg" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">终点站：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="arrivalcity" value="${busline.arrivalcity }"
					class="bg" />
				</td>

			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">起始时间：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="time"
					name="departdate" value="${busline.departdate }"/>
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">到达时间：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="time"
					name="arrivaldate" value="${busline.arrivaldate }" />
				</td>
			</tr>
			
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">备注：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
				<textarea
						name="buslinememo" cols="30" rows="3" 
						style="WIDTH: 96%">${busline.buslinememo }</textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>




</body>
</HTML>