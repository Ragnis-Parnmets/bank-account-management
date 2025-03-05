package com.example.bankaccountmanagement.service;

import com.example.bankaccountmanagement.persistence.account.Account;
import com.example.bankaccountmanagement.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    // Constructor for AccountService, injecting the AccountRepository
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Method to get all accounts from the repository
    // It calls the findAll method in AccountRepository and returns the list of Account objects
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Method to get an account by its ID
    // It calls the getById method in AccountRepository and throws an exception if the account is not found
    public Account getAccountById(Long id) {
        return Optional.ofNullable(accountRepository.getById(id))
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    // Method to get the balance of an account by its ID
    // It retrieves the account using getAccountById and returns the balance
    public Double getAccountBalance(Long id) {
        Account account = getAccountById(id);
        return account.getBalance();
    }

    // Method to create a new account
    // It calls the save method in AccountRepository to save the account to the repository
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    // Method to update an existing account by ID
    // It first retrieves the existing account, updates its details, and saves it back to the repository
    // Throws an exception if the account is not found
    public void updateAccount(Long id, Account updatedAccount) {
        Account existingAccount = accountRepository.getById(id);
        if (existingAccount != null) {
            existingAccount.setAccountNumber(updatedAccount.getAccountNumber());
            existingAccount.setOwnerName(updatedAccount.getOwnerName());
            existingAccount.setBalance(updatedAccount.getBalance());
            existingAccount.setType(updatedAccount.getType());
            accountRepository.save(existingAccount);
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    // Method to delete an account by its ID
    // It calls the deleteById method in AccountRepository to remove the account
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
