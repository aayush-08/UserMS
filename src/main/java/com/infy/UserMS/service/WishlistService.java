package com.infy.UserMS.service;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mapping.PersistentEntity;
import org.springframework.stereotype.Service;

import com.infy.UserMS.dto.CartDTO;
import com.infy.UserMS.dto.WishlistDTO;
import com.infy.UserMS.entity.Cart;
import com.infy.UserMS.entity.Wishlist;
import com.infy.UserMS.repository.CartRepository;
import com.infy.UserMS.repository.WishlistRepository;


@Service
@Transactional
public class WishlistService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	WishlistRepository wishlistrepo;
	@Autowired
	CartRepository cartrepo;

	public void removeProduct(Integer prodid,Integer buyerid) {
		wishlistrepo.deleteByProdidAndBuyerid(prodid,buyerid);
		
	}
	
	
	public Cart moveProduct(Integer buyerid, Integer prodid,Integer sellerid,Integer quantity) {
		Cart cart=new Cart();
		cart.setBuyerid(buyerid);
		cart.setProdid(prodid);
		cart.setQuantity(quantity);
		cart.setSellerid(sellerid);
		cartrepo.save(cart);
		//wishlistrepo.deleteByProdidAndBuyerid(buyerid, prodid);
		removeProduct(prodid,buyerid);
		return cart;
	}

	public Wishlist addProduct(Integer prodid, Integer buyerid) {
		Wishlist wish=new Wishlist();
		wish.setProdid(prodid);
		wish.setBuyerid(buyerid);
		wishlistrepo.save(wish);
	    return wish;

	}

}
