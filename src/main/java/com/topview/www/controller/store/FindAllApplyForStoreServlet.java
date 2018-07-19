package com.topview.www.controller.store;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.AdminPathConstants;
import com.topview.www.po.Store;
import com.topview.www.service.StoreService;

public class FindAllApplyForStoreServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StoreService storeService = StoreService.getInstance();
		List<Store> storeList = storeService.findAllApplyForStore();
		req.setAttribute("storeList", storeList);
		req.getRequestDispatcher(AdminPathConstants.CHECK_APPLY_FOR_JSP_PATH).forward(req, resp);
	}
}
