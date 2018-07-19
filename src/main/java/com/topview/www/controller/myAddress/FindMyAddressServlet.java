package com.topview.www.controller.myAddress;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.MyAddress;
import com.topview.www.service.MyAddressService;

public class FindMyAddressServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前端传过来的地址id信息，并转换为int类型
		String myAddressId = req.getParameter("id");
		int id = Integer.parseInt(myAddressId);
		MyAddressService myAddressService = MyAddressService.getInstance();
		MyAddress myAddress = myAddressService.findMyAddressById(id);
		if(myAddress != null) {
			//如果不为空，表示成功，跳转到更新地址页面
			req.setAttribute("myAddress", myAddress);
			req.getRequestDispatcher(UserPathConstants.UPDATE_MY_ADDRESS_JSP_PATH).forward(req, resp);
		}else {
			//查询失败，返回当前的页面
			req.getRequestDispatcher(UserPathConstants.FIND_ALL_MY_ADDRESS_SERVLET_PATH).forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
