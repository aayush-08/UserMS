package com.infy.UserMS.dto;

import com.infy.UserMS.entity.Buyer;
import com.infy.UserMS.entity.Cart;

public class CartDTO {
	Integer prodid;
	Integer quantity;
	Integer sellerid;
	
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	// Converts Entity into DTO
		public static CartDTO valueOf(Cart cust) {
			
			CartDTO custDTO = new CartDTO();
			custDTO.setSellerid(cust.getBuyerid());
			custDTO.setProdid(cust.getProdid());
			custDTO.setQuantity(cust.getQuantity());
			return custDTO;
		}
		// Converts DTO into Entity
		public Cart createEntity() {
			Cart cust = new Cart();
			cust.setBuyerid(this.getSellerid());
			cust.setProdid(this.getProdid());
			cust.setQuantity(this.getQuantity());
			 return cust;
		}

}
