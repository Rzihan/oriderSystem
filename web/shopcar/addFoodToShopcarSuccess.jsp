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
	<title>添加成功结果页面</title>
	<base href="<%=basePath%>">
</head>
<body style="text-align: center">
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>添加商品到购物成功</h3>
	<a href="shopcar/ViewShopcarServlet">点击查看我的购物车</a>
</body>
</html>