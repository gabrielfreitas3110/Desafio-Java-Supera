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
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Cart not found! Id: " + id 
						+ ". Type: " + Cart.class.getName()));
	}
	
	public void removeProduct(Long id, Long productId, int qtd) throws RuntimeException {
		Cart obj = findById(id);
		Product product = productService.findById(productId);
		CartItem cartItem = new CartItem(obj, product, qtd, product.getPrice());
		int cartItemQtd = 0;
		if (obj.getItens().contains(cartItem)) {
			for(CartItem f : obj.getItens()) {
				if (f.getProduct().getId().equals(cartItem.getProduct().getId())) {
					cartItemQtd = f.getQuantity();
				}
			}
			cartItem.setQuantity(cartItemQtd - cartItem.getQuantity());		
			cartItemQtd = cartItem.getQuantity();	
		} else {
			throw new ObjectNotFoundException("Product " + product.getName()
					+" not found in the cart");
		}
		if(cartItemQtd > 0) {
			cartItemRepository.save(cartItem);
		} else {
			cartItemRepository.delete(cartItem);
		}
	}

	public void addProduct(Long id, Long productId, int qtd) {
		Cart obj = findById(id);
		Product product = productService.findById(productId);
		CartItem cartItem = new CartItem(obj, product, qtd, product.getPrice());
		if (obj.getItens().contains(cartItem)) {
			for (CartItem f : obj.getItens()) {
				if (f.getProduct().getId().equals(cartItem.getProduct().getId())) {
					cartItem.setQuantity(cartItem.getQuantity() + f.getQuantity());
				}
			}
		} 
		cartItemRepository.save(cartItem);
	}
}