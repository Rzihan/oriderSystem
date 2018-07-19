package com.topview.www.controller.myAddress;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.UserPathConstants;
import com.topview.www.service.MyAddressService;

public class DeleteMyAddressServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前段传过来的deleteId，转换成int类型
		String deleteId = req.getParameter("deleteId");
		int myAddressId = Integer.parseInt(deleteId);
		//获取我的地址业务处理对象
		MyAddressService myAddressService = MyAddressService.getInstance();
		if(myAddressService.deleteMyAddress(myAddressId)) {
			//删除成功
			req.getRequestDispatcher(UserPathConstants.FIND_ALL_MY_ADDRESS_SERVLET_PATH).forward(req, resp);
		}else {
			//删除失败
			System.out.println("删除我的地址失败");
		}
	}				
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
