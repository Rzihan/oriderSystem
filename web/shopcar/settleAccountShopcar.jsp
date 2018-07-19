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
	<h3>购物车结算页面</h3>
	<h3>确认收货地址</h3>
	<c:if test="${myAddressList == null || myAddressList.isEmpty()}">
		<h5>您暂未填写地址信息，请点击下面的超链接完善收货地址信息，再回到此处刷新，完成订单结算</h5>
		<a href="myAddress/FindAllMyAddressServlet" target="_blank">请点击这里！！！</a>
	</c:if>
	<c:if test="${myAddressList != null && !myAddressList.isEmpty()}">
	<form action="shopcar/SettleAccountShopcarServlet" method="post">
	<hr>
		<c:forEach var="myAddress" items="${myAddressList}">
			<input type="radio" name="addressId" value="${myAddress.id}">
			<c:out value="${myAddress.linkman}"></c:out>&nbsp;&nbsp;&nbsp;
			<c:out value="${myAddress.phone}"></c:out>&nbsp;&nbsp;&nbsp;
			<c:out value="${myAddress.address}"></c:out><br>
		</c:forEach>
		<input type="submit" value="确认提交">
	</form>
	</c:if>
</body>
</html>