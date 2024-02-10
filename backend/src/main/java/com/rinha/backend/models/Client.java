package com.rinha.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private int limit;

  @Column(nullable = false)
  private int balance;

  public Client(int limit, int balance) {
    this.limit = limit;
    this.balance = balance;
  }

  public int getLimit() {
    return this.limit;
  }

  public int getBalance() {
    return this.balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public int getTotalLimit() {
    return this.balance + this.limit;
  }
}
