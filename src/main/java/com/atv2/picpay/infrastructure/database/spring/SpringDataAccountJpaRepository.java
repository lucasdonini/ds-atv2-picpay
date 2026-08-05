package com.atv2.picpay.infrastructure.database.spring;

import com.atv2.picpay.infrastructure.database.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAccountJpaRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByCpf(String cpf);
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}
