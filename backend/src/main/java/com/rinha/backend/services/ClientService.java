package com.rinha.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinha.backend.models.Client;
import com.rinha.backend.repositories.ClientRepository;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public boolean clientExists(int clientId) {
    return clientRepository.findById(clientId).isPresent();
  }

  public boolean sufficientLimit(int clientId, int value) {
    if (this.clientExists(clientId)) {
      Client client = clientRepository.findById(clientId).get();

      return client.getTotalLimit() >= value;
    }

    return false;
  }
}
