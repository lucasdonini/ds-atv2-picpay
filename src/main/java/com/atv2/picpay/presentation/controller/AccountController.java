package com.atv2.picpay.presentation.controller;

import com.atv2.picpay.application.service.UpdateAccountCommand;
import com.atv2.picpay.domain.exception.NothingToUpdateException;
import com.atv2.picpay.domain.service.AccountService;
import com.atv2.picpay.presentation.dto.CreateAccountRequest;
import com.atv2.picpay.presentation.dto.AccountDTO;
import com.atv2.picpay.presentation.dto.UpdateAccountRequest;
import com.atv2.picpay.presentation.mapper.AccountDTOMapper;
import com.atv2.picpay.presentation.validation.CPF;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountDTOMapper mapper;
    private final AccountService service;

    @PostMapping("/accounts")
    public ResponseEntity<AccountDTO> addAccount(@RequestBody @Valid CreateAccountRequest requestDto) {
        var model = mapper.toModel(requestDto);
        var account = service.createAccount(model);
        var responseDto = mapper.toDTO(account);
        return ResponseEntity.created(
                URI.create("/accounts/%s/%s".formatted(responseDto.cpf(), responseDto.accountType()))
        ).body(responseDto);
    }

    @GetMapping("/accounts/{cpf:\\d{11}}")
    public ResponseEntity<AccountDTO> findAccountByCpf(@PathVariable @CPF String cpf) {
        var accounts = service.findAccountByCpf(cpf);
        return accounts.map(mapper::toDTO).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/accounts/{accountNumber:\\d{4}}")
    public ResponseEntity<AccountDTO> findAccountByAccountNumber(
            @PathVariable @Size(min = 4, max = 4) String accountNumber
    ) {
        var account = service.findAccountByAccountNumber(accountNumber);
        return account.map(mapper::toDTO).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/accounts")
    public List<AccountDTO> listAccounts() {
        return service.listAccounts().stream().map(mapper::toDTO).toList();
    }

    @PutMapping("/accounts/{accountNumber:\\d{4}}")
    public ResponseEntity<AccountDTO> updateAccount(
            @PathVariable @Size(min = 4, max = 4) String accountNumber,
            @RequestBody @Valid UpdateAccountRequest request
    ) {
        var command = UpdateAccountCommand.builder()
                .accountNumber(accountNumber)
                .balance(request.balance())
                .accountType(request.accountType())
                .titularName(request.titularName())
                .build();

        try {
            var updated = service.updateAccount(command);
            return ResponseEntity.ok(mapper.toDTO(updated));
        } catch (NothingToUpdateException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
