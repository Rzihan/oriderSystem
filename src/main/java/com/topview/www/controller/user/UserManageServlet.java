package com.topview.www.controller.user;

import com.topview.www.po.User;
import com.topview.www.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 点击用户菜单栏上的我的，对应的Servlet
 */
public class UserManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session中回去user对象
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        //获取用户业务逻辑处理对象
        UserService userService = UserService.getInstance();
        //传入User对象去接收结果
        String path = userService.findMyManage(user);
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
