package com.example.bankaccountmanagement.repository;

import com.example.bankaccountmanagement.persistence.account.Account;

import java.util.List;

// This interface defines the operations for interacting with the account data in the repository layer.
// It includes basic CRUD operations for managing accounts.

public interface AccountRepository {
    void save(Account account);

    Account getById(Long id);

    List<Account> findAll();

    void deleteById(Long id);
}