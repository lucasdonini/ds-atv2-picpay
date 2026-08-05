package com.atv2.picpay.application.service;

import com.atv2.picpay.domain.exception.AccountAlreadyExistsException;
import com.atv2.picpay.domain.exception.AccountNotFoundException;
import com.atv2.picpay.domain.exception.NothingToUpdateException;
import com.atv2.picpay.domain.model.Account;
import com.atv2.picpay.domain.repository.AccountRepository;
import com.atv2.picpay.domain.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    @Override
    public Account createAccount(Account account) {
        if (repository.findByCpf(account.getCpf()).isPresent()) {
            throw AccountAlreadyExistsException.byCpf(account.getCpf());
        }

        if (repository.findByAccountNumber(account.getAccountNumber()).isPresent()) {
            throw AccountAlreadyExistsException.byAccountNumber(account.getAccountNumber());
        }

        return repository.save(account);
    }

    @Override
    public Optional<Account> findAccountByAccountNumber(String accountNumber) {
        return repository.findByAccountNumber(accountNumber);
    }

    @Override
    public Optional<Account> findAccountByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public List<Account> listAccounts() {
        return repository.findAll();
    }

    @Override
    public Account updateAccount(UpdateAccountCommand command) throws NothingToUpdateException {
        if (command.isEmpty()) throw new NothingToUpdateException();

        var account = repository.findByAccountNumber(command.accountNumber())
                .orElseThrow(() -> new AccountNotFoundException(command.accountNumber()));

        var old = account.copy();

        command.titularName().ifPresent(account::setTitularName);
        command.balance().ifPresent(account::setBalance);
        command.accountType().ifPresent(account::setAccountType);

        account = repository.save(account);

        if (account.equals(old)) throw new NothingToUpdateException();

        return account;
    }
}

