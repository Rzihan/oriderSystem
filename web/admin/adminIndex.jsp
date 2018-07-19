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
	<title>系统管理员主界面</title>
</head>
<body style="text-align: center">
	<jsp:include page="adminMenu.jsp"></jsp:include>
	<h2>欢迎您，系统管理员！</h2>
	<c:out value="${role }"></c:out>
	<div>
		<ul style="list-style-type:none;">
			<li><a href="store/FindAllApplyForStoreServlet"><span>审批开店申请</span></a></li>
			<li><a href="food/FindAllCheckingFoodServlet"><span>商家商品审核</span></a></li>
			<li><a href="user/ExitServlet"><span>安全退出</span></a></li>
		</ul>
	</div>

</body>
</html>