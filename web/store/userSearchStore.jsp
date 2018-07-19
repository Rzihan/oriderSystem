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
	<link rel="stylesheet" href="css/common.css" type="text/css" media="all" />
	<title>用户搜索店铺界面</title>
</head>
<body>
	<jsp:include page="../user/userIndex.jsp"/>
	<!-- ====================== 展示用户查询店铺的结果 ======================= -->
	<c:if test="${page.list == null || page.list.isEmpty()}"><h1 align="center">sorry，查不到相关店铺</h1></c:if>
	<c:if test="${page.list != null && !page.list.isEmpty()}">
		<table border="8" align="center" width="720px">
			<tr>
				<th width="80px">图片</th>
				<th>店名</th>
				<th>类型</th>
				<th>销量</th>
				<th>评分</th>
				<th>说明</th>
				<th>地点</th>
				<th>操作</th>
			</tr>
		<c:forEach var="store" items="${page.list}">
			<tr>
				<td><img alt="" src="Image/store/${store.storeLogo}" width="80px" height="80px"></td>
				<td>${store.storeName}</td>
				<td>${store.storeType}</td>
				<td>${store.storeSales}</td>
				<td>${store.storeGrade}</td>
				<td>${store.storeComments}</td>
				<td>${store.storeAddress}</td>
				<td>
					<form action="store/EnterStoreServlet" method="post" target="_blank">
						<input type="hidden" name="storeId" value="${store.id}">
						<input type="hidden" name="storeName" value="${store.storeName}">
						<input type="submit" value="进入店铺">
					</form>
				</td>
			</tr>
		</c:forEach>
		</table>
		<ul style="text-align: center">
			<li>
				<a href="user/UserSearchServlet?currentPage=1&search=${search}&searchType=${searchType}">首页</a>
				<a href="user/UserSearchServlet?currentPage=${page.currentPage==1? page.currentPage : page.currentPage-1}&search=${search}&searchType=${searchType}">上一页</a>
				<c:out value="第${page.currentPage}页/共${page.totalPages}页"/>
				<a href="user/UserSearchServlet?currentPage=${page.currentPage==page.totalPages? page.currentPage : page.currentPage+1 }&search=${search}&searchType=${searchType}">下一页</a>
				<a href="user/UserSearchServlet?currentPage=${page.totalPages}&search=${search}&searchType=${searchType}">尾页</a></li>
		</ul>
	</c:if>
</body>
</html>