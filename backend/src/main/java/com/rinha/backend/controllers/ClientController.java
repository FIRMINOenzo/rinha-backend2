package com.rinha.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rinha.backend.exceptions.ClientHasNoLimitException;
import com.rinha.backend.exceptions.ClientNotFoundException;
import com.rinha.backend.services.ClientService;
import com.rinha.backend.utils.requests.TransactionRequest;
import com.rinha.backend.utils.validator.TransactionDataValidator;

@RestController
@RequestMapping("/clientes")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @PostMapping("/{id}/transacoes")
  public ResponseEntity<String> performTransaction(@PathVariable int id, TransactionRequest request) {

    if (!this.clientService.clientExists(id)) {
      throw new ClientNotFoundException("Cliente não encontrado.");
    }

    if (!TransactionDataValidator.validateTransactionRequestData(request)) {

    }

    if (!this.clientService.sufficientLimit(id, Integer.parseInt(request.value()))) {
      throw new ClientHasNoLimitException("Valor acima do limite do cliente.");
    }

  }
}
