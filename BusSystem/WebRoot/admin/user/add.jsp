<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">

<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
				+ new Date().getTime();
	}
</script>
</HEAD>

<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath }/addUserServlet"
		method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加管理员</STRONG> </strong></td>
			</tr>


			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								用&nbsp;户&nbsp;名：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="username" size="15" value="" id="Form1_userName" class="bg" />${msg.username }${user_msg }
							</td>
						</tr>
						
						<tr>

							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								密 &nbsp;&nbsp;&nbsp;&nbsp; 码：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="password"
								name="password" size="15" value="" id="Form1_userName" class="bg" />${msg.password }
							</td>
							
						</tr>
						
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								确认密码：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="password"
								name="repassword" size="15" value="" id="Form1_userName" class="bg" />${msg.repassword }
							</td>
						</tr>
						
						<%-- <tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								管理权限：</td>
							<td class="ta_01" bgColor="#ffffff">
							<select id="category" name="permission">
								<option value="普通管理员">-----请选择管理权限-----</option>
								<option value="普通管理员">普通管理员</option>
								<option value="超级管理员">超级管理员</option>
							</select> ${msg.repassword }
							</td>
						</tr> --%>
						
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								验&nbsp;证&nbsp;码：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="ckcode" size="15" value="" id="Form1_userName" class="bg" />${msg.ckcode }
							</td>
						</tr>
						
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
							</td>
							<td class="ta_01" bgColor="#ffffff">
								<img src="${pageContext.request.contextPath}/imageCode" width="180" `height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
								<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a><br>	
							</td>
						</tr>
						
						
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
								class="button_ok" type="button" onclick="history.go(-1)"
								value="返回" /> <span id="Label1"> </span></td>
						</tr>
					</table>
					</form>
</body>
</HTML>