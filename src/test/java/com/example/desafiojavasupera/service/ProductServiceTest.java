package com.example.desafiojavasupera.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.desafiojavasupera.dto.ProductDTO;
import com.example.desafiojavasupera.entities.Product;
import com.example.desafiojavasupera.services.ProductService;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void ShoudReturnAProduct() {
		Product product = productService.findById(2L);
		Product thisProduct = new Product(2L, "Call Of Duty Infinite Warfare", 49.99, 80, "call-of-duty-infinite-warfare.png");
		
		assertEquals(thisProduct.getId(), product.getId());
		assertEquals(thisProduct.getName(), product.getName());
		assertEquals(thisProduct.getPrice(), product.getPrice());
		assertEquals(thisProduct.getScore(), product.getScore());
		assertEquals(thisProduct.getImage(), product.getImage());
	}

	@Test
	public void ShouldInsertAProduct() {
		Product thisProduct = new Product();
		thisProduct.setId(4L);
		thisProduct.setName("Devil May Cry V");
		thisProduct.setPrice(89.99);
		thisProduct.setScore(500);
		thisProduct.setImage("devil-may-cry-v.png");
		
		productService.insert(thisProduct);
		Long id = thisProduct.getId();
		assertNotNull(id);

		Product product = productService.findById(id);

		assertEquals(thisProduct.getId(), product.getId());
		assertEquals(thisProduct.getName(), product.getName());
		assertEquals(thisProduct.getPrice(), product.getPrice());
		assertEquals(thisProduct.getScore(), product.getScore());
		assertEquals(thisProduct.getImage(), product.getImage());
	}

	@Test
	public void ShouldUpdateAProduct() {
		Product thisProduct = new Product();
		thisProduct = productService.findById(3L);
		
		thisProduct.setName("The Witcher I Wild Hunt");
		thisProduct.setPrice(999.0);
		ProductDTO product = new ProductDTO(productService.update(3L, new ProductDTO(thisProduct)));

        assertEquals(product.getName(), product.getName());
        assertEquals(product.getPrice(), product.getPrice());
	}
}