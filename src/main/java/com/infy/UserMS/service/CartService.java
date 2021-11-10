package com.infy.UserMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.infy.UserMS.dto.CartDTO;
import com.infy.UserMS.dto.ProductDTO;
import com.infy.UserMS.entity.Cart;

import com.infy.UserMS.repository.CartRepository;
@Service
@Transactional
public class CartService {
	@Autowired
	CartRepository cartrepo;
	Integer amount = 0 ;
	Integer pos;
	Integer stock;
	@Value("${OrderUrl}")
	String OrderUrl;
	@Value("${ProdUrl}")
	String ProdUrl;

	public Cart addProduct(Integer sellerid, Integer prodid, Integer buyerid, Integer quantity) {
		Cart  cart = new Cart();
		cart.setSellerid(sellerid);
		cart.setBuyerid(buyerid);
		cart.setProdid(prodid);
	    cart.setQuantity(quantity);
	    cartrepo.save(cart);
		return cart;
	}

	public void removeProduct(Integer buyerid, Integer productid) {
		cartrepo.deleteByBuyeridAndProdid(buyerid,productid);
		
	}

	public List<CartDTO> getcart(Integer buyerid) {
		List<Cart> cust = cartrepo.findAll();
		List<CartDTO> sellerDTOs = new ArrayList<CartDTO>();
		cust.forEach(customer -> {
			sellerDTOs.add(CartDTO.valueOf(customer));
		});
		return sellerDTOs;

	}
	
	public Integer amount(Integer buyerid) {
		Iterable<Cart> carts1=cartrepo.findByBuyerid(buyerid);
		carts1.forEach(cart->{
			String url = ProdUrl+"Product/{prodid}/{sellerid}";
			RestTemplate restTemplate = new RestTemplate();
			ProductDTO po = restTemplate.getForObject(url, ProductDTO.class, cart.getProdid(),cart.getSellerid());		    
			pos=po.getStock()-cart.getQuantity();
			if(pos>=0) {
			amount=amount+po.getPrice()*cart.getQuantity();
			}
		});			
		return amount;
	}
	public void changestock(Integer buyerid) {
		Iterable<Cart> carts1=cartrepo.findByBuyerid(buyerid);
		carts1.forEach(cart->{
			String url = ProdUrl+"Product/{prodid}/{sellerid}";
			RestTemplate restTemplate = new RestTemplate();
			ProductDTO po = restTemplate.getForObject(url, ProductDTO.class, cart.getProdid(),cart.getSellerid());
			stock=po.getStock()-cart.getQuantity();
			if(stock>0) {
			String url1 = ProdUrl+"product/{sellerid}/{prodid}/changestock/{stock}";
			//ProductDTO por1 = restTemplate.getForObject(url1, ProductDTO.class, cart.getProdid(),stock);
			restTemplate.put(url1, ProductDTO.class,cart.getSellerid(),cart.getProdid(), stock);
			}
			
		});
}
}
