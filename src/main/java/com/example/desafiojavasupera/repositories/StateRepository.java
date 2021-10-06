package com.example.desafiojavasupera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiojavasupera.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

}