package com.atv2.picpay.presentation.dto;

import com.atv2.picpay.domain.model.Account;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Optional;

@Builder
public record UpdateAccountRequest(
        Optional<@Size(max = 100) String> titularName,
        Optional<BigDecimal> balance,
        Optional<Account.AccountType> accountType
        ) {
}
