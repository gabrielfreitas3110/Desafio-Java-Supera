package com.example.desafiojavasupera.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiojavasupera.entities.Checkout;
import com.example.desafiojavasupera.repositories.CheckoutRepository;
import com.example.desafiojavasupera.services.exception.ObjectNotFoundException;

@Service
public class CheckoutService {

	@Autowired
	private CheckoutRepository checkoutRepository;

	public List<Checkout> findAll() {
		return checkoutRepository.findAll();
	}
	
	public Checkout findById(Long id) {
		Optional<Checkout> obj = checkoutRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id
					+ ". Type: " + Checkout.class.getName()));
	}
}