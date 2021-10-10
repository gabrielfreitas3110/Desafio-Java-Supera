package com.example.desafiojavasupera.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.desafiojavasupera.entities.Cart;
import com.example.desafiojavasupera.entities.Client;
import com.example.desafiojavasupera.services.CartService;

@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	private CartService cartService;
	
	@Test	
	public void ShoudReturnAListOfCarts() {
		List<Cart> list = cartService.findAll();
		List<Cart> thisList = new ArrayList<>();
		Client cli1 = new Client(1L, "Gabriel", "gabriel.freitas3110@gmail.com", "64996662498", "75395185200", "password");
		Client cli2 = new Client(2L, "Anakin", "anakin@gmail.com", "40028922", "15935725811", "41bby");
		
		Cart cart1 = new Cart(1L, cli1);
		Cart cart2 = new Cart(2L, cli2);
		thisList.addAll(Arrays.asList(cart1, cart2));
		

		assertEquals(thisList.get(0).getId(), list.get(0).getId());
		assertEquals(thisList.get(0).getClient().getId(), list.get(0).getClient().getId());
		assertEquals(thisList.get(1).getId(), list.get(1).getId());
		assertEquals(thisList.get(1).getClient().getId(), list.get(1).getClient().getId());
	}
	
	@Test	
	public void ShoudReturnACart() {
		Cart cart = cartService.findById(1L);
		Client cli1 = new Client(1L, "Gabriel", "gabriel.freitas3110@gmail.com", "64996662498", "75395185200", "password");
		Cart thisCart = new Cart(1L, cli1);
		assertEquals(thisCart.getId(), cart.getId());
		assertEquals(thisCart.getClient().getId(), cart.getClient().getId());
	}
}