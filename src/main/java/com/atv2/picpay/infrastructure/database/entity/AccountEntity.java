package com.atv2.picpay.infrastructure.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "titular_name")
    private String titularName;

    @Column(nullable = false, unique = true)
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(nullable = false, unique = true)
    @Size(min = 4, max = 4)
    private String accountNumber;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private String accountType;

}
