package com.topview.www.controller.user;

import com.topview.www.constant.Regex;
import com.topview.www.constant.StorePathConstants;
import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.User;
import com.topview.www.service.StoreService;
import com.topview.www.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传过来的值
        String userLoginId = req.getParameter("userLoginId");
        String userPassword = req.getParameter("userPassword");
        String roleIdStr = req.getParameter("role");
        int roleId = Integer.parseInt(roleIdStr);
        //创建一个errorList的集合，用户存放错误信息
        List<String> errorList = new ArrayList<>();
        //手机号非空和格式判断
        if(userLoginId == null || !userLoginId.matches(Regex.REGEX_PHONE)) {
            errorList.add("手机号非法!!!");
        }
        //密码非空和长度判断
        if(userPassword == null || userPassword.length() < 6) {
            errorList.add("密码不能少于六位!!!");
        }
        //如果不为空，说明存在错误信息，直接返回login.jsp页面
        if(!errorList.isEmpty()) {
            req.setAttribute("errorList", errorList);
            req.getRequestDispatcher(UserPathConstants.LOGIN_JSP_PATH).forward(req, resp);
            return;
        }

        //将数据封装成功对象
        User user = new User(userLoginId,userPassword);
        //获取业务逻辑处理对象
        UserService userService = UserService.getInstance();
        String path = userService.login(user, errorList, roleId);
        if(UserPathConstants.LOGIN_JSP_PATH.equals(path)) {
            req.setAttribute("errorList", errorList);
            req.getRequestDispatcher(path).forward(req, resp);
            return;
        }
        if(StorePathConstants.STORE_INDEX_JSP.equals(path)) {
            StoreService storeService = StoreService.getInstance();
            req.getSession().setAttribute("store", storeService.getStoreByUserId(user.getUserId()));
        }
        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("role", roleId);
        resp.sendRedirect(path);
    }
}
