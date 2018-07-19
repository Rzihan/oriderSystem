package com.topview.www.controller.user;

import com.topview.www.constant.Regex;
import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.User;
import com.topview.www.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateInformationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传过来的值
        String userNickname = req.getParameter("userNickname");
        String userEmail = req.getParameter("userEmail");
        //设置errorList用户存放错误信息
        List<String> errorList = new ArrayList<>();
        //判断昵称不为空
        if(userNickname == null || userNickname.length() == 0) {
            errorList.add("昵称不能为空!!!");
        }
        //判断邮箱格式
        if(userEmail == null || !userEmail.matches(Regex.REGEX_EMAIL)) {
            errorList.add("邮箱不合法!!!");
        }
        //如果errorList不为空，表示填入的信息有误，返回更新个人信息页面，显示错误信息
        if(!errorList.isEmpty()) {
            req.setAttribute("errorList", errorList);
            req.getRequestDispatcher(UserPathConstants.PERSONAL_INFORMATION_JSP_PATH).forward(req, resp);
            return;
        }
        //获取user对象
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        user.setUserEmail(req.getParameter("userEmail"));
        user.setUserNickname(req.getParameter("userNickname"));
        //获取用户业务逻辑处理对象
        UserService userService = UserService.getInstance();
        if(userService.updateMyManage(user)) {
            //更新成功，将新的user设置到session中，跳转到更新个人信息页面
            session.setAttribute("user", user);
            req.setAttribute("updateResult", "保存成功！");
        }else {
            //更新失败，将更新结果设置到request中，跳转到更新个人信息页面，显示结果
            req.setAttribute("updateResult", "保存失败！");
        }
        req.getRequestDispatcher(UserPathConstants.PERSONAL_INFORMATION_JSP_PATH).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
