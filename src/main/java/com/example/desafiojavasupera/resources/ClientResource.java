package com.example.desafiojavasupera.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiojavasupera.dto.ClientDTO;
import com.example.desafiojavasupera.entities.Client;
import com.example.desafiojavasupera.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = clientService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client obj = clientService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO obj) {
		Client entity = new Client(obj);
		entity = clientService.insert(entity);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO obj) {
		clientService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}