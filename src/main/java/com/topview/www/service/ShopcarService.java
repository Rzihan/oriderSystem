package com.topview.www.service;


/**
 * 购物车的业务逻辑处理类
 */
public class ShopcarService {

	private static volatile ShopcarService instance = null;

	public static ShopcarService getInstance() {
		if(instance == null) {
			synchronized(ShopcarService.class) {
				if(instance == null) {
					instance = new ShopcarService();
				}
			}
		}
		return instance;
	}

}
