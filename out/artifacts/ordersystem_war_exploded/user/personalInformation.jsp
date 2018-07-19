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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询个人信息</title>
	<base href="<%=basePath%>">
	<script type="text/javascript">
		function checkUpdateForm(){
			//邮箱正则表达式
			var regEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			var userNickname = document.getElementsByName("userNickname")[0];
			var userEmail = document.getElementsByName("userEmail")[0];
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
</head>
<body style="text-align: center">
	<form action="user/UpdateInformationServlet" method="post" onsubmit="return checkUpdateForm()">
		昵称：<input type="text" value="${user.userNickname}" name="userNickname"><br>
		邮箱：<input type="text" value="${user.userEmail}" name="userEmail"><br>
		<input type="submit" value="保存" >&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置" >&nbsp;&nbsp;&nbsp;<br><br>
	</form>
	<c:out value="手机号：${user.userLoginId}"></c:out><br>
	<c:out value="头像"></c:out>
	<div>
		<img src="Image/headportrait/${user.userHeadportrait}" style="width: 150px;height: 150px">
	</div>	
	<a href="user/userManage.jsp">返回</a>
	<div>
	<ol>
		<c:forEach var="error" items="${errorList}">
			<li><font color="red"><c:out value="${error}"></c:out></font><br></li>	
		</c:forEach>
	</ol>
	</div>
	<c:out value="${updateResult}"></c:out>
</body>
</html>