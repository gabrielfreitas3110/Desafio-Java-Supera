package com.example.desafiojavasupera.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.desafiojavasupera.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_checkout")
public class Checkout implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer orderStatus;
	
	@OneToOne
	@MapsId
	private Cart cart;

	public Checkout() {
	}

	public Checkout(Long id, OrderStatus orderStatus, Cart cart) {
		this.id = id;
		setOrderStatus(orderStatus);
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null)
			this.orderStatus = orderStatus.getCod();
	}

	public Double getFreight() {
		return cart.getFreight();
	}

	public double getSubTotal() {
		return cart.getSubTotal();
	}
	
	public double getTotal() {
		return getFreight() + getSubTotal();
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
		Checkout other = (Checkout) obj;
		return Objects.equals(id, other.id);
	}
}