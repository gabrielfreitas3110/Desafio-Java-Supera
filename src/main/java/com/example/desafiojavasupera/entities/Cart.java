package com.example.desafiojavasupera.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cart")
public class Cart  implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Double FREIGHT_RATE = 10.00;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@OneToMany(mappedBy = "id.cart")
	private Set<CartItem> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
	private Checkout checkout;
	
	public Cart() {
	}

	public Cart(Long id, Client client) {
		this.id = id;
		this.client = client;
	}

	public Long getId() {
		return id;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<CartItem> getItens() {
		return itens;
	}

	public void removeProduct(CartItem cartItem) {
		if(itens.contains(cartItem)) {
			itens.remove(cartItem);
		}
	}

	public void addProduct(CartItem cartItem) {
		if(!itens.contains(cartItem)) {
			itens.add(cartItem);
		}
	}

	public Checkout getCheckout() {
		return checkout;
	}

	public void setCheckout(Checkout checkout) {
		this.checkout = checkout;
	}

	
	public double getSubTotal() {
		double sum = 0.0;
		for(CartItem x : itens) {
			sum += x.getSubTotal();
		}
		return Math.round(sum * 100d) / 100d;
	}

	public Double getFreight() {
		int totalProducts = 0;
		for(CartItem x : itens) {
			totalProducts += x.getQuantity();
		}
		return (double) Math.round(FREIGHT_RATE * totalProducts * 100d) / 100d;
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
		Cart other = (Cart) obj;
		return Objects.equals(id, other.id);
	}
}