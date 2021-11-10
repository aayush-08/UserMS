package com.infy.UserMS.dto;


import java.util.Objects;

import com.infy.UserMS.entity.Buyer;
import javax.validation.constraints.Email;


public class BuyerDTO {
	
	Integer buyerId;
	Long phoneNo;
	String name;
	@Email
	String email;
	String password;
	Integer rewardsPoint;
	boolean isPreviledged;
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

	public void setIsPreviledged(boolean boolean1) {
		this.isPreviledged = boolean1;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public BuyerDTO() {
		super();
	}
	@Override
	public String toString() {
		return "BuyerDTO [buyerId=" + buyerId + ", phoneNo=" + phoneNo + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", rewardsPoint=" + rewardsPoint + ", isPreviledged=" + isPreviledged
				+ ", isActive=" + isActive + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(buyerId, email, isActive, isPreviledged, name, password, phoneNo, rewardsPoint);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuyerDTO other = (BuyerDTO) obj;
		return Objects.equals(buyerId, other.buyerId) && Objects.equals(email, other.email)
				&& isActive == other.isActive && isPreviledged == other.isPreviledged
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNo, other.phoneNo) && Objects.equals(rewardsPoint, other.rewardsPoint);
	}
			// Converts Entity into DTO
			public static BuyerDTO valueOf(Buyer cust) {
				
				BuyerDTO custDTO = new BuyerDTO();
				custDTO.setBuyerId(cust.getBuyerId());
				custDTO.setEmail(cust.getEmail());
				custDTO.setName(cust.getName());
				custDTO.setPassword(cust.getPassword());
				custDTO.setPhoneNo(cust.getPhoneNo());
				custDTO.setRewardsPoint(cust.getRewardsPoint());
				custDTO.setIsActive(cust.getIsActive());
				custDTO.setIsPreviledged(cust.getIsPreviledged());
				
				
				return custDTO;
			}
			// Converts DTO into Entity
			public Buyer createEntity() {
				Buyer cust = new Buyer();
				cust.setBuyerId(this.getBuyerId());
				cust.setEmail(this.getEmail());
				cust.setName(this.getName());
				cust.setPassword(this.getPassword());
				cust.setPhoneNo(this.getPhoneNo());
				cust.setRewardsPoint(this.getRewardsPoint());
				cust.setIsActive(this.getIsActive());
				cust.setIsPreviledged(this.getIsPreviledged());
				return cust;
			}	

}
