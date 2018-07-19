package com.topview.www.controller.user;

import com.topview.www.constant.UserPathConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ExitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //清除session中的user，role，和store
        session.removeAttribute("user");
        session.removeAttribute("role");
        session.removeAttribute("store");
        //请求重定向到login.jsp页面
        req.getRequestDispatcher(UserPathConstants.LOGIN_JSP_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
