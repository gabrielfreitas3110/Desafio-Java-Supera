package com.example.desafiojavasupera.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.desafiojavasupera.entities.Address;
import com.example.desafiojavasupera.entities.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String phone;
	private String cpf;
	private String password;	
	
	private List<Address> address = new ArrayList<>();
	
	public ClientDTO() {
	}

	public ClientDTO(Client obj) {
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.phone = obj.getPhone();
		this.cpf = obj.getCpf();
		this.password = obj.getPassword();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void addAddress(Address address) {
		this.address.add(address);
	}
}