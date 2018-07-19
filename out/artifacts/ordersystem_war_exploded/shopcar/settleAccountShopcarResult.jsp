<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
		+ request.getServerPort() + path + "/"; 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>">
	<title>购物车结算页面</title>
</head>
<body style="text-align: center">
	<jsp:include page="../menu.jsp"></jsp:include>
	<h2>${SettleAccountShopcarResult}</h2>
	<a href="user/userIndex.jsp">返回用户首页</a><br>
	<a href="shopcar/ViewShopcarServlet">查看购物车信息</a><br>
	<a href="order/UserFindMyOrderServlet">查看订单信息</a><br>
</body>
</html>