package com.topview.www.controller.store;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.StorePathConstants;
import com.topview.www.po.Store;
import com.topview.www.po.User;
import com.topview.www.service.StoreService;

public class FindApplyForStoreServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = ((User)req.getSession().getAttribute("user")).getUserId();
		StoreService storeService = StoreService.getInstance();
		Store store = storeService.getStoreByUserId(userId);
		if(store != null) {
			//判断用户是否已经申请了开店了，如果申请开店了，转到查看用户开店申请的页面
			req.setAttribute("store", store);
			req.getRequestDispatcher(StorePathConstants.FIND_APPLY_FOR_STORE_JSP_PATH).forward(req, resp);
		}else {		
			req.getRequestDispatcher(StorePathConstants.APPLY_FOR_STORE_JSP_PATH).forward(req, resp);
		}
	}
}
