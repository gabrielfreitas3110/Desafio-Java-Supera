package com.example.desafiojavasupera.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiojavasupera.entities.Checkout;
import com.example.desafiojavasupera.services.CheckoutService;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutResource {
	
	@Autowired
	private CheckoutService checkoutService;

	@GetMapping
	public ResponseEntity<List<Checkout>> findAll() {
		List<Checkout> list = checkoutService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Checkout> findById(@PathVariable Long id) {
		Checkout obj = checkoutService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}