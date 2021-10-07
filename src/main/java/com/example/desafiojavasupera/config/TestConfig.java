package com.example.desafiojavasupera.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.desafiojavasupera.entities.Address;
import com.example.desafiojavasupera.entities.Cart;
import com.example.desafiojavasupera.entities.CartItem;
import com.example.desafiojavasupera.entities.Checkout;
import com.example.desafiojavasupera.entities.City;
import com.example.desafiojavasupera.entities.Client;
import com.example.desafiojavasupera.entities.Product;
import com.example.desafiojavasupera.entities.State;
import com.example.desafiojavasupera.entities.enums.OrderStatus;
import com.example.desafiojavasupera.repositories.AddressRepository;
import com.example.desafiojavasupera.repositories.CartItemRepository;
import com.example.desafiojavasupera.repositories.CartRepository;
import com.example.desafiojavasupera.repositories.CityRepository;
import com.example.desafiojavasupera.repositories.ClientRepository;
import com.example.desafiojavasupera.repositories.ProductRepository;
import com.example.desafiojavasupera.repositories.StateRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product(null, "Super Mario Odyssey", 197.88, 100, "super-mario-odyssey.png");
		Product p2 = new Product(null, "Call Of Duty Infinite Warfare", 49.99, 80, "call-of-duty-infinite-warfare.png");
		Product p3 = new Product(null, "The Witcher III Wild Hunt", 119.5, 250, "the-witcher-iii-wild-hunt.png");
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		State s1 = new State(null, "Goiás");
		State s2 = new State(null, "Minas Gerais");
		
		City c1 = new City(null, "Goiânia", s1);
		City c2 = new City(null, "Itumbiara", s1);
		City c3 = new City(null, "Uberlândia", s2);
		
		s1.getCities().addAll(Arrays.asList(c1, c2));
		s2.getCities().addAll(Arrays.asList(c3));
		
		stateRepository.saveAll(Arrays.asList(s1, s2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client  cli1 = new Client(null, "Gabriel", "gabriel.freitas3110@gmail.com", "64996662498", "75395185200", "password");
		
		Address ad1 = new Address(null, "Jardim America", 43, "", "74290215", cli1, c1);
		Address ad2 = new Address(null, "Santos Dumont", 120, "", "75530420", cli1, c2);
		
		cli1.getAddress().addAll(Arrays.asList(ad1, ad2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));
		
		Cart car1 = new Cart(null, cli1);
		cartRepository.saveAll(Arrays.asList(car1));
		
		CartItem ci1 = new CartItem(car1, p1, 3, p1.getPrice());
		CartItem ci2 = new CartItem(car1, p2, 1, p2.getPrice());
		CartItem ci3 = new CartItem(car1, p3, 2, p3.getPrice());
		
		cartItemRepository.saveAll(Arrays.asList(ci1, ci2, ci3));
		
		Checkout ch1 = new Checkout(null, OrderStatus.DELIVERED, car1);
		car1.setCheckout(ch1);
		
		cartRepository.save(car1);
	}
}