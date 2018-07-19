<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page import="java.util.*" %>
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
	<title>审核要食物页面</title>
	<style type="text/css">
		.myCss ul,li{
			margin:5px;
			padding:0px;
			list-style: none;
		}
		.myCss ul{
			width:190px;
			background:gray;
			float:left;
		}
		.content{
			margin-left:20px;
		}
		.parent {
            width: 800px;
		    height: 500px;
		    border: 2px solid #000;
		    text-align: center;
		    margin-left:auto;
		    margin-right:auto;
        }
		</style>
</head>
<body>
	<jsp:include page="../admin/adminMenu.jsp"/>
	<div class="parent">
		<div class="myCss">
			<c:forEach var="checkFood" items="${checkFoodList}">
				<ul>
					<li>
						<img alt="" src="Image/food/${checkFood.foodImage}" width="80px" height="80px"><br>
						<c:out value="名称:${checkFood.foodName}"/><br>
						<c:out value="价格:${checkFood.foodPrice}"/><br>
						<c:out value="说明:${checkFood.foodComments}"/><br>
						<c:out value="类型:${checkFood.foodType}"/><br>
						<c:out value="店铺:${checkFood.storeName}"/><br>
						<form action="food/FoodStateOperateServlet" method="post">
							<input type="hidden" value="${checkFood.id}" name="foodId">
							<input type="submit" name="operate" value="审核通过">
						</form>
						<form action="food/FoodStateOperateServlet" method="post">
							<input type="hidden" value="${checkFood.id}" name="foodId">
							<input type="submit" name="operate" value="审核失败">
						</form>

					</li>
				</ul>
			</c:forEach>

		</div>
	</div>
</body>
</html>