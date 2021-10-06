package com.example.desafiojavasupera.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.desafiojavasupera.entities.City;
import com.example.desafiojavasupera.entities.Product;
import com.example.desafiojavasupera.entities.State;
import com.example.desafiojavasupera.repositories.CityRepository;
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
	}
}