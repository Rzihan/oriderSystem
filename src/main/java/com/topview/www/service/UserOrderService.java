package com.topview.www.service;

/**
 * 用户订单业务逻辑处理类
 */
public class UserOrderService {
	
	private static volatile UserOrderService instance = null;
	
	private UserOrderService() {}

	public static UserOrderService getInstance() {
		if(instance == null) {
			synchronized(UserOrderService.class) {
				if(instance == null) {
					instance = new UserOrderService();
				}
			}
		}
		return instance;
	}

}
