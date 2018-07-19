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
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户主界面</title>
	<style type="text/css">
		.myCss ul,li{
			margin:5px;
			padding:10px;
			list-style: none;
		}
		.myCss ul{
			width:190px;
			background:gray;
			float:left;
		}
		.content{
			margin-left:20px;
		}
		.parent {
            width: 1200px;
		    height: 450px;
		    border: 2px solid #000;
		    text-align: center;
		    left:50px;
		    top:140px;
		    position: absolute;
        }
		</style>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<jsp:include page="search.jsp"></jsp:include>
</body>
</html>