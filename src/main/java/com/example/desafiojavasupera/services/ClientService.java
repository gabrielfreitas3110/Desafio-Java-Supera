package com.example.desafiojavasupera.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiojavasupera.dto.ClientDTO;
import com.example.desafiojavasupera.entities.Client;
import com.example.desafiojavasupera.entities.Product;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException("Client not found! Id: " + id
					+ ". Type: " + Client.class.getName()));
	}
	
	public Client insert(Client obj) {
		return clientRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			Client entity = findById(id);
			clientRepository.delete(entity);
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException(
					"Client not found! Id: " + id
					+ ". Type: " + Product.class.getName());
		} 
	}
	
	public Client update(Long id, ClientDTO obj) {
		try {
			Client entity = findById(id);
			updateData(entity, obj);
			return clientRepository.save(entity);
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException(
					"Client not found! Id: " + id
					+ ". Type: " + Product.class.getName());
		}
	}

	private void updateData(Client entity, ClientDTO obj) {
		if(obj.getName() != null)
			entity.setName(obj.getName());
		
		if(obj.getEmail() != null)
			entity.setEmail(obj.getEmail());
		
		if(obj.getPhone() != null)
			entity.setPhone(obj.getPhone());
		
		if(obj.getCpf() != null)
			entity.setCpf(obj.getCpf());

		if(obj.getPassword() != null)
			entity.setPassword(obj.getPassword());
	}
}