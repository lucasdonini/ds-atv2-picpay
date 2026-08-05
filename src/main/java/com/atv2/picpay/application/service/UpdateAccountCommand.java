package com.atv2.picpay.application.service;

import com.atv2.picpay.domain.model.Account;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Optional;

@Builder
public record UpdateAccountCommand(
        String accountNumber,
        Optional<String> titularName,
        Optional<BigDecimal> balance,
        Optional<Account.AccountType> accountType
) {
    public boolean isEmpty() {
        return titularName.isEmpty()
                && balance.isEmpty()
                && accountType.isEmpty();
    }
}
