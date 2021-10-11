package com.example.desafiojavasupera.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiojavasupera.dto.ProductDTO;
import com.example.desafiojavasupera.entities.Product;
import com.example.desafiojavasupera.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(Pageable pageable) {
		List<ProductDTO> list = productService.findAll(pageable)
				.stream()
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/order-by-price")
	public ResponseEntity<List<ProductDTO>> orderByPrice(Pageable pageable) {
		List<ProductDTO> list = productService.findAll(pageable)
				.stream()
				.sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/order-by-score")
	public ResponseEntity<List<ProductDTO>> orderByScore(Pageable pageable) {
		List<ProductDTO> list = productService.findAll(pageable)
				.stream()
				.sorted((p1, p2) -> p1.getScore().compareTo(p2.getScore()))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/order-by-name")
	public ResponseEntity<List<ProductDTO>> orderByName(Pageable pageable) {
		List<ProductDTO> list = productService.findAll(pageable)
				.stream()
				.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO obj) {
		Product entity = new Product(obj);
		entity = productService.insert(entity);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO obj) {
		productService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}