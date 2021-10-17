package com.example.desafiojavasupera.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cart> findById(@PathVariable Long id) {
		Cart obj = cartService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "{id}/removeProduct/{productId}")
	public ResponseEntity<Void> removeProduct(
			@PathVariable Long id, 
			@PathVariable Long productId,
			@RequestParam(value = "qtd", defaultValue = "0") int qtd) {
		cartService.removeProduct(id, productId, qtd);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "{id}/addProduct/{productId}")
	public ResponseEntity<Void> addProduct(
			@PathVariable Long id, 
			@PathVariable Long productId,
			@RequestParam(value = "qtd", defaultValue = "0") int qtd) {
		cartService.addProduct(id, productId, qtd);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Cart> insert(@RequestParam(value = "clientId") Long id) {
		Cart cart = cartService.insert(id);
		return ResponseEntity.ok().body(cart);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cart> update(@PathVariable Long id, @RequestBody Cart obj) {
		cartService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}