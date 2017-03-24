<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
        *{
            margin: 0;
            padding: 0;
            font-family: "微软雅黑 Light";
        }
      	body{
            background: url("images/timg.jpg") no-repeat;
        }
        .w{
            position: relative;
        }
        .nav{
            position: absolute;
            top: 300px;
            right: 70px;
        }
        .nav p{
            padding: 10px;
            text-align: center;
        }
        .nav p a{
            text-decoration: none;
            color: orangered;
            margin-left: 20px;
        }
    </style>
</head>
<body>
	<div class="w">
   <div class="nav">
       <h1>长途汽车信息管理系统</h1>
       <p>
           <a href="login.jsp">[登录]</a>
  	       <a href="#">[注册]</a>
       </p>
   </div>
</div>
</body>
</html>