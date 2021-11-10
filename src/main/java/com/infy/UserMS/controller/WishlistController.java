package com.infy.UserMS.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.UserMS.dto.CartDTO;
import com.infy.UserMS.dto.WishlistDTO;
import com.infy.UserMS.entity.Cart;
import com.infy.UserMS.entity.Wishlist;
import com.infy.UserMS.service.WishlistService;
@RestController
@CrossOrigin
public class WishlistController {
Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WishlistService wishlistservice;
    
	@PutMapping(value = "/wishlist/{prodid}/{buyerid}")
	public ResponseEntity<Wishlist> addProduct(@PathVariable Integer prodid, @PathVariable Integer buyerid) {
		Wishlist wish = wishlistservice.addProduct(prodid,buyerid);
		//String successMessage = Environment.getProdid("Order_SUCCESS");
        System.out.println("product added sucessfully to wishlist");
		return new ResponseEntity<>(wish, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping(value= "{buyerid}/wishlist/removeproduct/{prodid}")
	public void removeProduct(@PathVariable Integer buyerid, @PathVariable Integer prodid) {
		wishlistservice.removeProduct(prodid,buyerid);
		System.out.println("product deleted sucessfully from wishlist");
	}
	
	@PutMapping(value = "{buyerid}/wishlist/moveproduct/{prodid}/cart/{sellerid}/{quantity}")
	public ResponseEntity<Cart> moveProduct( @PathVariable Integer buyerid,@PathVariable Integer prodid,@PathVariable Integer sellerid,@PathVariable Integer quantity) {
		Cart cart =wishlistservice.moveProduct(buyerid,prodid,sellerid,quantity);
		//String successMessage = Environment.getProdid("Order_SUCCESS");
        System.out.println("product added sucessfully from wishlist to cart");
		return new ResponseEntity<>(cart, HttpStatus.OK);
		
	}	

}
