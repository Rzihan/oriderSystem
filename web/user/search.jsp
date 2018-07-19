<%@taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql_rt"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>搜索文本框页面</title>
	<style type="text/css">
	    .box{
	        width: 380px;
	        margin: 30px auto;
	        font-size: 14px;
	        position:relative; 
	    }
	    .input{
	        width: 260px;
	        border: 1px solid #e2e2e2;
	        height: 30px;
	        float: left;
	        background-repeat: no-repeat;
	        background-position:5px center;
	    }
	    .search{
	        width: 78px;
	        height: 32px;
	        float: right;
	        background: black;
	        color: white;
	        text-align: center;
	        line-height: 32px;
	        cursor: pointer;
	    }
	    
	</style>
</head>
<body>
	<div class="box">
		<form action="user/UserSearchServlet" method="post">
			<input type="text" name="search" class="input"><br>
			<input type="submit" value="搜索" class="search"><br>
			<input type="radio" name="searchType" value="美食" checked="checked">美食&nbsp;&nbsp;&nbsp;
			<input type="radio" name="searchType" value="店铺">店铺&nbsp;&nbsp;&nbsp;
		</form>
	</div>
</body>
</html>