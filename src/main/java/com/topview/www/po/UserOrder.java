package com.topview.www.po;

/**
 * 用户订单表 id主键，userId关联用户，payPrice支付价格
 * status 记录订单的处理状态，address 收货地址信息
 */
public class UserOrder {

	private int id;// 主键
	private int userId;// 用户id
	private String payPrice;// 支付价格
	private int status;// 记录状态
	private int address;// 收货地址
	private int storeId;//店铺id

	public UserOrder() {}

	public UserOrder(int id, int userId, String payPrice,
					 int status, int address, int storeId) {
		this.id = id;
		this.userId = userId;
		this.payPrice = payPrice;
		this.status = status;
		this.address = address;
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

	public String getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "UserOrder{" +
				"id=" + id +
				", userId=" + userId +
				", payPrice='" + payPrice + '\'' +
				", status=" + status +
				", address=" + address +
				", storeId=" + storeId +
				'}';
	}
}
