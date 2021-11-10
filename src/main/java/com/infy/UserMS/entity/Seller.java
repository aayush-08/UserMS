package com.infy.UserMS.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seller_id", nullable = false)
	Integer sellerId;
	@Column(name = "phone_no", nullable = false)
	Long phoneNo;
	@Column(nullable = false, length = 50)
	String name;
	@Column(nullable = false)
	String email;
	@Column(nullable = false, length = 50)
	String password;
	@Column(name = "is_active",nullable = false)
	boolean isActive;
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Seller() {
		super();
	}
	public Seller(Integer sellerId, Long phoneNo, String name, String email, String password, boolean isActive) {
		super();
		this.sellerId = sellerId;
		this.phoneNo = phoneNo;
		this.name = name;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	}
	

}
