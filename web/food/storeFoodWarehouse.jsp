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
	<title>食品仓库页面</title>
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
	<jsp:include page="../store/storeMenu.jsp"></jsp:include>
	<h3>食品仓库</h3>
	<h4>${FindFoodByStoreIdResult}</h4>
	<div class="parent">
		<div class="myCss">
			<c:forEach var="food" items="${foodList}">
				<ul>
					<li>
						<img alt="" src="Image/food/${food.foodImage}" width="80px" height="80px"><br>
						<c:out value="名称:${food.foodName}"></c:out><br>
						<c:out value="价格:${food.foodPrice}"></c:out><br>
						<c:out value="销量:${food.foodSales}"></c:out><br>
						<c:out value="说明:${food.foodComments}"></c:out><br>
						<c:out value="类型:${food.foodType}"></c:out><br>
						<c:out value="库存:${food.foodNum}"></c:out><br>
						<c:choose>
							<c:when test="${food.foodState==1}">
								<c:out value="状态:未提交审核"></c:out><br>
								<c:set value="提交审核" var="operate"></c:set>
							</c:when>
							<c:when test="${food.foodState==2}">
								<c:out value="状态:正在审核"></c:out><br>
							</c:when>
							<c:when test="${food.foodState==3}">
								<c:out value="状态:审核成功"></c:out><br>
								<c:set value="上架" var="operate"></c:set>
							</c:when>
							<c:when test="${food.foodState==4}">
								<c:out value="状态:审核失败"></c:out><br>
								<c:set value="删除" var="operate"></c:set>
							</c:when>
							<c:when test="${food.foodState==5}">
								<c:out value="状态:上架中"></c:out><br>
								<c:set value="下架" var="operate"></c:set>
							</c:when>
							<c:when test="${food.foodState==6}">
								<c:out value="状态:已经下架"></c:out><br>
								<c:set value="删除" var="operate"></c:set>
							</c:when>
						</c:choose>
						<c:if test="${food.foodState!=2}">
							<form action="food/FoodStateOperateServlet" method="post">
								<input type="hidden" value="${food.id}" name="foodId">
								操作：<input type="submit" value="${operate}" name="operate">
							</form>
						</c:if>
						<c:if test="${food.foodState==6}">
							<form action="food/FoodStateOperateServlet" method="post">
								<input type="hidden" value="${food.id}" name="foodId">
								<input type="submit" value="上架" name="operate">
							</form>
						</c:if>
						<c:if test="${food.foodState==5}">
							<form action="food/UpdateFoodNumServlet" method="post">
								<input type="hidden" value="${food.id}" name="foodId">
								<input type="text" name="foodNum">
								<input type="submit" value="设置库存" name="operate">
							</form>
						</c:if>
					</li>
				</ul>
			</c:forEach>
		</div>
	</div>
</body>
</html>