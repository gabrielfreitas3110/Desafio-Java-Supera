package com.example.desafiojavasupera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiojavasupera.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}