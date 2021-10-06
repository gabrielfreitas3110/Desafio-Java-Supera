package com.example.desafiojavasupera.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiojavasupera.entities.Client;
import com.example.desafiojavasupera.repositories.ClientRepository;
import com.example.desafiojavasupera.services.exception.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id
					+ ". Type: " + Client.class.getName()));
	}
}