package com.atv2.picpay.infrastructure.database.mapper;

import com.atv2.picpay.infrastructure.database.entity.AccountEntity;
import com.atv2.picpay.domain.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountEntityMapper {
    Account toModel(AccountEntity entity);
    AccountEntity toEntity(Account account);
}
