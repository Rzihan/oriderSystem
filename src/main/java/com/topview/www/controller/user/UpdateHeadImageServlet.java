package com.topview.www.controller.user;

import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.User;
import com.topview.www.service.UserService;
import com.topview.www.util.MyUploadUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UpdateHeadImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //返回结果的字符串
        String result = "";
        //定义允许上传的文件类型
        final String allowedExt[] = {"JPG","GIF","PNG","jpg","gif","png"};
        //获取web应用在web服务器上的绝对路径，用来保存文件
        String realWebBase = req.getSession().getServletContext().getRealPath("/");
        String savePath = realWebBase + UserPathConstants.USER_HEAD_IMAGE_PATH;
        //文件保存目录下创建临时文件保存目录
        String tempFile = realWebBase + UserPathConstants.TEMP_FILE_PATH;
        //创建文件上传工具类对象，把文件保存路径等作为参数初始化该对象
        MyUploadUtil myUpload = new MyUploadUtil(allowedExt,savePath,tempFile);
        User user = (User)req.getSession().getAttribute("user");
        //对象调用upload方法实现上传功能
        myUpload.upload(req);
        //获取上传表单的其他内容
        Map<String,String> map = myUpload.getTextContent();
        //如果不为空，表明上传成功
        if(!map.isEmpty()) {
            user.setUserHeadportrait(map.get("image"));
            UserService userService = UserService.getInstance();
            if(userService.updateUserHeadImage(user)) {
                result = "保存成功";
            }else {
                result = "保存失败";
            }
        }else {
            result = "文件上传失败，请选择JPG,GIF,PNG格式的文件";
        }
        req.setAttribute("updateHeadImgResult", result);
        req.getRequestDispatcher(UserPathConstants.UPDATE_HEAD_IMAGE_JSP_PATH).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
