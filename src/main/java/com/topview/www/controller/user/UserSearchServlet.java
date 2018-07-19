package com.topview.www.controller.user;

import com.topview.www.constant.FoodConstants;
import com.topview.www.constant.PageConstants;
import com.topview.www.constant.StorePathConstants;
import com.topview.www.constant.UserPathConstants;
import com.topview.www.po.Food;
import com.topview.www.bo.Page;
import com.topview.www.po.Store;
import com.topview.www.service.FoodService;
import com.topview.www.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户查询店铺
 */
public class UserSearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = req.getParameter("search");//获取搜索条件
		String searchType = req.getParameter("searchType"); //获取搜索类型
		//判断搜索类型，调用不同的方法
		if(FoodConstants.SERRCH_STORE.equals(searchType)) {
			Page<Store> page = new Page<>();
			page.setPageSize(PageConstants.PAGE_SIZE);
			page.setCurrentPage(PageConstants.CURRENT_PAGE);
			if(req.getParameter("currentPage") != null) {
				page.setCurrentPage(Integer.parseInt(req.getParameter("currentPage")));
			}
			StoreService storeService = StoreService.getInstance();//创建搜索的业务逻辑类
			//搜索店铺,获取店铺结果集
			storeService.userSearchStores(search, page);
			//放入request中，请求转发
			req.setAttribute("page", page);
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.getRequestDispatcher(StorePathConstants.USER_SEARCH_STORE_JSP_PATH).forward(req, resp);
		}else {
			//创建页面对象
			Page<Food> page = new Page<>();
			//设置每页的大小
			page.setPageSize(PageConstants.PAGE_SIZE);
			//设置默认当前页
			page.setCurrentPage(PageConstants.CURRENT_PAGE);
			if(req.getParameter("currentPage") != null) {
				//如果从页面传来当前页的信息
				page.setCurrentPage(Integer.parseInt(req.getParameter("currentPage")));
			}
			FoodService foodService = FoodService.getInstance();
			foodService.getPutAwayFoodsBySearch(search, page);
			req.setAttribute("page", page);
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.getRequestDispatcher(UserPathConstants.USER_SEARCH_FOODS_JSP_PATH).forward(req, resp);
		}
	}
}
