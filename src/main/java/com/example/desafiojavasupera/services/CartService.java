package com.example.desafiojavasupera.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiojavasupera.entities.Cart;
import com.example.desafiojavasupera.repositories.CartRepository;
import com.example.desafiojavasupera.services.exception.ObjectNotFoundException;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public List<Cart> findAll() {
		return cartRepository.findAll();
	}
	
	public Cart findById(Long id) {
		Optional<Cart> obj = cartRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id
					+ ". Type: " + Cart.class.getName()));
	}
}