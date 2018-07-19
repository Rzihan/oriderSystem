package com.topview.www.po;

/**
 * 订单与食物的一对多关系类
 * id主键，orderId订单id，foodId食物id
 * foodNum食物数量，foodNum食物价格
 * state 记录状态
 */
public class OrderAndFoods {
	
	private int id;//主键id
	private int orderId;//订单id
	private int foodId;//食物id
	private int foodNum;//食物的数量
	private String foodPrice;//食物价格
	private int state;//记录状态
	
	public OrderAndFoods() {}

	public OrderAndFoods(int id, int orderId, int foodId, int foodNum,
						 String foodPrice, int state) {
		this.id = id;
		this.orderId = orderId;
		this.foodId = foodId;
		this.foodNum = foodNum;
		this.foodPrice = foodPrice;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "OrderAndFoods{" +
				"id=" + id +
				", orderId=" + orderId +
				", foodId=" + foodId +
				", foodNum=" + foodNum +
				", foodPrice='" + foodPrice + '\'' +
				", state=" + state +
				'}';
	}
}
