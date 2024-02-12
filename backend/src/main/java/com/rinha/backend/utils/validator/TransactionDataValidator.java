package com.rinha.backend.utils.validator;

import java.util.Objects;
import java.util.function.Predicate;

import com.rinha.backend.utils.requests.TransactionRequest;

public class TransactionDataValidator {

  private TransactionDataValidator() {
  }

  private static Predicate<String> intValueValidation = (String value) -> {
    if (Objects.isNull(value)) {
      return false;
    }

    try {
      int valueAsInt = Integer.parseInt(value);
      return valueAsInt > 0;
    } catch (Exception exception) {
      return false;
    }
  };

  private static Predicate<String> descriptionValidation = (String description) -> {
    return (Objects.isNull(description) || (description.length() < 1 || description.length() > 10));
  };

  public static boolean validateTransactionRequestData(TransactionRequest request) {
    return (TransactionDataValidator.intValueValidation.test(request.value())
        &&
        TransactionDataValidator.descriptionValidation.test(request.description())
        &&
        Objects.nonNull(request.type()));
  }
}
