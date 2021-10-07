package com.example.desafiojavasupera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiojavasupera.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}