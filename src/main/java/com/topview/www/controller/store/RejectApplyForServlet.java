package com.topview.www.controller.store;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.AdminPathConstants;
import com.topview.www.po.Store;
import com.topview.www.service.StoreService;

public class RejectApplyForServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		StoreService storeService = StoreService.getInstance();
		//拒绝用户申请的操作
		storeService.rejectApplyFor(new Store(id));
		req.getRequestDispatcher(AdminPathConstants.FIND_ALL_APPLY_FOR_STORE_SERVLET_PATH).forward(req, resp);
	}
}
