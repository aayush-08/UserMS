package com.infy.UserMS.dto;

import java.util.Objects;



public class ProductDTO {
	Integer prodid;
    String prodname;
    Integer price;
    Integer stock;
    Integer sellerid;
    Integer Buyerid;
    String category;
    String subcategory;
    Integer productrating;
    //Integer Stock;
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public Integer getBuyerid() {
		return Buyerid;
	}
	public void setBuyerid(Integer buyerid) {
		this.Buyerid = buyerid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public Integer getProductrating() {
		return productrating;
	}
	public void setProductrating(Integer productrating) {
		this.productrating = productrating;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(Buyerid, category, price, prodid, prodname, productrating, sellerid, stock,
				subcategory);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(Buyerid, other.Buyerid) && Objects.equals(category, other.category)
				&& Objects.equals(price, other.price) && Objects.equals(prodid, other.prodid)
				&& Objects.equals(prodname, other.prodname) && Objects.equals(productrating, other.productrating)
				&& Objects.equals(sellerid, other.sellerid) && Objects.equals(stock, other.stock)
				&& Objects.equals(subcategory, other.subcategory);
	}
    

}