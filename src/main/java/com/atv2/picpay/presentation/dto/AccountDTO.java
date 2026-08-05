package com.atv2.picpay.presentation.dto;

import com.atv2.picpay.domain.model.Account;

import java.math.BigDecimal;

public record AccountDTO(
        String titularName,
        String cpf,
        String accountNumber,
        BigDecimal balance,
        Account.AccountType accountType
) {
}
