package com.topview.www.bo;

public class CheckFood {

    private int id;
    private String storeName;
    private String storeId;
    private String foodName;
    private String foodPrice;
    private String foodComments;
    private String foodType;
    private String foodImage;

    public CheckFood(){}

    public CheckFood(int id, String storeName, String storeId, String foodName, String foodPrice,
                     String foodComments, String foodType, String foodImage) {
        this.id = id;
        this.storeName = storeName;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
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

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    @Override
    public String toString() {
        return "CheckFood{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", storeId='" + storeId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodPrice='" + foodPrice + '\'' +
                ", foodComments='" + foodComments + '\'' +
                ", foodType='" + foodType + '\'' +
                ", foodImage='" + foodImage + '\'' +
                '}';
    }
}
