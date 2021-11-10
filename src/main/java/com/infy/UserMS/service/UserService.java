package com.infy.UserMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.infy.UserMS.dto.LoginDTO;
import com.infy.UserMS.dto.OrderDTO;
import com.infy.UserMS.dto.ProductDTO;
import com.infy.UserMS.dto.SellerDTO;
import com.infy.UserMS.dto.WishlistDTO;
import com.infy.UserMS.dto.BuyerDTO;
import com.infy.UserMS.dto.CartDTO;
import com.infy.UserMS.entity.Buyer;
import com.infy.UserMS.entity.Cart;
import com.infy.UserMS.entity.Seller;
import com.infy.UserMS.entity.Wishlist;
import com.infy.UserMS.repository.BuyerRepository;
import com.infy.UserMS.repository.CartRepository;
import com.infy.UserMS.repository.SellerRepository;
import com.infy.UserMS.repository.WishlistRepository;
import com.infy.UserMS.userexception.UserException;
import com.infy.UserMS.validator.BuyerValidator;
import com.infy.UserMS.validator.SellerValidator;


@Transactional
@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BuyerRepository custRepo;
	
	@Autowired
	SellerRepository sellerRepo;
	
	@Autowired
	WishlistRepository wishlistRepo;
	
	@Autowired
	CartRepository cartRepo;
	@Autowired
	CartService cart;
	
	@Value("${OrderUrl}")
	String OrderUrl;
	@Value("${ProdUrl}")
	String ProdUrl;
	
//	for using reward points
	Integer reward;
	Integer temp;
	
	// create buyer
	public void createBuyer(BuyerDTO custDTO) throws UserException  {
		logger.info("Creation request for User {}", custDTO);
	    try {
			BuyerValidator.validate(custDTO);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	    if(custRepo.findByPhoneNo(custDTO.getPhoneNo())== null) {
		Buyer cust = custDTO.createEntity();
		custRepo.save(cust);
	    }else {
	    	System.out.println("PhoneNo already existed.");
	    }
	}

	// Login buyer
	
	public String loginBuyer(LoginDTO loginDTO) {
		logger.info("Login request for User {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		if(BuyerValidator.isValidEmail(loginDTO.getEmail())) {
		Buyer cust = custRepo.findByEmail(loginDTO.getEmail());
		if (cust != null && cust.getPassword().equals(loginDTO.getPassword()) && cust.getEmail().equals(loginDTO.getEmail())) {
			return "Successfully";
		}
		}
		return "Invalid";
		
	}
	// create seller
		public void createSeller(SellerDTO seller) throws UserException  {
			logger.info("Creation request for User {}", seller);
			try {
				SellerValidator.validate(seller);
			} catch (UserException e) {
				// TODO Auto-generated catch block
				throw e;
			}
			if(sellerRepo.findByPhoneNo(seller.getPhoneNo())== null) {
			Seller cust = seller.createEntity();
			sellerRepo.save(cust);
			}else {
		    	System.out.println("PhoneNo already existed.");
		    }
		}

		// Login seller
		
		public String loginSeller(LoginDTO loginDTO) {
			logger.info("Login request for User {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		        if(SellerValidator.isValidEmail(loginDTO.getEmail())) {
				Seller cust = sellerRepo.findByEmail(loginDTO.getEmail());
				if (cust != null && cust.getPassword().equals(loginDTO.getPassword()) && cust.getEmail().equals(loginDTO.getEmail())) {
					return "Success";
				}
		        }

			return "Invalid";
		}
	
	//delete buyer
	public void deleteBuyer(Integer customerId) throws Exception {
		Optional<Buyer> optional = custRepo.findById(customerId);
		optional.orElseThrow(() -> new Exception("Service.CUSTOMER_NOT_FOUND"));
		custRepo.deleteById(customerId);
	}
		
	// delete seller
	public void deleteSeller(Integer customerId) throws Exception {
		Optional<Seller> optional = sellerRepo.findById(customerId);
		optional.orElseThrow(() -> new Exception("Service.CUSTOMER_NOT_FOUND"));
		sellerRepo.deleteById(customerId);	
	}
	// Fetches all the Buyers
	public List<BuyerDTO> getAllBuyersDetails() {

//		logger.info("Profile request for User {}", phoneNo);
		List<Buyer> cust = custRepo.findAll();
		List<BuyerDTO> buyerDTOs = new ArrayList<BuyerDTO>();
		cust.forEach(customer -> {
			buyerDTOs.add(BuyerDTO.valueOf(customer));
		});

		logger.info("Profile for User : {}", buyerDTOs);
		return buyerDTOs;
	}
	// Fetches all the Sellers
		public List<SellerDTO> getAllSellerDetails() {

//			logger.info("Profile request for User {}", phoneNo);
			List<Seller> cust = sellerRepo.findAll();
			List<SellerDTO> sellerDTOs = new ArrayList<SellerDTO>();
			cust.forEach(customer -> {
				sellerDTOs.add(SellerDTO.valueOf(customer));
			});

			logger.info("Profile for User : {}", sellerDTOs);
			return sellerDTOs;
		}
		// Fetches wishlist
				public List<WishlistDTO> getWishlist(Integer buyerId) {

//					logger.info("Profile request for User {}", phoneNo);
					Iterable<Wishlist> cust = wishlistRepo.findByBuyerid(buyerId);
					List<WishlistDTO> wishlistDTOs = new ArrayList<WishlistDTO>();
					cust.forEach(customer -> {
						wishlistDTOs.add(WishlistDTO.valueOf(customer));
					});

					logger.info("Profile for User : {}", wishlistDTOs);
					return wishlistDTOs;
				}
				// Fetches cart
					

		
		
	// Fetches full profile of a specific User
	
	public SellerDTO getSpecificSeller( Integer sellerId) {

		logger.info("Profile request for User {}", sellerId);
		Seller cust = sellerRepo.findById(sellerId).get();
		SellerDTO custDTO = SellerDTO.valueOf(cust);

		logger.info("Profile for User : {}", custDTO);
		return custDTO;
	}
	public BuyerDTO getSpecificBuyer( Integer buyerId) {

		logger.info("Profile request for User {}", buyerId);
		Buyer cust = custRepo.findById(buyerId).get();
		BuyerDTO custDTO = BuyerDTO.valueOf(cust);

		logger.info("Profile for User : {}", custDTO);
		return custDTO;
	}

	public BuyerDTO usereward(Integer buyerid, Integer orderid, Integer rewardpoints) {
		Buyer cust = custRepo.findByBuyerId(buyerid);
		reward=cust.getRewardsPoint()-rewardpoints;
		cust.setRewardsPoint(reward);
		temp=(reward/4);
		if(reward>10000) {
			cust.setIsPreviledged(true);
		}
		else {
			cust.setIsPreviledged(false);
		}
		String url =OrderUrl+"api/buyer/login/{buyerid}/order/{orderid}/amount";
		RestTemplate restTemplate1 = new RestTemplate();
		Integer pot=new RestTemplate().getForObject(url, Integer.class,buyerid,orderid);
		Integer tmu = pot-temp;
		String url1 = OrderUrl+"api/buyer/login/{buyerid}/order/{orderid}/userewards/updateamount/{amount}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(url1, OrderDTO.class,buyerid,orderid,tmu);
		updaterewardpoints(buyerid , (int)(tmu/100));
        updateprevilage(buyerid , (int)(tmu/100));
		custRepo.save(cust);
		return null;
	}


	public Integer getrewardpoints(Integer buyerId) {
		Buyer o = custRepo.findByBuyerId(buyerId);
		return o.getRewardsPoint();

}

	public Integer updaterewardpoints(Integer buyerId, Integer rewardpoints) {
		Buyer o = custRepo.findByBuyerId(buyerId);
		o.setRewardsPoint(o.getRewardsPoint()+rewardpoints);
		custRepo.save(o);
		return null;
	}
	public Integer updateprevilage(Integer buyerId, Integer rewardpoints) {
		Buyer o = custRepo.findByBuyerId(buyerId);
		System.out.println(rewardpoints);
		if(rewardpoints>10000) {
			System.out.println(rewardpoints);
			o.setIsPreviledged(true);
		}
		else {
		o.setIsPreviledged(false);
		}
		custRepo.save(o);
		return null;
	}

	
}



