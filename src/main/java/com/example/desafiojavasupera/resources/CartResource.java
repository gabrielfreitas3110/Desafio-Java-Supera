package com.example.desafiojavasupera.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiojavasupera.entities.Cart;
import com.example.desafiojavasupera.services.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartResource {
	
	@Autowired
	private CartService cartService;

	@GetMapping
	public ResponseEntity<List<Cart>> findAll() {
		List<Cart> list = cartService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Cart> findById(@PathVariable Long id) {
		Cart obj = cartService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}