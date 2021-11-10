package com.infy.UserMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.UserMS.dto.LoginDTO;
import com.infy.UserMS.dto.SellerDTO;
import com.infy.UserMS.dto.WishlistDTO;
import com.infy.UserMS.entity.Buyer;
import com.infy.UserMS.entity.Cart;
import com.infy.UserMS.entity.Wishlist;
import com.infy.UserMS.dto.BuyerDTO;
import com.infy.UserMS.dto.CartDTO;
import com.infy.UserMS.service.UserService;


@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class UserController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    UserService custService;

	// Create a new buyer
	@PostMapping(value = "/buyer/register")
	public ResponseEntity<String> createBuyer(@RequestBody BuyerDTO buyer) throws Exception  {
		custService.createBuyer(buyer);
		String successMessage = "Buyer added successfully";
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	// Login buyer
	@PostMapping(value = "/buyer/login")
	public ResponseEntity<String> loginBuyer(@RequestBody LoginDTO login) throws Exception  {
		String buyer = custService.loginBuyer(login);
//		String successMessage = "Login successfully";
		return new ResponseEntity<>(buyer, HttpStatus.OK);
	}
	// Create a new seller
	@PostMapping(value = "/seller/register")
	public ResponseEntity<String> createSeller(@RequestBody SellerDTO seller) throws Exception  {
		custService.createSeller(seller);
		String successMessage = "Seller added successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
		return response;
	}

	// Login seller
	@PostMapping(value = "/seller/login")
	public ResponseEntity<String> loginSeller(@RequestBody LoginDTO login) throws Exception  {
		String seller= custService.loginSeller(login);
//		String successMessage = "Login successfully";
		ResponseEntity<String> response = new ResponseEntity<String>(seller, HttpStatus.OK);
		return response;
	}
	//delete buyer
	@DeleteMapping(value = "/buyer/{buyerId}")
	  public ResponseEntity<String> deleteBuyer(@PathVariable Integer buyerId) throws Exception  {
		  custService.deleteBuyer(buyerId);
		  String successMessage = "Buyer deleted succssfully";
		  ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
		  return response;
	   		}
	
	//delete seller
   @DeleteMapping(value = "/seller/{sellerId}")
   public ResponseEntity<String> deleteSeller(@PathVariable Integer sellerId) throws Exception  {
	  custService.deleteSeller(sellerId);
	  String successMessage = "Customer deleted succssfully";
	  ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
	  return response;
   		}
	
	// Fetches all the buyer 
	
	@GetMapping(value = "/buyer")
	public ResponseEntity<List<BuyerDTO>> getAllBuyersDetails() throws Exception{
		List<BuyerDTO> buyerList = custService.getAllBuyersDetails();
		ResponseEntity<List<BuyerDTO>> response = new ResponseEntity<List<BuyerDTO>>(buyerList, HttpStatus.OK);
		return response;
	}
	
	// Fetches all the seller
	@GetMapping(value = "/seller")
	public ResponseEntity<List<SellerDTO>> getAllCustomerDetails() throws Exception{
		List<SellerDTO> sellerList = custService.getAllSellerDetails();
		ResponseEntity<List<SellerDTO>> response = new ResponseEntity<List<SellerDTO>>(sellerList, HttpStatus.OK);
		return response;
	}
	
	 //Fetches full profile of a specific buyer
	@GetMapping(value = "/buyer/{buyerId}")
	public ResponseEntity<BuyerDTO> getSpecificBuyer(@PathVariable Integer buyerId) throws Exception  {
		BuyerDTO buyer = custService.getSpecificBuyer(buyerId);
		ResponseEntity<BuyerDTO> response = new ResponseEntity<BuyerDTO>(buyer, HttpStatus.OK);
		return response;
	}
	 //Fetches full profile of a specific buyer
		@GetMapping(value = "/seller/{sellerId}")
		public ResponseEntity<SellerDTO> getSpecificSeller(@PathVariable Integer sellerId) throws Exception  {
			SellerDTO seller = custService.getSpecificSeller(sellerId);
			ResponseEntity<SellerDTO> response = new ResponseEntity<SellerDTO>(seller, HttpStatus.OK);
			return response;
		}
	// Fetches wishlist
		@GetMapping(value = "/buyer/{buyerId}/wishlist")
		public ResponseEntity<List<WishlistDTO>> getWishlist(@PathVariable Integer buyerId) throws Exception{
			List<WishlistDTO> wishlist = custService.getWishlist(buyerId);
			ResponseEntity<List<WishlistDTO>> response = new ResponseEntity<List<WishlistDTO>>(wishlist, HttpStatus.OK);
			return response;
		}
		@GetMapping(value = "/buyer/login/{buyerId}/rewardpoints")
		public Integer getrewardpoints(@PathVariable Integer buyerId) throws Exception{
			Integer rewardpoints = custService.getrewardpoints(buyerId);
			return rewardpoints;
		}
		@PutMapping(value = "/buyer/login/{buyerId}/rewardpoints/{rewardpoints}")
		public Integer getrewardpoints(@PathVariable Integer buyerId,@PathVariable Integer rewardpoints) throws Exception{
			Integer rewardpoints1 = custService.updaterewardpoints(buyerId,rewardpoints);
			return rewardpoints1;
		}
		@PutMapping(value = "/buyer/login/{buyerId}/previlage/{rewardpoints}")
		public Integer updateprivilage(@PathVariable Integer buyerId,@PathVariable Integer rewardpoints) throws Exception{
			Integer rewardpoints1 = custService.updateprevilage(buyerId,rewardpoints);
			return rewardpoints1;
		}
		
		
		

}
