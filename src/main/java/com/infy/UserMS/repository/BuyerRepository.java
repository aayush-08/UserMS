package com.infy.UserMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.UserMS.entity.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Integer>{
	 Buyer findByPhoneNo(long phoneNo);
	 Buyer findByEmail(String emailId);
	
	Buyer findByBuyerId(Integer buyerid);
	 
}

