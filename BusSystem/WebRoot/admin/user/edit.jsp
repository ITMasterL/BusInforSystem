<%@page import="domain.Bus"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
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

	<form action="${pageContext.request.contextPath }/updateUserServlet?userID=${user.userID } " method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑管理员信息</STRONG> </strong></td>
			</tr>


			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								用户名：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="username" size="15" value="${user.username }" id="Form1_userName" class="bg" readonly="readonly" />
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								密码：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="password" size="15" value="${user.password }" id="Form1_userName" class="bg" />
							</td>
						</tr>
						<!-- <tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								管理员权限：</td>
							<td class="ta_01" bgColor="#ffffff">
								<select name="permission">
									<option value="">--请选择管理权限--</option>
									<option value="普通管理员">普通管理员</option>
									<option value="超级管理员">超级管理员</option>
								</select>
							</td>
						</tr> -->

						<TR>
							<td align="center" colSpan="4" class="sep1"><img
								src="${pageContext.request.contextPath}/admin/images/shim.gif">
							</td>
						</TR>
						<tr>
							<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
								<input type="submit" class="button_ok" value="确定"> 
								<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
								<input type="reset" value="重置" class="button_cancel"> 
								<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
								<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" /> 	
								<!-- <span id="Label1"> </span></td> -->
						</tr>
				</table>
	</form>
</body>
</HTML>