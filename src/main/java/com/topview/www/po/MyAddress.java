package com.topview.www.po;

/**
 * 我的地址：id 主键，userId 用户id，linkman 联系人,phone 联系电话，address 具体地址
 * 
 * @author Pan梓涵
 *
 */
public class MyAddress {

	private int id;// id
	private int userId;// 用户Id
	private String linkman;// 联系人
	private String phone;// 联系电话
	private String address;// 具体地址

	public MyAddress() {}

	public MyAddress(int id, int userId, String linkman, String phone, String address) {
		this.id = id;
		this.userId = userId;
		this.linkman = linkman;
		this.phone = phone;
		this.address = address;
	}

	public MyAddress(int id, String linkman, String phone, String address) {
		this.id = id;
		this.linkman = linkman;
		this.phone = phone;
		this.address = address;
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

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MyAddress{" +
				"id=" + id +
				", userId=" + userId +
				", linkman='" + linkman + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
