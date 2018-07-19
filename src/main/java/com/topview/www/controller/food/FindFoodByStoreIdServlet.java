package com.topview.www.controller.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.StorePathConstants;
import com.topview.www.po.Food;
import com.topview.www.po.Store;
import com.topview.www.service.FoodService;

public class FindFoodByStoreIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Store store = (Store)req.getSession().getAttribute("store");
		FoodService foodService = FoodService.getInstance();
		List<Food> list = foodService.findFoodsByStoreId(store.getId());
		if(!list.isEmpty()) {
			req.setAttribute("foodList", list);
		}else {
			req.setAttribute("FindFoodByStoreIdResult", "您的食品仓库空空的！！！");
		}
		req.getRequestDispatcher(StorePathConstants.FOOD_WARE_HOUSE_JSP_PATH).forward(req, resp);
		
	}
}
