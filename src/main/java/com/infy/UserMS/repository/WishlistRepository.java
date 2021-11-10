package com.infy.UserMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.UserMS.entity.Wishlist;
@Repository("WishRepo")
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	Iterable<Wishlist> findByBuyerid(Integer buyerId);
	void deleteByProdidAndBuyerid(Integer prodid, Integer buyerid);

}
