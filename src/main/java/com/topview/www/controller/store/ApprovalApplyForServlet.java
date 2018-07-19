package com.topview.www.controller.store;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.AdminPathConstants;
import com.topview.www.constant.StoreConstants;
import com.topview.www.po.Store;
import com.topview.www.service.StoreService;

public class ApprovalApplyForServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		String userIdStr = req.getParameter("userId");
		Store store = new Store();
		store.setId(Integer.parseInt(idStr));
		store.setUserId(Integer.parseInt(userIdStr));
		store.setCreateTime(new Date());
		store.setApplyForState(StoreConstants.CHECK_SUCCESS);
		StoreService storeService = StoreService.getInstance();
		storeService.approvalApply(store);
		req.getRequestDispatcher(AdminPathConstants.FIND_ALL_APPLY_FOR_STORE_SERVLET_PATH).forward(req, resp);
	}
	
}
