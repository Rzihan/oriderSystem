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
	<title>查看评价</title>
	<script type="text/javascript">
	 function checkNum(value) {
         var reg = /^\d+$/;
         if (value && reg.test(value)) {
             return true;
         } else {
        	 alert("请输入数字");
             return false;
         }
     }
		
	</script>
</head>
<body>
	<jsp:include page="../user/userIndex.jsp"></jsp:include>
	<c:if test="${food != null}">
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
			<tr>
				<td><img alt="" src="Image/food/${food.foodImage}" width="80px" height="80px"></td>
				<td>${food.foodName}</td>
				<td>${food.foodPrice}</td>
				<td>${food.foodSales}</td>
				<td>${food.foodType}</td>
				<td>${food.foodComments}</td>
				<td>${food.foodNum}</td>
				<td>
					<form action="order/FillInOrderServlet" method="post">
						<input type="hidden" name="foodId" value="${food.id}">
						<input type="submit" value="立即下单"><br>
					</form>
					<form action="shopcar/AddFoodToShopcarServlet" method="post" onsubmit="return checkNum(this)">
							<input type="text" name="foodNum">
							<input type="hidden" name="foodPrice" value="${food.foodPrice}">
							<input type="hidden" name="storeId" value="${food.storeId}">
							<input type="hidden" name="foodId" value="${food.id}">
							<input type="submit" value="加入购物车"><br>
					</form>
				</td>
			</tr>
		</table>
		<table border="8" align="center" width="720px">
			<tr>
				<th>编号</th>
				<th>评价</th>
			</tr>
			<c:forEach var="evaluation" items="${page.list}" varStatus="i">
				<tr>
					<td>${i.index + 1}</td>
					<td>${evaluation.foodEvaluation}</td>
				</tr>
			</c:forEach>
			<c:if test="${page.list.isEmpty()}">
				<h3 align="center">该食物暂无评价</h3>
			</c:if>
		</table>
	</c:if>
	
	
	
	
	
	
</body>
</html>