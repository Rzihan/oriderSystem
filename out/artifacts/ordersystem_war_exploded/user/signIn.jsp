<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
		+ request.getServerPort() + path + "/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=path%>/css/mySignIn.css" type="text/css" media="all" />
	<link rel="stylesheet" href="<%=path%>/css/login.css" type="text/css" media="all" />
	<title>注册页面</title>
	<script type="text/javascript">
		
		function checkForm(){
			//手机号正则表达式
			var regPhone = /^1[3|4|5|7|8][0-9]{9}$/;
			//邮箱正则表达式
			var regEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			
			var userLoginId = document.getElementsByName("userLoginId")[0];
			var userPassword = document.getElementsByName("userPassword")[0];
			var userNickname = document.getElementsByName("userNickname")[0];
			var userEmail = document.getElementsByName("userEmail")[0];
			
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
			
			if(userNickname.value == ""){
				alert("昵称不能为空");
				return false;
			}
			
			if(!regEmail.test(userEmail.value)){
				alert("邮箱非法");
				return false;
			}
			return true;
		}
		
	</script>
	<base href="<%=basePath%>">
</head>
<body class="image">
	<div class="form">
		<form action="user/SignInServlet" method="post" onsubmit="return checkForm()">
			<h3>注册信息填写</h3>
			手机号： <input type="text" name="userLoginId"><br>
			密码： &nbsp;&nbsp;&nbsp;<input type="password" name="userPassword"><br>
			昵称： &nbsp;&nbsp;&nbsp;<input type="text" name="userNickname"><br>
			邮箱： &nbsp;&nbsp;&nbsp;<input type="text" name="userEmail"><br><br>
			<input type="submit" value="提交"> &nbsp;&nbsp;&nbsp;
			<input type="reset" value="重置"><br><br>
			<a href="login.jsp">返回登录界面</a>
		</form> 
	</div>
</body>
</html>