package com.topview.www.controller.food;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.po.Food;
import com.topview.www.service.FoodService;

/**
 * 更新食物的库存
 */
public class UpdateFoodNumServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int foodId = Integer.parseInt(req.getParameter("foodId"));
		int foodNum = Integer.parseInt(req.getParameter("foodNum"));
		Food food = new Food();
		food.setId(foodId);
		food.setFoodNum(foodNum);
		FoodService foodService = FoodService.getInstance();
//		fs.updateFoodNum(f);
//		//请求转发到仓库页面
//		req.getRequestDispatcher("/food/FindFoodByStoreIdServlet").forward(req, resp);
	}
}
