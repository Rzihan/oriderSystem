package com.topview.www.controller.store;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.topview.www.constant.StorePathConstants;
import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.Store;
import com.topview.www.po.User;
import com.topview.www.service.StoreService;
import com.topview.www.util.MyUploadUtil;

public class ApplyForStoreServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//定义允许上传的文件类型
		final String allowedExt[] = {"JPG","GIF","PNG","jpg","gif","png"};
		//获取web应用在web服务器上的绝对路径，用来保存文件
		String realWebBase = req.getSession().getServletContext().getRealPath("/");
		String savePath = realWebBase + StorePathConstants.STORE_IMAGE_PATH;
		//文件保存目录下创建临时文件保存目录
		String tempFile = realWebBase + UserPathConstants.TEMP_FILE_PATH;
		//创建文件上传工具类对象，把文件保存路径等作为参数初始化该对象
		MyUploadUtil myUpload = new MyUploadUtil(allowedExt,savePath,tempFile);
		//对象调用upload方法实现上传功能
		myUpload.upload(req);
		//获取上传表单的其他内容
		Map<String,String> map = myUpload.getTextContent();
		
		//从session获取User，再从获取userId
		HttpSession session = req.getSession();
		int userId = ((User)session.getAttribute("user")).getUserId();
		Store store = new Store(
				userId, map.get("storeName"), map.get("storeType"),
				map.get("storeComments"), map.get("storeAddress"), map.get("image")
		);
		StoreService storeService = StoreService.getInstance();
		if(storeService.applyForStore(store)) {
			System.out.println("店铺申请成功！");
			//跳转到查询申请状态页面
			req.getRequestDispatcher(StorePathConstants.FIND_APPLY_FOR_STORE_SERVLET_PATH).forward(req, resp);
		}else {
			System.out.println("店铺申请失败！");
		}

		
	}
}
