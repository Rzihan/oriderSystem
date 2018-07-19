package com.topview.www.controller.order;

import com.topview.www.po.Food;
import com.topview.www.po.MyAddress;
import com.topview.www.po.User;
import com.topview.www.service.FoodService;
import com.topview.www.service.MyAddressService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FillInOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取用户id
		HttpSession session = req.getSession();
		User u = (User)session.getAttribute("user");
		//根据user获取地址信息
		MyAddressService myAddressService = new MyAddressService();
		List<MyAddress> myAddressList = myAddressService.findAllMyAddress(u);
		//根据foodId获取食物信息
		String foodId = req.getParameter("foodId");
		FoodService foodService = FoodService.getInstance();
//		Food food = foodService.getFoodByFoodId(Integer.parseInt(foodId));
//		req.setAttribute("myAddressList", myAddressList);
//		req.setAttribute("food", f);
//		req.getRequestDispatcher("/order/comfirmOrder.jsp").forward(req, resp);
	}
}
