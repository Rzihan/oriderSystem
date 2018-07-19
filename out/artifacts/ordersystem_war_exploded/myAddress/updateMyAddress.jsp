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
	<title>更新地址信息</title>
	<base href="<%=basePath%>">
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
<body style="text-align:center">
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>更新我的地址页面</h3>
	<form action="myAddress/UpdateMyAddressServlet" method="post" onsubmit="return check()">
		<c:out value="联系人:  "></c:out>
		<input type="text" name="linkman" value="${myAddress.linkman}"><br><br>
		<c:out value="联系电话:  "></c:out>
		<input type="text" name="phone" value="${myAddress.phone}"><br><br>
		<c:out value="地址:  "></c:out>
		<input type="text" name="address" value="${myAddress.address}"><br><br>
		<input type="hidden" name="id" value="${myAddress.id}">
		<input type="submit" value="保存修改"><br>
		<a href="myAddress/FindAllMyAddressServlet">返回</a>
	</form>
</body>
</html>