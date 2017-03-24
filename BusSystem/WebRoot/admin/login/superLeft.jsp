<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/admin/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/admin/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add(0,-1,'系统菜单树');
		d.add(1,0,'管理员管理','/BusSystem/admin/login/welcome.jsp','','mainFrame');
		d.add(2,0,'汽车管理','/BusSystem/admin/login/welcome.jsp','','mainFrame');
		d.add(3,0,'线路管理','/BusSystem/admin/login/welcome.jsp','','mainFrame');
		d.add(4,0,'车票管理','/BusSystem/admin/login/welcome.jsp','','mainFrame');
		
		
		//子目录添加
		d.add(11,1,'管理员查询','${pageContext.request.contextPath }/allUserServlet','','mainFrame');
		d.add(12,1,'添加管理员','${pageContext.request.contextPath }/admin/user/add.jsp','','mainFrame');
		
		d.add(21,2,'车型查询','${pageContext.request.contextPath }/allBusServlet','','mainFrame');
		d.add(22,2,'添加车辆信息','${pageContext.request.contextPath }/admin/bus/add.jsp','','mainFrame');
		
		d.add(31,3,'线路查询','${pageContext.request.contextPath }/allBuslineServlet','','mainFrame');
		d.add(32,3,'添加线路信息','${pageContext.request.contextPath }/allbusNoServlet','','mainFrame');
		
		
		d.add(41,4,'车票订单','${pageContext.request.contextPath }/allBusticketServlet','','mainFrame');
		d.add(42,4,'添加车票信息','${pageContext.request.contextPath }/allbuslineNoServlet','','mainFrame');
	
		
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
