package com.example.desafiojavasupera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiojavasupera.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {

}