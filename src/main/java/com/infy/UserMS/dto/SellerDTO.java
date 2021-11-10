package com.infy.UserMS.dto;

import com.infy.UserMS.entity.Seller;
import javax.validation.constraints.Email;


public class SellerDTO {
	Integer sellerId;
	Long phoneNo;
	String name;
	@Email
	String email;
	String password;
	boolean isActive;
	

	public Integer getsellerId() {
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
	public SellerDTO() {
		super();
	}
	@Override
	public String toString() {
		return "sellerDTO [sellerId=" + sellerId + ", phoneNo=" + phoneNo + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", isActive=" + isActive + "]";
	}
	// Converts Entity into DTO
			public static SellerDTO valueOf(Seller seller) {
				SellerDTO custDTO = new SellerDTO();
				custDTO.setSellerId(seller.getSellerId());
				custDTO.setEmail(seller.getEmail());
				custDTO.setName(seller.getName());
				custDTO.setPassword(seller.getPassword());
				custDTO.setPhoneNo(seller.getPhoneNo());
				custDTO.setIsActive(seller.getIsActive());
				
				
				return custDTO;
			}
			// Converts DTO into Entity
			public Seller createEntity() {
				Seller cust = new Seller();
				cust.setSellerId(this.getsellerId());
				cust.setEmail(this.getEmail());
				cust.setName(this.getName());
				cust.setPassword(this.getPassword());
				cust.setPhoneNo(this.getPhoneNo());
				cust.setIsActive(this.getIsActive());
				return cust;
			}	


}
