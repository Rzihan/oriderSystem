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
	<title>店家处理买家订单结果页面</title>
	<base href="<%=basePath%>">
</head>
<body>
	<h1>处理订单成功</h1>
	<a href="order/StoreFindUnShipOrdersServlet">点击这里返回继续处理其他订单</a>
</body>
</html>