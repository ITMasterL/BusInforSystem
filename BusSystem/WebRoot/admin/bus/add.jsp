<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">


</HEAD>

<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath }/addBusServlet"
		method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>添加车辆信息</STRONG> </strong></td>
			</tr>


			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" border="0" width="100%">
						<tr>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								汽车类型：</td>
							<td class="ta_01" bgColor="#ffffff">
								<select name="bustype">
									<option value="">---请选择---</option>
									<option value="大型">大型</option>
									<option value="中型">中型</option>
									<option value="小型">小型</option>
								</select>${msg.bustype }
							</td>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								购买日期：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="date"
								name="buydate"/>${msg.buydate }
							</td>
						</tr>
						<tr>

							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								使用日期：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="date"
								name="usedate" />${msg.usedate }
							</td>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								核定载客人数：</td>
							<td class="ta_01" bgColor="#ffffff"><input type="text"
								name="seatnum" size="15" id="Form1_userName" class="bg" />${msg.seatnum }
							</td>
						</tr>
						<tr>

							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								是否有TV：</td>
							<td class="ta_01" bgColor="#ffffff">
								<select name="TV">
									<option value="">---请选择---</option>
									<option value="是">是</option>
									<option value="否">否</option>
								</select>${msg.TV }
							</td>
							<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
								是否有空调：</td>
							<td class="ta_01" bgColor="#ffffff">
								<select name="aircondition">
									<option value="">---请选择---</option>
									<option value="是">是</option>
									<option value="否">否</option>
								</select>${msg.aircondition }
							</td>
						</tr>
						<TR>
							<TD class="ta_01" align="center" bgColor="#f5fafe">备注：</TD>
							<TD class="ta_01" bgColor="#ffffff" colSpan="3"><textarea
									name="busmemo" cols="30" rows="3" style="WIDTH: 96%"></textarea>
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
								class="button_ok" type="button" onclick="history.go(-1)"
								value="返回" /> <span id="Label1"> </span></td>
						</tr>
					</table>
					</form>
</body>
</HTML>