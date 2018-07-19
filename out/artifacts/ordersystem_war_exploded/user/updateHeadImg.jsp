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
	<link rel="stylesheet" href="css/common.css" type="text/css" media="all" />
	<title>修改头像</title>
</head>
<body class="body">
	<jsp:include page="../menu.jsp"/>
	<c:out value="${updateHeadImgResult}"/>
	<div>
		<h1>修改头像页面</h1><br>
		<img class="image" alt="头像" src="Image/headportrait/${user.userHeadportrait}"><br><br><br>
	</div>
	<form action="user/UpdateHeadImageServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="headportraitImg">
		<input type="submit" value="保存修改"><br><br>
	</form>
	<a href="user/userManage.jsp">返回</a>
</body>
</html>