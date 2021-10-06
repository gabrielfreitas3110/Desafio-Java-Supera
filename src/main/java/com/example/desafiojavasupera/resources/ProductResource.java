package com.example.desafiojavasupera.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiojavasupera.entities.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		Product p1 = new Product(Long.valueOf(312), "Super Mario Odyssey", 197.88, 100, "super-mario-odyssey.png");
		Product p2 = new Product(Long.valueOf(201), "Call Of Duty Infinite Warfare", 49.99, 80, "call-of-duty-infinite-warfare.png");
		Product p3 = new Product(Long.valueOf(102), "The Witcher III Wild Hunt", 119.5, 250, "the-witcher-iii-wild-hunt.png");
		List<Product> list = new ArrayList<>();
		list.addAll(Arrays.asList(p1,p2,p3));
		
		return ResponseEntity.ok().body(list);
	}
}
