package com.topview.www.constant;

//有关食物表的常量类
public class FoodConstants {

	//食物为提交审核
	public static final int FOOD_NOT_CHECK = 1;
	//食物正在审核
	public static final int FOOD_BEING_CHECK = 2;
	//食物审核成功
	public static final int FOOD_CHECK_SUCCESS = 3;
	//食物审核失败
	public static final int FOOD_CHECK_FAILURE = 4;
	//食物已经上架
	public static final int FOOD_PUTAWAY = 5;
	//食物已经下架
	public static final int FOOD_SALE_OUT = 6;
	//删除食物
	public static final int FOOD_DELETE = 7;
	
	//食物提交审核
	public static final String SUBMIT_CHECK = "提交审核";
	//上架食物
	public static final String PUT_AWAY = "上架";
	//下架食物
	public static final String SALE_OUT = "下架";
	//删除食物
	public static final String DELETE = "删除";
	//审核通过
	public static final String CHECK_SUCCESS = "审核通过";
	//审核失败
	public static final String CHECK_FAILURE = "审核失败";
	
	
	//搜索类型：美食
	public static final String SEARCH_FOOD = "美食";
	//搜索类型：店铺
	public static final String SERRCH_STORE = "店铺";
	
}
