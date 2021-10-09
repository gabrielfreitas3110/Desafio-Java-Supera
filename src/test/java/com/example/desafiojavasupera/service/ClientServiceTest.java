package com.example.desafiojavasupera.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.desafiojavasupera.dto.ClientDTO;
import com.example.desafiojavasupera.entities.Client;
import com.example.desafiojavasupera.services.ClientService;

@SpringBootTest
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;
	
	@Test	
	public void ShoudReturnAListOfClients() {
		List<Client> list = clientService.findAll();
		List<Client> thisList = new ArrayList<>();
		
		Client cli1 = new Client(1L, "Gabriel", "gabriel.freitas3110@gmail.com", "64996662498", "75395185200", "password");
		Client cli2 = new Client(2L, "Anakin", "anakin@gmail.com", "40028922", "15935725811", "41bby");
		thisList.addAll(Arrays.asList(cli1, cli2));
		
		assertEquals(thisList.get(0).getName(), list.get(0).getName());
		assertEquals(thisList.get(0).getEmail(), list.get(0).getEmail());
		assertEquals(thisList.get(0).getPhone(), list.get(0).getPhone());
		assertEquals(thisList.get(0).getCpf(), list.get(0).getCpf());
		assertEquals(thisList.get(0).getPassword(), list.get(0).getPassword());
		
		assertEquals(thisList.get(1).getName(), list.get(1).getName());
		assertEquals(thisList.get(1).getEmail(), list.get(1).getEmail());
		assertEquals(thisList.get(1).getPhone(), list.get(1).getPhone());
		assertEquals(thisList.get(1).getCpf(), list.get(1).getCpf());
		assertEquals(thisList.get(1).getPassword(), list.get(1).getPassword());
	}
	
	@Test	
	public void ShoudReturnAClient() {
		Client client = clientService.findById(1L);
		assertEquals("Gabriel", client.getName());
		assertEquals("gabriel.freitas3110@gmail.com", client.getEmail());
		assertEquals("64996662498", client.getPhone());
		assertEquals("75395185200", client.getCpf());
		assertEquals("password", client.getPassword());
	}
	
	@Test
	public void ShouldInsertAClient() {
		Client thisClientDTO = new Client();
		thisClientDTO.setName("C3po");
		thisClientDTO.setEmail("c3po@gmail.com");
		thisClientDTO.setPhone("0800741321");
		thisClientDTO.setCpf("74185296322");
		thisClientDTO.setPassword("112bby");
		
		clientService.insert(thisClientDTO);
        Long id = thisClientDTO.getId();
        assertNotNull(id);
        
        Client clientDTO = clientService.findById(id);
        
        assertEquals("C3po", clientDTO.getName());
        assertEquals("c3po@gmail.com", clientDTO.getEmail());
        assertEquals("0800741321", clientDTO.getPhone());
        assertEquals("74185296322", clientDTO.getCpf());
        assertEquals("112bby", clientDTO.getPassword());
	}
	
	@Test
	public void ShouldUpdateAClient() {
		Client thisClient = new Client();
		thisClient = clientService.findById(2L);
		
		thisClient.setName("Darth Vader");
		thisClient.setEmail("darthvader@gmail.com");
		ClientDTO client = new ClientDTO(clientService.update(2L, new ClientDTO(thisClient)));

        assertEquals("Darth Vader", client.getName());
        assertEquals("darthvader@gmail.com", client.getEmail());
	}
}