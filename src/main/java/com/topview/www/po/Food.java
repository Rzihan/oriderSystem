package com.topview.www.po;

/**
 * 食物类
 * @author Pan梓涵
 *
 */
public class Food {
	
	private int id;//食物id
	private int storeId;//店铺id
	private String foodName;//食物名字
	private String foodPrice;//食物价格
	private int foodSales;//食物销量
	private String foodComments;//食物说明
	private String foodType;//食物类型
	private int foodState;//食物状态
	private String foodImage;//食物图片
	private int foodNum;//食物库存
	
	public Food() {}

	public Food(int id, int storeId, String foodName, String foodPrice, int foodSales, String foodComments,
				String foodType, int foodState, String foodImage, int foodNum) {
		this.id = id;
		this.storeId = storeId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodSales = foodSales;
		this.foodComments = foodComments;
		this.foodType = foodType;
		this.foodState = foodState;
		this.foodImage = foodImage;
		this.foodNum = foodNum;
	}

	public Food(int storeId, String foodName, String foodPrice, String foodComments, String foodType, String foodImage) {
		this.storeId = storeId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodComments = foodComments;
		this.foodType = foodType;
		this.foodImage = foodImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getFoodSales() {
		return foodSales;
	}

	public void setFoodSales(int foodSales) {
		this.foodSales = foodSales;
	}

	public String getFoodComments() {
		return foodComments;
	}

	public void setFoodComments(String foodComments) {
		this.foodComments = foodComments;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getFoodState() {
		return foodState;
	}

	public void setFoodState(int foodState) {
		this.foodState = foodState;
	}

	public String getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}

	public int getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
	}

	@Override
	public String toString() {
		return "Food{" +
				"id=" + id +
				", storeId=" + storeId +
				", foodName='" + foodName + '\'' +
				", foodPrice='" + foodPrice + '\'' +
				", foodSales=" + foodSales +
				", foodComments='" + foodComments + '\'' +
				", foodType='" + foodType + '\'' +
				", foodState=" + foodState +
				", foodImage='" + foodImage + '\'' +
				", foodNum=" + foodNum +
				'}';
	}
}
