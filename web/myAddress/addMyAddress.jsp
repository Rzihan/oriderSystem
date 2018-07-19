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
	<title>新增收货地址</title>
	<script type="text/javascript">
		function check(){
			//手机号正则表达式
			var regPhone = /^1[3|4|5|7|8][0-9]{9}$/;
			var linkman = document.getElementsByName("linkman")[0];
			var phone = document.getElementsByName("phone")[0];
			var address = document.getElementsByName("address")[0];
			if(linkman.value == ""){
				alert("联系人不能为空");
				return false;
			}
			if(!regPhone.test(phone.value)){
				alert("手机号非法");
				return false;
			}
			if(address.value == ""){
				alert("地址不能为空");
				return false;
			}
			return true;
		}
	</script>
</head>
<body style="text-align: center">
	<c:if test="${errorList != null}">
		<c:forEach var="error" items="${errorList}">
			<c:out value="${error}"></c:out>
		</c:forEach>
	</c:if>
	<h1>新增收货地址页面</h1>
	<form action="myAddress/AddMyAddressServlet" method="post" onsubmit="return check()">
		联系人：<input type="text" name="linkman"><br><br>
		联系电话：<input type="text" name="phone"><br><br>
		收货地址：<input type="text" name="address"><br><br>
		<input type="submit" value="保存"><br><br>
	</form>
	<a href="myAddress/FindAllMyAddressServlet">返回</a>
</body>
</html>