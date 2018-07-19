package com.topview.www.controller.myAddress;

import com.topview.www.constant.Regex;
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
import java.util.ArrayList;
import java.util.List;

public class AddMyAddressServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传过来的参数
        String linkman = req.getParameter("linkman");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        //errorList存放错误信息结果集合
        List<String> errorList = new ArrayList<String>();
        //对所有信息进行判断
        if(linkman == null || linkman.equals("")) {
            errorList.add("联系人不能为空");
        }
        if(phone == null || !phone.matches(Regex.REGEX_PHONE)) {
            errorList.add("手机号非法!!!");
        }
        if(address == null || address.equals("")) {
            errorList.add("地址不能为空");
        }
        //如果不为空，说明信息填写错误，返回显示错误信息
        if(!errorList.isEmpty()) {
            req.setAttribute("errorList", errorList);
            req.getRequestDispatcher(UserPathConstants.MY_ADDRESS_JSP_PATH).forward(req, resp);
            return;
        }
        //从session中获取user对象
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        //封装我的地址对象
        MyAddress myAddress = new MyAddress(user.getUserId(), linkman, phone, address);
        //获取我的地址业务处理对象
        MyAddressService myAddressService = new MyAddressService();
        if(myAddressService.addMyAddress(myAddress)) {
            //添加我的地址成功
            req.getRequestDispatcher(UserPathConstants.FIND_ALL_MY_ADDRESS_SERVLET_PATH).forward(req, resp);
        }else {
            System.out.println("保存失败");
        }
    }
}
