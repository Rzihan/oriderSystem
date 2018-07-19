package com.topview.www.controller.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.AdminPathConstants;
import com.topview.www.service.FoodService;
import com.topview.www.bo.CheckFood;

public class FindAllCheckingFoodServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FoodService foodService = FoodService.getInstance();
		List<CheckFood> checkFoodList = foodService.getCheckingFoods();
		req.setAttribute("checkFoodList", checkFoodList);
		req.getRequestDispatcher(AdminPathConstants.CHECK_FOOD_APPLY_FOR_JSP_PATH).forward(req, resp);
	}
}
