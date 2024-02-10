package com.rinha.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rinha.backend.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}