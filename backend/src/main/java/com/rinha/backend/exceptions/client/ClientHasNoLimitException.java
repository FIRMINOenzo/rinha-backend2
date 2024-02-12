package com.rinha.backend.exceptions;

public class ClientHasNoLimitException extends RuntimeException {

  public ClientHasNoLimitException(String message) {
    super(message);
  }
}
