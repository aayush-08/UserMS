package com.infy.UserMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.UserMS.entity.Cart;
import com.infy.UserMS.entity.Wishlist;

public interface CartRepository extends JpaRepository<Cart , Integer> {

	void deleteByBuyeridAndProdid(Integer buyerid, Integer productid);

	Iterable<Cart> findByBuyerid(Integer buyerid);

	void deleteByBuyerid(Integer buyerid);
	

}
