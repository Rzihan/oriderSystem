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
	<title>申请开店资料填写页面</title>
	<base href="<%=basePath%>">
	<script type="text/javascript">
		function checkForm(){
			var storeName = document.getElementsByName("storeName")[0];
			var storeType = document.getElementsByName("storeType")[0];
			var storeAddress = document.getElementsByName("storeAddress")[0];
			var storeComments = document.getElementsByName("storeComments")[0];
			var logoImage = document.getElementsByName("logoImage")[0];
			
			if(storeName.value == ""){
				alert("店铺名不能为空");
				return false;
			}
			
			if(storeType.value == ""){
				alert("店铺类型不能为空");
				return false;
			}
			
			if(storeAddress.value == ""){
				alert("店铺地址不能为空");
				return false;
			}
			if(storeComments.value == ""){
				alert("店铺说明不能为空");
				return false;
			}
			if(logoImage.value == ""){
				alert("店铺Logo不能为空");
				return false;
			}
			
			return true;
		}
	
	</script>
</head>
<body style="text-align:center">
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>请填写好开店申请资料</h3>
	<form action="store/ApplyForStoreServlet" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
		店 铺 名:<input type="text" name="storeName"><br><br>
		主卖类型:<input type="text" name="storeType"><br><br>
		店铺地址:<input type="text" name="storeAddress"><br><br>
		店铺说明:<textarea rows="10" cols="20" name="storeComments"></textarea><br><br>
		店铺Logo:<input type="file" name="logoImage"><br><br>
		<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置"><br><br>
	</form>
	<a href="user/UserManageServlet">返回</a>
</body>
</html>