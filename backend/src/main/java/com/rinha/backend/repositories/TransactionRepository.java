package com.rinha.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rinha.backend.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
