package com.atv2.picpay.domain.exception;

public class AccountAlreadyExistsException extends RuntimeException {
    public static AccountAlreadyExistsException byCpf(String cpf) {
        return new AccountAlreadyExistsException("There already is an account registered to the CPF %s".formatted(cpf));
    }

    public static AccountAlreadyExistsException byAccountNumber(String accountNumber) {
        return new AccountAlreadyExistsException("There already is an account with account number %s".formatted(accountNumber));
    }

    protected AccountAlreadyExistsException(String message) { super(message); }
}
