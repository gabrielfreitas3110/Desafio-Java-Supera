package com.example.desafiojavasupera.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.desafiojavasupera.entities.Cart;
import com.example.desafiojavasupera.entities.Checkout;
import com.example.desafiojavasupera.entities.Client;
import com.example.desafiojavasupera.entities.enums.OrderStatus;
import com.example.desafiojavasupera.services.CheckoutService;
import com.example.desafiojavasupera.services.exception.ObjectNotFoundException;

@SpringBootTest
public class CheckoutServiceTest {

	@Autowired
	private CheckoutService checkoutService;
	
	@Test	
	public void ShoudReturnACheckout() {
		Checkout checkout = checkoutService.findById(1L);
		
		Client cli1 = new Client(1L, "Gabriel", "gabriel.freitas3110@gmail.com", "64996662498", "75395185200", "password");
		Cart car1 = new Cart(1L, cli1);
		Checkout thisCheckout = new Checkout(1L, OrderStatus.DELIVERED, car1);

		assertEquals(thisCheckout.getId(), checkout.getId());
		assertEquals(thisCheckout.getOrderStatus(), checkout.getOrderStatus());
	}
	
	@Test
	public void ShouldThrowAnError() {
		Throwable exception = assertThrows(ObjectNotFoundException.class, () -> checkoutService.findById(2L));
		String eMessage = "Object not found! Id: 2. Type: " + Checkout.class.getName();
	    assertEquals(eMessage, exception.getMessage());
	}
}