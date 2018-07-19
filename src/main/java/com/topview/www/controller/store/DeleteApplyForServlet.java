package com.topview.www.controller.store;

import com.topview.www.constant.StorePathConstants;
import com.topview.www.po.Store;
import com.topview.www.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户删除自己的申请记录
 */
public class DeleteApplyForServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5242108730296197514L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		//执行删除操作
		if(StoreService.getInstance().deleteApplyFor(new Store(id))) {
			//删除成功，直接跳转到开店申请资料填写页面
			req.getRequestDispatcher(StorePathConstants.APPLY_FOR_STORE_JSP_PATH).forward(req, resp);
		}else {
			req.getRequestDispatcher(StorePathConstants.FIND_APPLY_FOR_STORE_SERVLET_PATH).forward(req, resp);
		}

	}
}
