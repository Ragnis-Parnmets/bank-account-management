package com.example.bankaccountmanagement.persistence.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    // This class represents a bank account with details such as account number, owner name, balance, and account type.
    // It uses Lombok annotations to automatically generate getters, setters, constructors, and other utility methods.

    private Long id;
    private String accountNumber;
    private String ownerName;
    private Double balance;
    private String type;
}
