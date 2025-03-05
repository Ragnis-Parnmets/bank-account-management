package com.example.bankaccountmanagement.repository;

import com.example.bankaccountmanagement.persistence.account.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Repository implementation for managing Account data.
// It uses an in-memory Map to simulate a database for account storage.

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final Map<Long, Account> accounts = createAccounts();

    @Override
    public void save(Account account) {
        if (account == null) {
            throw new NullPointerException("Account must not be null");
        }
        accounts.put(account.getId(), account);
    }

    @Override
    public Account getById(Long id) {
        return accounts.get(id);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public void deleteById(Long id) {
        accounts.remove(id);
    }

    // Creates initial account data to populate the repository.
    // This is a mock implementation simulating a database with predefined accounts.
    // @return A map of accounts where the key is the account ID.
    private Map<Long, Account> createAccounts() {
        Map<Long, Account> initialAccounts = new HashMap<>();
        initialAccounts.put(1L, new Account(1L, "EE12345678910", "Juhan Juurikas", 1000.00, "Saving"));
        initialAccounts.put(2L, new Account(2L, "EE98765432110", "Jaan Tamm", 500.00, "Checking"));
        initialAccounts.put(3L, new Account(3L, "EE56781234119", "Mari Maasikas", 1500.00, "Business"));
        return initialAccounts;
    }
}