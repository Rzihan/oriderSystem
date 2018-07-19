package com.topview.www.controller.myAddress;

import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.MyAddress;
import com.topview.www.po.User;
import com.topview.www.service.MyAddressService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FindAllMyAddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        MyAddressService myAddressService = new MyAddressService();
        List<MyAddress> findAllMyAddressList = myAddressService.findAllMyAddress(user);
        //调用请求转发，响应客户端
        req.setAttribute("findAllMyAddressList", findAllMyAddressList);
        req.getRequestDispatcher(UserPathConstants.MY_ADDRESS_JSP_PATH).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


}
