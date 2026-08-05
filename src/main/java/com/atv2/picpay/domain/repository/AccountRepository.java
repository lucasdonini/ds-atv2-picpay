package com.atv2.picpay.domain.repository;

import com.atv2.picpay.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findByCpf(String cpf);
    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findAll();
}
