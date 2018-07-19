<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page import="com.topview.www.po.*" %>
<%@ page import="java.util.*" %>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
		+ request.getServerPort() + path + "/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="../css/menu.css" type="text/css" media="all" />
	<base href="<%=basePath%>">
	<title>我的订单页面</title>
	
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3 align="center">${UserFindMyOrderResult}</h3>
	<c:if test="${userOrderList != null}">
	<h2 align="center">我的订单</h2>
	<table border="3" align="center" width="800px">
		<c:forEach var="userOrder" items="${userOrderList}">
			<tr>
				<td colspan="1"><font size="5px">订单id:${userOrder.id}</font></td>
			</tr>
				<c:forEach var="oaf" items="${orderAndFoodsMap[userOrder.id]}">
					<tr>
						<td colspan="2" width="160px"><img src="Image/food/${foodMap[oaf.foodId].foodImage}" width="150px" height="100px"></td>
						<td width="240px">
							名称:${foodMap[oaf.foodId].foodName}<br>
							数量:${oaf.foodNum}<br>
							价格:${oaf.foodPrice}<br>
							<c:if test="${userOrder.status==4}">
							评价：
							<form action="order/UserEvaluateOrderServlet" method="post">
								<input type="hidden" name="userId" value="${user.userId}">
								<input type="hidden" name="storeId" value="${userOrder.storeId}">
								<input type="hidden" name="foodId" value="${oaf.foodId}">
								<input type="hidden" name="orderId" value="${userOrder.id}">
								<input type="text" name="foodEvaluation">
								<input type="submit" value="确认提交">
							</form>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			<tr>
				<td colspan="2"></td>
				<td width="400px">
				合计：${userOrder.payPrice}元&nbsp;&nbsp;&nbsp;
				状态：
				<c:choose>
					<c:when test="${userOrder.status==0}">已支付</c:when>
					<c:when test="${userOrder.status==1}">未发货</c:when>
					<c:when test="${userOrder.status==2}">已发货</c:when>
					<c:when test="${userOrder.status==3}">未收货</c:when>
					<c:when test="${userOrder.status==4}">已收货</c:when>
					<c:when test="${userOrder.status==5}">已评价</c:when>
				</c:choose>
				&nbsp;&nbsp;
				<c:if test="${userOrder.status==2}">
					操作：
					<form action="order/ComfirmReceiveFoodServlet" method="post">
						<input type="hidden" name="orderId" value="${userOrder.id}">
						<input type="submit" value="确认收货">
					</form>
				</c:if>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<ul style="text-align: center">
		<li>
		<a href="order/UserFindMyOrderServlet?currentPage=1">首页</a>
		<a href="order/UserFindMyOrderServlet?currentPage=${page.currentPage==1? page.currentPage : page.currentPage-1}">上一页</a>
		<c:out value="第${page.currentPage}页/共${page.totalPages}页"></c:out>
		<a href="order/UserFindMyOrderServlet?currentPage=${page.currentPage==page.totalPages? page.currentPage : page.currentPage+1 }">下一页</a>
		<a href="order/UserFindMyOrderServlet?currentPage=${page.totalPages}">尾页</a></li>
	</ul>
	</c:if>
</body>
</html>