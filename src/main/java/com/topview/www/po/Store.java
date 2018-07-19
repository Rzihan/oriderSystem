package com.topview.www.po;

import java.util.Date;

/**
 * 店铺类
 * 
 * @author Pan梓涵
 *
 */
public class Store {

	private int id;// 店铺id
	private int userId;// 店主id
	private String storeName;// 店铺名
	private String storeType;// 店铺主打类型
	private int storeSales;// 店铺销量
	private int storeGrade;// 店铺评分
	private String storeComments;// 店铺说明
	private String storeAddress;//店铺地址
	private String storeLogo;// 店铺Logo
	private Date createTime;//创建时间
	private int applyForState;//审核状态

	public Store() {}

	public Store(int id, int userId, String storeName, String storeType, int storeSales, int storeGrade, String storeComments, String storeAddress, String storeLogo,
				 Date createTime, int applyForState) {
		this.id = id;
		this.userId = userId;
		this.storeName = storeName;
		this.storeType = storeType;
		this.storeSales = storeSales;
		this.storeGrade = storeGrade;
		this.storeComments = storeComments;
		this.storeAddress = storeAddress;
		this.storeLogo = storeLogo;
		this.createTime = createTime;
		this.applyForState = applyForState;
	}

	public Store(int userId, String storeName, String storeType,
				 String storeComments, String storeAddress, String storeLogo) {
		this.userId = userId;
		this.storeName = storeName;
		this.storeType = storeType;
		this.storeComments = storeComments;
		this.storeAddress = storeAddress;
		this.storeLogo = storeLogo;
	}

	public Store(int id) {
		this.id = id;
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public int getStoreSales() {
		return storeSales;
	}

	public void setStoreSales(int storeSales) {
		this.storeSales = storeSales;
	}

	public int getStoreGrade() {
		return storeGrade;
	}

	public void setStoreGrade(int storeGrade) {
		this.storeGrade = storeGrade;
	}

	public String getStoreComments() {
		return storeComments;
	}

	public void setStoreComments(String storeComments) {
		this.storeComments = storeComments;
	}

	public String getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getApplyForState() {
		return applyForState;
	}

	public void setApplyForState(int applyForState) {
		this.applyForState = applyForState;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	@Override
	public String toString() {
		return "Store{" +
				"id=" + id +
				", userId=" + userId +
				", storeName='" + storeName + '\'' +
				", storeType='" + storeType + '\'' +
				", storeSales=" + storeSales +
				", storeGrade=" + storeGrade +
				", storeComments='" + storeComments + '\'' +
				", storeAddress='" + storeAddress + '\'' +
				", storeLogo='" + storeLogo + '\'' +
				", createTime=" + createTime +
				", applyForState=" + applyForState +
				'}';
	}
}
