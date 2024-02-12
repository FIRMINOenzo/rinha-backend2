package com.rinha.backend.exceptions.transaction;

public class TransactionInconsistentValuesException extends RuntimeException {

  public TransactionInconsistentValuesException(String message) {
    super(message);
  }
}
