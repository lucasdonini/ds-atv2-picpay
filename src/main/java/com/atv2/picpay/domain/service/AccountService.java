package com.atv2.picpay.domain.service;

import com.atv2.picpay.domain.exception.NothingToUpdateException;
import com.atv2.picpay.domain.model.Account;
import com.atv2.picpay.application.service.UpdateAccountCommand;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account createAccount(Account account);
    Optional<Account> findAccountByCpf(String cpf);
    Optional<Account> findAccountByAccountNumber(String accountNumber);
    List<Account> listAccounts();
    Account updateAccount(UpdateAccountCommand command) throws NothingToUpdateException;
}
