package com.topview.www.controller.food;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.StorePathConstants;
import com.topview.www.po.Food;
import com.topview.www.service.FoodService;
import com.topview.www.util.MyUploadUtil;

public class AddFoodServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//定义允许上传的文件类型
		final String allowedExt[] = {"JPG","GIF","PNG","jpg","gif","png"};
		//获取web应用在web服务器上的绝对路径，用来保存文件
		String realWebBase = req.getSession().getServletContext().getRealPath("/");
		String savePath = realWebBase + "Image/food";
		//文件保存目录下创建临时文件保存目录
		String tempFile = realWebBase + "Image/temp";
		//创建文件上传工具类对象，把文件保存路径等作为参数初始化该对象
		MyUploadUtil myUpload = new MyUploadUtil(allowedExt,savePath,tempFile);
		//对象调用upload方法实现上传功能
		myUpload.upload(req);
		
		Map<String,String> map = myUpload.getTextContent();
		Food food = new Food(Integer.parseInt(map.get("storeId")), map.get("foodName"),
				map.get("foodPrice"), map.get("foodComments"), map.get("foodType"),
				map.get("image"));
		FoodService foodService = FoodService.getInstance();
		if(foodService.addFood(food)) {
			System.out.println("添加食物成功");
			req.getRequestDispatcher(StorePathConstants.FIND_FOOD_BY_STORE_ID_SERVLET_PATH).forward(req, resp);
		}else {
			System.out.println("添加食物失败");
		}
	}
}
