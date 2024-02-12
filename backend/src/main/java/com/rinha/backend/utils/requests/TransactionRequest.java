package com.rinha.backend.utils.requests;

import com.rinha.backend.enums.TransactionType;

public record TransactionRequest(String value, TransactionType type, String description) {

}
