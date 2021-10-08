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
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Product not found! Id: " + id
					+ ". Type: " + Product.class.getName()));
	}
	
	public Product insert(Product obj) {
		return productRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			productRepository.deleteById(id);
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException(
					"Product not found! Id: " + id
					+ ". Type: " + Product.class.getName());
		} 
	}
	
	public Product update(Long id, ProductDTO obj) {
		try {
			Product entity = findById(id);
			updateData(new ProductDTO(entity), obj);
			return productRepository.save(entity);
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException(
					"Product not found! Id: " + id
					+ ". Type: " + Product.class.getName());
		} 
	}

	private void updateData(ProductDTO entity, ProductDTO obj) {
		entity.setName(obj.getName());
		entity.setPrice(obj.getPrice());
		entity.setScore(obj.getScore());
		entity.setImage(obj.getImage());
	}
}