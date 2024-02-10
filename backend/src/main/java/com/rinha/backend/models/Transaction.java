package com.rinha.backend.models;

import java.time.LocalDateTime;

import com.rinha.backend.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, name = "client_id")
  private int clientId;

  @Column(nullable = false)
  private int value;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private TransactionType type;

  @Column(nullable = false, length = 10)
  private String description;

  @Column(nullable = false)
  private LocalDateTime date;

  public Transaction() {
  }

  public Transaction(int clientId, int value, TransactionType type, String description) {
    this.clientId = clientId;
    this.value = value;
    this.type = type;
    this.description = description;
    this.date = LocalDateTime.now();
  }

  public int getId() {
    return this.id;
  }

  public int getClientId() {
    return this.clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setType(TransactionType type) {
    this.type = type;
  }

  public TransactionType getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }
}
