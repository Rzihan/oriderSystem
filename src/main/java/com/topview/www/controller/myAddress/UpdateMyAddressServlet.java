package com.topview.www.controller.myAddress;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topview.www.constant.Regex;
import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.MyAddress;
import com.topview.www.service.MyAddressService;

public class UpdateMyAddressServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String linkman = req.getParameter("linkman");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		//判断提交上来的数据是否合法
		List<String> updateErrorList = new ArrayList<String>();
		if(linkman == null || linkman.length() == 0) {
			updateErrorList.add("联系人不能为空！");
		}
		if(phone == null || Regex.REGEX_PHONE.matches(phone)) {
			updateErrorList.add("手机号不合法！");
		}
		if(address ==null || address.length() == 0) {
			updateErrorList.add("手机号不合法！");
		}
		//返回错误信息
		if(!updateErrorList.isEmpty()) {
			req.setAttribute("updateErrorList", updateErrorList);
			req.getRequestDispatcher(UserPathConstants.FIND_ALL_MY_ADDRESS_SERVLET_PATH).forward(req, resp);
			return;
		}
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		MyAddress myAddress = new MyAddress(id,linkman,phone,address);
		MyAddressService myAddressService = MyAddressService.getInstance();
		if(!myAddressService.updateMyAddress(myAddress)){
			req.setAttribute("updateResult", "保存失败！");
		}
		req.getRequestDispatcher(UserPathConstants.FIND_ALL_MY_ADDRESS_SERVLET_PATH).forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
