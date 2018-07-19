package com.topview.www.controller.food;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.AdminPathConstants;
import com.topview.www.constant.FoodConstants;
import com.topview.www.constant.StorePathConstants;
import com.topview.www.service.FoodService;

public class FoodStateOperateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("foodId");//获取食物的编号
		String operate = req.getParameter("operate");//获取要对食物状态的操作
		FoodService foodService = FoodService.getInstance();
		if(foodService.changeFoodState(idStr, operate)) {
			//如果是系统管理员，转到系统管理员对应的页面
			if(FoodConstants.CHECK_SUCCESS.equals(operate) || FoodConstants.CHECK_FAILURE.equals(operate)) {
				req.getRequestDispatcher(AdminPathConstants.FIND_ALL_CHECKING_FOOD_SERVLET_PATH).forward(req, resp);
				return;
			}
			//转到店家查询页面
			req.getRequestDispatcher(StorePathConstants.FIND_FOOD_BY_STORE_ID_SERVLET_PATH).forward(req, resp);
		}else {
			System.out.println("操作失败");
		}
	}
}
