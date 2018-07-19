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
	<link rel="stylesheet" href="css/login.css" type="text/css" media="all" />	
	<script type="text/javascript">
		function checkLoginForm(){
			//手机号正则表达式
			var regPhone = /^1[3|4|5|7|8][0-9]{9}$/;
			var userLoginId = document.getElementsByName("userLoginId")[0];
			var userPassword = document.getElementsByName("userPassword")[0];
			
			if(!regPhone.test(userLoginId.value)){
				alert("手机号非法");
				return false;
			}
			
			if(userPassword.value == ""){
				alert("密码不能为空");
				return false;
			}
			
			if(userPassword.value.length < 6){
				alert("密码长度必须大于6");
				return false;
			}
			return true;
		}
	
	</script>
	<title>登录界面</title>
</head>
<body class="image">
	<div class="main">
		<h3>登录</h3>
		<form action="LoginServlet" method="post" onsubmit="return checkLoginForm()">
			手机号: <input type="text" name="userLoginId"><br><br>
			密&nbsp;&nbsp;&nbsp;码: <input type="password" name="userPassword"><br><br>
			<input type="radio" name="role" value="1" checked="checked">普通用户&nbsp;&nbsp;&nbsp;
			<input type="radio" name="role" value="2">商家&nbsp;&nbsp;&nbsp;
			<input type="radio" name="role" value="3">管理员<br><br>
			<input type="submit" value="登录">&nbsp;&nbsp;
			<input type="reset" value="重置"> <br><br>
		</form>
		<a href="user/signIn.jsp">还未注册？</a><br>
	</div>
		
	<div>
	<ol>
		<c:forEach var="error" items="${errorList}">
			<li>
				<font color="red"><c:out value="${error}"></c:out></font><br>
			</li>	
		</c:forEach>
	</ol>
	</div>
</body>
</html>