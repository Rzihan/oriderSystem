<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
		+ request.getServerPort() + path + "/"; 
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查看店铺所有订单</title>
</head>
<body>
	<jsp:include page="../store/storeMenu.jsp"></jsp:include>
	<h2 align="center">${StoreFindAllOrderResults}</h2>
	<c:if test="${userOrderList != null}">
	<h2>全部订单</h2>
	<table border="0" align="center" width="600px">
		<c:forEach var="userOrder" items="${userOrderList}">
			<tr>
				<td colspan="1"><font size="5px">订单id:${userOrder.id}</font></td>
			</tr>
				<c:forEach var="oaf" items="${orderAndFoodsMap[userOrder.id]}">
					<tr>
						<td colspan="2" width="160px"><img src="Image/food/${foodMap[oaf.foodId].foodImage}" width="150px" height="130px"></td>
						<td width="240px">
							名称:${foodMap[oaf.foodId].foodName}<br>
							数量:${oaf.foodNum}<br>
							价格:${oaf.foodPrice}<br>
						</td>
					</tr>
				</c:forEach>
			<tr>
				<td colspan="2"></td>
				<td width="400px">
				收货人：${myAddressMap[userOrder.address].linkman}&nbsp;&nbsp;&nbsp;
				电话：${myAddressMap[userOrder.address].phone }<br>
				地址：${myAddressMap[userOrder.address].address}
			</tr>
			<tr>
				<td colspan="2"></td>
				<td width="400px">
				合计：${userOrder.payPrice}元&nbsp;&nbsp;&nbsp;
				状态：
				<c:choose>
					<c:when test="${userOrder.status==0}">买家已支付</c:when>
					<c:when test="${userOrder.status==1}">未发货</c:when>
					<c:when test="${userOrder.status==2}">已发货</c:when>
					<c:when test="${userOrder.status==3}">未收货</c:when>
					<c:when test="${userOrder.status==4}">已收货</c:when>
				</c:choose>
				&nbsp;&nbsp;
				<c:if test="${userOrder.status==0}">
				操作：<form action="order/StoreDealWithOrderServlet" method="post">
						<input type="hidden" value="${userOrder.id}" name="orderId">
						<input type="submit" value="发货" name="operate">
					</form>
				</c:if>
				</td>	
			</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>