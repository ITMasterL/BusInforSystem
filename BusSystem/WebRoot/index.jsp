<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<style>
* {
	padding: 0;
	margin: 0;
}

body {
	text-align: center;
	background: url("images/timg.jpg") no-repeat;
}

.diva {
	position: relative;
}

.divb {
	margin-right: 40px;
	position: absolute;
	top: 200px;
	right: 10px;
}

.divb h1 {
	font-family: "微软雅黑 Light";
	padding: 0;
	margin: 7px;
}

.divb form input {
	margin: 7px;
}

.msg {
	color: red; 
}

.td1{
	padding-top: 8px;
}

</style>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
				+ new Date().getTime();
	}
</script>
</head>
<body>
	<div class="diva">
		<div class="divb">
			<h1>长途汽车信息管理系统 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1><br>
		
			<br><div class="msg">
			${login_msg }<br>
			</div>
			<form action="${pageContext.request.contextPath }/loginServlet" method="post">
			
				<table class="table">
					<tr>
						<td height="22" align="center" class="td1">
							用户名：
						</td>
						<td align="center">
							<input type="text" name="username">${username_msg }
						</td>
					</tr>
					
					<tr>
						<td height="22" align="center" class="td1">
							密&nbsp;&nbsp;码：
						</td>
						<td class="ta_01">
							<input type="password" name="password">${password_msg }
						</td>
					</tr>
					
					<tr>
						<td height="22" align="center" class="td1">
							验证码：
						</td>
						<td class="ta_01">
							<input type="text" name="ckcode">${ckcode_msg }
						</td>
					</tr>
					
					<tr>
						<td height="22" align="center" class="td1">
						</td>
						<td class="ta_01">
							<img src="${pageContext.request.contextPath}/imageCode" width="180"
							height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
							<a href="javascript:void(0);" onclick="changeImage()">看不清换一张
						</td>
					</tr>
					<tr>
					<td align="center"></td>
					<td align="center">
						<input type="image" src="images/loginbutton.gif">
					</td>
					</tr>
					
				</table>
			</form>
		</div>
	</div>

</body>
</html>