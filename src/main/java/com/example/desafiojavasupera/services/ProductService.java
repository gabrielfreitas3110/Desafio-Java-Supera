package com.example.desafiojavasupera.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.desafiojavasupera.dto.ProductDTO;
import com.example.desafiojavasupera.entities.Product;
import com.example.desafiojavasupera.repositories.ProductRepository;
import com.example.desafiojavasupera.services.exception.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Page<ProductDTO> findAll(Pageable pageable) {
		Page<Product> result = productRepository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id
					+ ". Type: " + Product.class.getName()));
	}
}