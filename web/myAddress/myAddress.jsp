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
	<title>我的收货地址</title>
</head>
<body style="text-align:center">
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>我的收货地址</h3>
	<c:if test="${updateErrorList != null}">
		<c:forEach var="error" items="${updateErrorList}">
			<c:out value="${error}"></c:out>
		</c:forEach>
	</c:if>
	<table border="1" align="center">
		<tr>
			<th><c:out value="编号"></c:out></th>
			<th><c:out value="联系人"></c:out></th>
			<th><c:out value="联系电话"></c:out></th>
			<th><c:out value="收货地址"></c:out></th>
			<th><c:out value="操作"></c:out></th>
		</tr>	
		<c:forEach var="myAddress" items="${findAllMyAddressList}" varStatus="i">
			<tr>
				<td><c:out value="${i.index}"></c:out></td>
				<td><c:out value="${myAddress.linkman}"></c:out></td>
				<td><c:out value="${myAddress.phone}"></c:out></td>
				<td><c:out value="${myAddress.address}"></c:out></td>
				<td>
					<form action="myAddress/FindMyAddressServlet" method="post">
						<input type="hidden" name="id" value="${myAddress.id}">
						<input type="submit" value="更新">	
					</form>
					<form action="myAddress/DeleteMyAddressServlet" method="post">
						<input type="hidden" name="deleteId" value="${myAddress.id}">
						<input type="submit" value="删除">	
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="myAddress/addMyAddress.jsp">新增收货地址</a>
	<a href="user/UserManageServlet">返回</a>




</body>
</html>