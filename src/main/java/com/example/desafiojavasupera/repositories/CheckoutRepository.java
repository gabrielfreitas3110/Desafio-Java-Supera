package com.example.desafiojavasupera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiojavasupera.entities.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

}