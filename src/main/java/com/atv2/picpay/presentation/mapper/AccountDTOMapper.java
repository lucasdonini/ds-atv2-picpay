package com.atv2.picpay.presentation.mapper;

import com.atv2.picpay.presentation.dto.AccountDTO;
import org.mapstruct.Mapper;

import com.atv2.picpay.domain.model.Account;
import com.atv2.picpay.presentation.dto.CreateAccountRequest;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountDTOMapper {
    Account toModel(CreateAccountRequest dto);
    AccountDTO toDTO(Account account);
}
