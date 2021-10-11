package com.example.desafiojavasupera.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiojavasupera.entities.Checkout;
import com.example.desafiojavasupera.entities.enums.OrderStatus;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException("Checkout not found! Id: " + id
					+ ". Type: " + Checkout.class.getName()));
	}
	
	public Checkout insert(Checkout obj) {
		obj.setOrderStatus(OrderStatus.WAITING_PAYMENT);
		return checkoutRepository.save(obj);
	}
	
	public Checkout update(Long id, Checkout obj) {
		Checkout entity = findById(id);
		entity.setOrderStatus(obj.getOrderStatus());
		return checkoutRepository.save(entity);
	}
}