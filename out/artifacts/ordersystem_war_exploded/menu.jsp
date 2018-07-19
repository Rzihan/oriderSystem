<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
		+ request.getServerPort() + path + "/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=path%>/css/usermenu.css" type="text/css" media="all" />
	<title>用户菜单栏</title>
	<base href="<%=basePath%>">
</head>
<body>
	<div class="main">
		<ul>
			<li><a href="user/userIndex.jsp"><span>首页</span></a></li>
			<li><a href="order/UserFindMyOrderServlet"><span>订单</span></a></li>
			<li><a href="shopcar/ViewShopcarServlet"><span>购物车</span></a></li>
			<li><a href="user/UserManageServlet"><span>我的</span></a></li>
		</ul>
	</div>

</body>
</html>