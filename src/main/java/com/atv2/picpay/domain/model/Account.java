package com.atv2.picpay.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
public class Account {

    private final Long id;
    private final String cpf;
    private final String accountNumber;
    private String titularName;
    private BigDecimal balance;
    private AccountType accountType;

    public Account copy() {
        return new Account(id, cpf, accountNumber, titularName, balance, accountType);
    }

    public void setBalance(BigDecimal balance) {
        if (balance != null) this.balance = balance.setScale(2, RoundingMode.HALF_EVEN);
        else this.balance = null;
    }

    public enum AccountType {CHECKING, SAVINGS}
}
