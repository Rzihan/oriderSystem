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
	<title>审核店铺申请</title>
</head>
<body style="text-align: center">
	<jsp:include page="adminMenu.jsp"></jsp:include>
	<h2>审核店铺申请</h2>
	<c:if test="${storeList != null}">
		<table border="1" align="center">
			<tr>
				<th><c:out value="编号"></c:out></th>
				<th><c:out value="用户id"></c:out></th>
				<th><c:out value="店铺名"></c:out></th>
				<th><c:out value="主卖类型"></c:out></th>
				<th><c:out value="店铺说明"></c:out></th>
				<th><c:out value="店铺地址"></c:out></th>
				<th><c:out value="审核状态"></c:out></th>
				<th><c:out value="操作"></c:out></th>
			</tr>
			<c:forEach var="store" items="${storeList}" varStatus="i">
				<tr>
					<td><c:out value="${i.index + 1}"></c:out></td>
					<td><c:out value="${store.userId}"></c:out></td>
					<td><c:out value="${store.storeName}"></c:out></td>
					<td><c:out value="${store.storeType}"></c:out></td>
					<td><c:out value="${store.storeComments}"></c:out></td>
					<td><c:out value="${store.storeAddress}"></c:out></td>
					<td><c:out value="${store.applyForState == 1 ? '待审核' : '运营状态'}"></c:out></td>
					<td>
						<c:if test="${store.applyForState == 2}">
							<form action="store/CloseStoreServlet" method="post">
								<input type="hidden" name="id" value="${store.id}">
								<input type="hidden" name="userId" value="${store.userId}">
								<input type="submit" value="关闭店铺">
							</form>
						</c:if>
						<c:if test="${store.applyForState == 1}">
							<form action="store/ApprovalApplyForServlet" method="post">
								<input type="hidden" name="id" value="${store.id}">
								<input type="hidden" name="userId" value="${store.userId}">
								<input type="submit" value="批准开店">
							</form>
							<form action="store/RejectApplyForServlet" method="post">
								<input type="hidden" name="id" value="${store.id}">
								<input type="submit" value="撤销审核">
							</form>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="admin/adminIndex.jsp">返回</a>
</body>
</html>