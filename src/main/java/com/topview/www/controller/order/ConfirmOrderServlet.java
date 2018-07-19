package com.topview.www.controller.order;

import com.topview.www.po.OrderAndFoods;
import com.topview.www.po.User;
import com.topview.www.po.UserOrder;
import com.topview.www.service.UserOrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ConfirmOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取用户id
		HttpSession session = req.getSession();
		int userId = ((User)session.getAttribute("user")).getUserId();
		//获取联系地址ID
		int addressId = Integer.parseInt(req.getParameter("addressId"));
		//获取店铺id
		int storeId = Integer.parseInt(req.getParameter("storeId"));
		//获取订单与食物一对多关系类对象
		String foodId = req.getParameter("foodId");
		String foodNum = req.getParameter("foodNum");
		String foodPrice = req.getParameter("foodPrice");
//		OrderAndFoods oaf = new OrderAndFoods(Integer.parseInt(foodId), Integer.parseInt(foodNum), foodPrice);
//		String payPrice = Integer.parseInt(foodNum) * Integer.parseInt(foodPrice) + "";
//		//封装订单数据
//		UserOrder uo = new UserOrder(userId,addressId,storeId,payPrice);
//		//创建用户订单业务逻辑处理类
//		UserOrderService uoService = UserOrderService.getInstance();
//		if(uoService.userConfirmOrder(uo,oaf)) {
//			System.out.println("用户提交订单成功");
//			req.getRequestDispatcher("/order/comfirmOrderSuccess.jsp").forward(req, resp);
//		}else {
//			System.out.println("用户提交订单失败");
//		}
		
	}
}
