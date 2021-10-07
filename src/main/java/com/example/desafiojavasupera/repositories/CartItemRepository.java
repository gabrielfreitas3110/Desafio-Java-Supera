package com.example.desafiojavasupera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiojavasupera.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}