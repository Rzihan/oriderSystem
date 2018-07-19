package com.topview.www.po;

/**
 * 商品评价类
 */
public class Evaluation {

	private int id;// 主键id
	private int userId;// 用户id
	private int foodId;// 食物id
	private int storeId;// 店铺id
	private String foodEvaluation;// 食物的评价语

	public Evaluation() {}

	public Evaluation(int id, int userId, int foodId, int storeId, String foodEvaluation) {
		this.id = id;
		this.userId = userId;
		this.foodId = foodId;
		this.storeId = storeId;
		this.foodEvaluation = foodEvaluation;
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

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getFoodEvaluation() {
		return foodEvaluation;
	}

	public void setFoodEvaluation(String foodEvaluation) {
		this.foodEvaluation = foodEvaluation;
	}

	@Override
	public String toString() {
		return "Evaluation{" +
				"id=" + id +
				", userId=" + userId +
				", foodId=" + foodId +
				", storeId=" + storeId +
				", foodEvaluation='" + foodEvaluation + '\'' +
				'}';
	}
}
