package com.atv2.picpay.infrastructure.database.repository;

import com.atv2.picpay.domain.model.Account;
import com.atv2.picpay.domain.repository.AccountRepository;
import com.atv2.picpay.infrastructure.database.mapper.AccountEntityMapper;
import com.atv2.picpay.infrastructure.database.spring.SpringDataAccountJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private final SpringDataAccountJpaRepository jpaRepository;
    private final AccountEntityMapper mapper;

    @Override
    public Account save(Account account) {
        var entity = mapper.toEntity(account);
        jpaRepository.save(entity);
        return mapper.toModel(entity);
    }

    @Override
    public Optional<Account> findByCpf(String cpf) {
        var entity = jpaRepository.findByCpf(cpf);
        return entity.map(mapper::toModel);
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        var entity = jpaRepository.findByAccountNumber(accountNumber);
        return entity.map(mapper::toModel);
    }

    @Override
    public List<Account> findAll() {
        var accounts = jpaRepository.findAll();
        return accounts.stream().map(mapper::toModel).toList();
    }
}
