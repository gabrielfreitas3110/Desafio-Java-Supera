package com.example.desafiojavasupera.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.desafiojavasupera.entities.pk.CartItemPk;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_order_item")
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CartItemPk id = new CartItemPk();

	private Integer quantity;
	private Double price;
	
	public CartItem() {
	}

	public CartItem(Cart cart, Product product, Integer quantity, Double price) {
		id.setCart(cart);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonBackReference
	public Cart getCart() {
		return id.getCart();
	}
	
	
	public void setCart(Cart cart) {
		id.setCart(cart);
	}
	
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return Objects.equals(id, other.id);
	}
}