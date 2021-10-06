package com.example.desafiojavasupera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiojavasupera.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}