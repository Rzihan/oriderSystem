<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
		+ request.getServerPort() + path + "/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>我的购物车页面</title>
</head>
<body style="text-align: center">
	<jsp:include page="../menu.jsp"></jsp:include>
	<h1 align="center">我的购物车</h1>
	<c:if test="${shopcarList == null || shopcarList.isEmpty()}">
		<h2 align="center">${ViewShopServlet}</h2>
	</c:if>
	<c:if test="${shopcarList != null}">
		<table border="8" align="center" width="720px">
			<tr>
				<th width="80px">图片</th>
				<th>名字</th>
				<th>类型</th>
				<th>单价</th>
				<th>数量</th>
			</tr>
			<c:set var="totalPrice" value="0"></c:set>
			<c:forEach var="shopcar" items="${shopcarList}">
				<c:set var="totalPrice" value="${shopcar.foodPrice * shopcar.foodNum + totalPrice}"></c:set>
				<tr>
					<td><img alt="" src="Image/food/${foodMap[shopcar.foodId].foodImage}" width="80px" height="80px"></td>
					<td>${foodMap[shopcar.foodId].foodName}</td>
					<td>${foodMap[shopcar.foodId].foodType}</td>
					<td>${shopcar.foodPrice}</td>
					<td>${shopcar.foodNum}</td>
				</tr>
			</c:forEach>
		</table>
			总价：${totalPrice}
			<form action="shopcar/ComfirmShopcarOrderServlet" method="post">
			<input type="submit" value="结算">
			</form>
	</c:if>
</body>
</html>