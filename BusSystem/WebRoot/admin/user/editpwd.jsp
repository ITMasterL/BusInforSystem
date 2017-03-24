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
	src="${pageContext.request.contextPath}/admin/js/check.js"> </script>

</HEAD>
<body>
	<form action="${pageContext.request.contextPath }/updatePwdServlet" method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>修改用户名密码</STRONG> </strong></td>
			</tr>


			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								用户 ID：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="userID" size="30" value="${user.userID }" id="Form1_userName"  readonly="readonly" />
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								用户名：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="username" size="15" value="${user.username }" id="Form1_userName" class="bg" />${msg_username }
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								原密码：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="password" size="15" value="" id="Form1_userName" class="bg" />${msg_pwd }
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								新密码：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="newpassword" size="15" value="" id="Form1_userName" class="bg" />${msg_npwd }
							</td>
						</tr>
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								确认密码：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="repassword" size="15" value="" id="Form1_userName" class="bg" />${msg_repwd }
							</td>
						</tr>
						
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