package com.infy.UserMS.dto;
import com.infy.UserMS.entity.Wishlist;

public class WishlistDTO {
	Integer buyerid;
	Integer prodid;
	
	public Integer getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
				// Converts Entity into DTO
				public static WishlistDTO valueOf(Wishlist cust) {
					
					WishlistDTO custDTO = new WishlistDTO();
					custDTO.setBuyerid(cust.getBuyerid());
					custDTO.setProdid(cust.getProdid());
					
					return custDTO;
				}
				// Converts DTO into Entity
				public Wishlist createEntity() {
					Wishlist cust = new Wishlist();
					cust.setBuyerid(this.getBuyerid());
					cust.setProdid(this.getProdid());
					 return cust;
				}	

}
