package com.topview.www.controller.user;

import com.topview.www.constant.Regex;
import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.User;
import com.topview.www.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传过来的值
        String userLoginId = req.getParameter("userLoginId");
        String userPassword = req.getParameter("userPassword");
        String userNickname = req.getParameter("userNickname");
        String userEmail = req.getParameter("userEmail");
        //设置一个List，用于存放错误信息，若不为空，返回页面显示错误信息
        List<String> errorList = new ArrayList<>();
        //进行非空判断，手机号格式判断
        if(userLoginId == null || !userLoginId.matches(Regex.REGEX_PHONE)) {
            errorList.add("手机号非法!!!");
        }
        //对密码进行非空判断和长度判断
        if(userPassword == null || userPassword.length() < 6) {
            errorList.add("密码不能少于六位!!!");
        }
        //对昵称进行非空判断和长度判断
        if(userNickname == null || userNickname.length() == 0) {
            errorList.add("昵称不能为空!!!");
        }
        //进行非空判断，邮箱格式判断
        if(userEmail == null || !userEmail.matches(Regex.REGEX_EMAIL)) {
            errorList.add("邮箱不合法!!!");
        }
        //判断List集合是否为空，若不为空，表示输入的信息有误，返回注册失败页面，将错误信息显示出来
        if(!errorList.isEmpty()) {
            req.setAttribute("errorList", errorList);
            req.getRequestDispatcher(UserPathConstants.SIGN_IN_FAILURE_PAGE).forward(req, resp);
            return;
        }
        //将得到的数据封装成对象
        User user = new User(userLoginId, userPassword, userNickname, userEmail);
        //获取业务逻辑处理对象
        UserService userService = UserService.getInstance();
        String path = userService.signIn(user, errorList);
        req.setAttribute("errorList", errorList);
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
