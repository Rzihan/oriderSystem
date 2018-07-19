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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询店铺申请结果界面</title>
	<base href="<%=basePath%>">
</head>
<body style="text-align: center">
	<jsp:include page="../menu.jsp"></jsp:include>
	<h2>店铺申请进度查询页面</h2>
	<c:if test="${store != null}">
	<table border="1" align="center">
		<tr>
			<th><c:out value="店铺名"></c:out></th>
			<th><c:out value="主打类型"></c:out></th>
			<th><c:out value="店铺说明"></c:out></th>
			<th><c:out value="审核状态"></c:out></th>
			<c:if test="${store.applyForState == 3 }">
				<th><c:out value="操作"></c:out></th>
			</c:if>
		</tr>
		<tr>
			<td><c:out value="${store.storeName}"></c:out></td>
			<td><c:out value="${store.storeType}"></c:out></td>
			<td><c:out value="${store.storeComments}"></c:out></td>
			<c:choose>
				<c:when test="${store.applyForState == 1 }"><td>正在审核</td></c:when>
				<c:when test="${store.applyForState == 2 }"><td>审核成功</td></c:when>
				<c:when test="${store.applyForState == 3 }"><td>审核失败</td></c:when>
			</c:choose>
			<c:if test="${store.applyForState == 3 }">
				<td>
					<form action="store/DeleteApplyForServlet" method="post">
						<input type="hidden" value="${store.id}" name="id">	
						<input type="submit" value="删除">
					</form>
				</td>
			</c:if>
		</tr>
	</table>
	</c:if>
	<a href="user/UserManageServlet">返回</a>
</body>
</html>