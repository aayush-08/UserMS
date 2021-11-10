package com.infy.UserMS.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.UserMS.dto.BuyerDTO;
import com.infy.UserMS.dto.CartDTO;
import com.infy.UserMS.dto.ProductDTO;
import com.infy.UserMS.dto.ProductsOrderedDTO;
import com.infy.UserMS.entity.Cart;
import com.infy.UserMS.repository.CartRepository;
import com.infy.UserMS.service.CartService;
import com.infy.UserMS.service.UserService;



@RestController
@Transactional
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired
	CartRepository cartrepo;
	@Autowired
	UserService buyer;
	@Value("${OrderUrl}")
	String OrderUrl;
	@Value("${ProdUrl}")
	String ProdUrl;
	//this for consuming for adding product in cart in orderservice
	@PutMapping(value = "/addproduct/{sellerid}/{prodid}/{buyerid}/{quantity}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> addProduct(@PathVariable Integer sellerid,@PathVariable Integer prodid,@PathVariable Integer buyerid ,@PathVariable Integer quantity) {
		String url = ProdUrl+"Product/{prodid}/{sellerid}";
		RestTemplate restTemplate = new RestTemplate();
		ProductDTO po = restTemplate.getForObject(url, ProductDTO.class,prodid,sellerid);
		Cart cartdt = cartService.addProduct(sellerid,prodid,buyerid,quantity);	
		return new ResponseEntity<>(cartdt, HttpStatus.OK);
		
	}
	//this for consuming for delete product in cart  orderservice
	@DeleteMapping(value="/{buyerid}/removeproduct/{prodid}")
	public void removeProduct(@PathVariable Integer buyerid,@PathVariable Integer prodid ) {
			cartService.removeProduct(buyerid,prodid);
		}
	
	//to get cart of specific buyer
	@GetMapping(value = "api/buyer/login/{buyerid}/cart")
	public ResponseEntity<List<CartDTO>> getwishlist(@PathVariable Integer buyerid) {
		List<CartDTO> wish =cartService.getcart(buyerid);
		System.out.println("return wishlist");
		return new ResponseEntity<>(wish, HttpStatus.OK);
	}
	//to know the total amount of the item present in cart for specific buyer
	@GetMapping(value = "api/buyer/login/{buyerid}/cart/amount")
	public Integer getamount(@PathVariable Integer buyerid) {
		Integer amount =cartService.amount(buyerid);
		System.out.println("return wishlist");
		return amount;
	}
	
	@GetMapping(value = "api/buyer/login/{buyerid}/cart/placeorder/changestock/productsorder")
	public void placeorderproduct(@PathVariable Integer buyerid) {
		Iterable<Cart> cust = cartrepo.findByBuyerid(buyerid);
		cust.forEach(customer -> {
			String url = OrderUrl+"{buyerid}/{prodid}/{sellerid}/{quantity}/";
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(url, ProductsOrderedDTO.class,buyerid,customer.getProdid(),customer.getSellerid(),customer.getQuantity());
		});
		cartrepo.deleteByBuyerid(buyerid);
	}
	//use reward points to reduce amount to pay
	@PutMapping(value = "api/buyer/login/{buyerid}/{orderid}/cart/amount/userewardpoints/{rewardpoints}")
	public BuyerDTO usereward(@PathVariable Integer buyerid,@PathVariable Integer orderid,@PathVariable Integer rewardpoints) {
		BuyerDTO buyer1=buyer.usereward(buyerid,orderid,rewardpoints);
		return buyer1;
	}
	
	//after placing order, the stock should change
	@GetMapping(value = "api/buyer/login/{buyerid}/cart/placeorder/changestock")
	public void stock(@PathVariable Integer buyerid) {
		cartService.changestock(buyerid);
		
	}
	
	
	
	
	
}
