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
	<title>确认订单界面</title>
	<script type="text/javascript">
		function subNum(){
			document.getElementById("foodNum").value=document.getElementById("foodNum").value-1;
		}
		function addNum(){
		document.getElementById("foodNum").value=1+parseInt(document.getElementById("foodNum").value);
		}
	</script>
</head>
<body>


	<h3>确认收货地址</h3>
	<c:if test="${myAddressList == null || myAddressList.isEmpty()}">
		<h5>您暂未填写地址信息，请点击下面的超链接完善收货地址信息，再回到此处刷新，完成订单结算</h5>
		<a href="myAddress/FindAllMyAddressServlet" target="_blank">请点击这里！！！</a>
	</c:if>
	<c:if test="${myAddressList != null && !myAddressList.isEmpty()}">
		<form action="order/ConfirmOrderServlet" method="post">
		<hr>
			<c:forEach var="myAddress" items="${myAddressList}">
				<input type="radio" name="addressId" value="${myAddress.id}">
				<c:out value="${myAddress.linkman}"></c:out>&nbsp;&nbsp;&nbsp;
				<c:out value="${myAddress.phone}"></c:out>&nbsp;&nbsp;&nbsp;
				<c:out value="${myAddress.address}"></c:out><br>
			</c:forEach>
		<hr>
		<h3>物品详情</h3>
			<c:if test="${food != null}">
				<img alt="" src="Image/food/${food.foodImage}" width="80px" height="80px"><br>
				<c:out value="名字:${food.foodName}"></c:out><br>
				<c:out value="价格:${food.foodPrice}"></c:out><br>
				<c:out value="销量:${food.foodSales}"></c:out><br>
				<c:out value="类型:${food.foodType}"></c:out><br>
				<c:out value="说明:${food.foodComments}"></c:out><br>
				<input type="hidden" name="storeId" value="${food.storeId}">
				<input type="hidden" name="foodId" value="${food.id}">
				<input type="hidden" name="foodPrice" value="${food.foodPrice}">
		</c:if>
		数量：
		<input id="subNum" name="subNum" type="button" value="-" onclick="subNum()"/>
		<input id="foodNum" name="foodNum" type="text" value="1" style="width:25px;" />
		<input id="addNum" name="addNum" type="button" value="+" onclick="addNum()"/>
		<input type="submit" value="提交订单">
		</form>
	</c:if>

</body>
</html>