package com.topview.www.controller.store;

import com.topview.www.bo.Page;
import com.topview.www.constant.PageConstants;
import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.Food;
import com.topview.www.service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EnterStoreServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1084451778723590708L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String storeName = req.getParameter("storeName");//获取店铺名
		String storeIdStr = req.getParameter("storeId");//获取店铺编号
		int storeId = Integer.parseInt(storeIdStr);//转换成int型
		Page<Food> page = new Page<>();
		page.setPageSize(PageConstants.PAGE_SIZE);
		page.setCurrentPage(PageConstants.CURRENT_PAGE);
		if(req.getParameter("currentPage") != null) {
			page.setCurrentPage(Integer.parseInt(req.getParameter("currentPage")));
		}
		FoodService foodService = FoodService.getInstance();
		foodService.getPutAwayFoodsByStoreId(storeId, page);
		req.setAttribute("storeName",storeName);
		req.setAttribute("storeId",storeId);
		req.setAttribute("page", page);
		req.getRequestDispatcher(UserPathConstants.USER_ENTER_STORE_JSP_PATH).forward(req, resp);
	}
}
