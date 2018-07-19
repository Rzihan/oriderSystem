<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" href="<%=path%>/css/common.css" type="text/css" media="all" />
	<title>个人操作界面</title>
</head>
<body class="body">
	<jsp:include page="../menu.jsp"></jsp:include>
	<div>
		头像：<br>
		<img src="Image/headportrait/${user.userHeadportrait}" class="image"><br>
	</div>
	<a href="user/updateHeadImg.jsp">修改头像</a><br><br>
	昵称:${user.userNickname}<br>
	<div>
		<a href="user/personalInformation.jsp" >个人信息</a><br>
		<a href="myAddress/FindAllMyAddressServlet" >我的地址</a><br>
		<a href="store/FindApplyForStoreServlet" >我要合作</a><br>
		<a href="user/ExitServlet" >安全退出</a><br>
	</div>	
</body>
</html>