package com.example.desafiojavasupera.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.desafiojavasupera.entities.Product;
import com.example.desafiojavasupera.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product(Long.valueOf(312), "Super Mario Odyssey", 197.88, 100, "super-mario-odyssey.png");
		Product p2 = new Product(Long.valueOf(201), "Call Of Duty Infinite Warfare", 49.99, 80, "call-of-duty-infinite-warfare.png");
		Product p3 = new Product(Long.valueOf(102), "The Witcher III Wild Hunt", 119.5, 250, "the-witcher-iii-wild-hunt.png");
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
}
