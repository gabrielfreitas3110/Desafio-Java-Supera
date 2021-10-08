package com.example.desafiojavasupera.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiojavasupera.entities.Cart;
import com.example.desafiojavasupera.entities.CartItem;
import com.example.desafiojavasupera.entities.Product;
import com.example.desafiojavasupera.repositories.CartItemRepository;
import com.example.desafiojavasupera.repositories.CartRepository;
import com.example.desafiojavasupera.repositories.ProductRepository;
import com.example.desafiojavasupera.services.exception.ObjectNotFoundException;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartItemRepository cartItemRepository;

	public List<Cart> findAll() {
		return cartRepository.findAll();
	}
	
	public Cart findById(Long id) {
		Optional<Cart> obj = cartRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cart not found! Id: " + id
				+ ". Type: " + Cart.class.getName()));
	}
	
	public void removeProduct(Long id, Long productId) {
		Cart obj = findById(id);
		Product product = productService.findById(productId);
		CartItem cartItem = new CartItem(obj, product);
		obj.removeProduct(cartItem);
		cartItemRepository.delete(cartItem);
	}
	
	public void addProduct(Long id, Long productId, int qtd) {
		Cart obj = findById(id);
		Product product = productService.findById(productId);
		CartItem cartItem = new CartItem(obj, product, qtd, product.getPrice());
		if(qtd != 0)
			obj.addProduct(cartItem);
		cartItemRepository.save(cartItem);
	}
}