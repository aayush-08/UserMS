package com.infy.UserMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class Wishlist {
	@Id
	@Column(nullable = false)
	Integer buyerid;
	@Column(nullable = false)
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

	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
