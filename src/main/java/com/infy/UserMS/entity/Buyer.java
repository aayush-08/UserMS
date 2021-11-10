package com.infy.UserMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="buyer")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="buyer_id")
	Integer buyerId;
	@Column(name="phone_no")
	Long phoneNo;
	@Column(nullable = false, length = 50)
	String name;
	@Column(nullable = false)
	String email;
	@Column(nullable = false, length = 50)
	String password;
	@Column(name = "rewards_point")
	Integer rewardsPoint;
	@Column(name = "is_previledged")
	boolean isPreviledged;
	@Column(name = "is_active")
	boolean isActive;
	

	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
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
	public Integer getRewardsPoint() {
		return rewardsPoint;
	}
	public void setRewardsPoint(Integer rewardsPoint) {
		this.rewardsPoint = rewardsPoint;
	}
	public boolean getIsPreviledged() {
		return isPreviledged;
	}

	public void setIsPreviledged(boolean isPreviledged) {
		this.isPreviledged = isPreviledged;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Buyer() {
		super();
	}
	public Buyer(Integer buyerId, Long phoneNo, String name, String email, String password, Integer rewardsPoint,
			boolean isPreviledged, boolean isActive) {
		super();
		this.buyerId = buyerId;
		this.phoneNo = phoneNo;
		this.name = name;
		this.email = email;
		this.password = password;
		this.rewardsPoint = rewardsPoint;
		this.isPreviledged = isPreviledged;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", phoneNo=" + phoneNo + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", rewardsPoint=" + rewardsPoint + ", isPreviledged=" + isPreviledged
				+ ", isActive=" + isActive + "]";
	}
	
	
	

}
