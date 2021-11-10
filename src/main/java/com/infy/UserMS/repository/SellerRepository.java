package com.infy.UserMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infy.UserMS.entity.Seller;
@Repository("sellerRepo")
public interface SellerRepository extends JpaRepository<Seller, Integer> {
	 Seller findByPhoneNo(long PhoneNo);
	 Seller findByEmail(String emailId);

}
