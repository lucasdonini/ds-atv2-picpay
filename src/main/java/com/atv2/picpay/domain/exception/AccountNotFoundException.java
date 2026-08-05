package com.atv2.picpay.domain.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String accountNumber) {
        super("No account with number %s was found.".formatted(accountNumber));
    }
}
