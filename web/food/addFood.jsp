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
	<title>添加商品到仓库</title>
	<style type="text/css">
		.parent {
			position:absolute;
   			top:20%;
    		left:32%;
            width: 480px;
		    height: 250px;
		    border: 2px solid #000;
		    text-align: center;
		    z-index:-100;
        }
        .child {
            width: 350px;
		    height: 250px;
		    display: inline-block;
		    background-color: #607D8B;
        }
	</style>
</head>
<body>
	<jsp:include page="../store/storeMenu.jsp"></jsp:include>
	<div class="parent">
		<div class="child">
			<form action="food/AddFoodServlet" method="post" enctype="multipart/form-data">
				名称：<input type="text" name="foodName"><br>
				类型：<input type="text" name="foodType"><br>
				价格：<input type="text" name="foodPrice"><br><br>
				描述：<textarea rows="3" cols="15" name="foodComments"></textarea><br><br>
				图片:&nbsp;&nbsp;&nbsp;<input type="file" name="foodImg"><br><br>
				<input type="hidden" name="storeId" value="${store.id}">
				<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置"><br><br>
			</form>
		</div>
	</div>
</body>
</html>