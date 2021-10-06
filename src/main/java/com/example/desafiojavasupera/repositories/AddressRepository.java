package com.example.desafiojavasupera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiojavasupera.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}