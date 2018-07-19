package com.topview.www.po;

/**
 * 购物车类 id主键id，userId用户Id，foodId食物id foodNum食物数量，foodPrice食物价格， storeId店铺id
 */
public class Shopcar {

	private int id;// 主键id
	private int userId;// 用户id
	private int foodId;// 食物id
	private int foodNum;// 食物数量
	private String foodPrice;// 食物价格
	private int storeId;// 店铺id

	public Shopcar() {

	}

	public Shopcar(int id, int userId, int foodId, int foodNum,
				   String foodPrice, int storeId) {
		this.id = id;
		this.userId = userId;
		this.foodId = foodId;
		this.foodNum = foodNum;
		this.foodPrice = foodPrice;
		this.storeId = storeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
	}

	public String getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "Shopcar{" +
				"id=" + id +
				", userId=" + userId +
				", foodId=" + foodId +
				", foodNum=" + foodNum +
				", foodPrice='" + foodPrice + '\'' +
				", storeId=" + storeId +
				'}';
	}
}
