package com.atv2.picpay.presentation.dto;

import com.atv2.picpay.domain.model.Account;
import com.atv2.picpay.presentation.validation.CPF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateAccountRequest(

        @NotBlank(message = "Titular name is required")
        @Size(max = 100, message = "Titular name must have at most 100 characters")
        String titularName,

        @NotBlank(message = "CPF is required")
        @CPF(message = "CPF must contain exactly 11 digits")
        String cpf,

        @NotBlank(message = "Account number is required")
        @Size(min = 4, max = 4, message = "Account number must have exactly 4 characters")
        String accountNumber,

        @NotNull(message = "Balance is required")
        @PositiveOrZero
        BigDecimal balance,

        @NotNull(message = "Account type is required")
        Account.AccountType accountType
) {
}
