package com.topview.www.service;

/**
 * 订单与食物一对多表的业务逻辑处理类
 */
public class OrderAndFoodsService {
	

	private static volatile OrderAndFoodsService instance = null;
	
	private OrderAndFoodsService() {}
	
	public static OrderAndFoodsService getInstance() {
		if(instance == null) {
			synchronized(OrderAndFoodsService.class) {
				if(instance == null) {
					instance = new OrderAndFoodsService();
				}
			}
		}
		return instance;
	}


}
