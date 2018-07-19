<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page import="com.topview.www.po.*" %>
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
	<title>用户查询食物结果</title>
	
</head>
<body>
	<jsp:include page="../user/userIndex.jsp"></jsp:include>
	<!-- ====================== 展示用户查询食物的结果 ======================= -->	
		<c:if test="${page.list.isEmpty()}">
		<h3 align="center">sorry，查不到相关数据</h3>
		</c:if>
		<c:if test="${page != null && !page.list.isEmpty()}">
			<table border="8" align="center" width="720px">
				<tr>
					<th width="80px">图片</th>
					<th>名字</th>
					<th>价格</th>
					<th>销量</th>
					<th>类型</th>
					<th>说明</th>
					<th>库存</th>
					<th>操作</th>
				</tr>
				<c:forEach var="food" items="${page.list}">
				<tr>
					<td><img alt="" src="Image/food/${food.foodImage}" width="80px" height="80px"></td>
					<td>${food.foodName}</td>
					<td>${food.foodPrice}</td>
					<td>${food.foodSales}</td>
					<td>${food.foodType}</td>
					<td>${food.foodComments}</td>
					<td>${food.foodNum}</td>
					<td>
						<form action="order/FillInOrderServlet" method="post" target="_blank">
							<input type="hidden" name="foodId" value="${food.id}">
							<input type="submit" value="立即下单"><br>
						</form>
						<form action="shopcar/AddFoodToShopcarServlet" method="post" target="_blank" onsubmit="return checkNum(this)">
							<input type="text" name="foodNum">
							<input type="hidden" name="foodPrice" value="${food.foodPrice}">
							<input type="hidden" name="storeId" value="${food.storeId}">
							<input type="hidden" name="foodId" value="${food.id}">
							<input type="submit" value="加入购物车"><br>
						</form>
						<form action="evaluation/SelectEvaluationServlet" method="post" target="_blank">
							<input type="hidden" name="foodId" value="${food.id}">
							<input type="submit" value="查看评价"><br>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
		
			<ul style="text-align: center">
			<li>
			<a href="user/UserSearchServlet?currentPage=1&search=${search}&searchType=${searchType}">首页</a>
			<a href="user/UserSearchServlet?currentPage=${page.currentPage==1? page.currentPage : page.currentPage-1}&search=${search}&searchType=${searchType}">上一页</a>
			<c:out value="第${page.currentPage}页/共${page.totalPages}页"></c:out>
			<a href="user/UserSearchServlet?currentPage=${page.currentPage==page.totalPages? page.currentPage : page.currentPage+1 }&search=${search}&searchType=${searchType}">下一页</a>
			<a href="user/UserSearchServlet?currentPage=${page.totalPages}&search=${search}&searchType=${searchType}">尾页</a></li>
			</ul>
		</c:if>	
		
</body>
</html>