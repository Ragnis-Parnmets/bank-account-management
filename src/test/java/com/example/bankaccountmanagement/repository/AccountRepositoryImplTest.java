package com.example.bankaccountmanagement.repository;

import com.example.bankaccountmanagement.persistence.account.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {

    private AccountRepositoryImpl accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepositoryImpl();
        accountRepository.findAll().forEach(account -> accountRepository.deleteById(account.getId()));
    }

    @Test
    void shouldSaveAccountSuccessfully() {
        Account newAccount = new Account(4L, "EE12341234567", "Andres Kiir", 2000.00, "Saving");
        accountRepository.save(newAccount);
        Account retrievedAccount = accountRepository.getById(4L);
        assertNotNull(retrievedAccount);
        assertEquals("EE12341234567", retrievedAccount.getAccountNumber());
        assertEquals("Andres Kiir", retrievedAccount.getOwnerName());
        assertEquals(2000.00, retrievedAccount.getBalance());
        assertEquals("Saving", retrievedAccount.getType());
    }

    @Test
    void shouldReturnAccountById() {
        Account newAccount = new Account(5L, "EE87654321012", "Mati Mees", 1500.00, "Checking");
        accountRepository.save(newAccount);
        Account retrievedAccount = accountRepository.getById(5L);
        assertNotNull(retrievedAccount);
        assertEquals(5L, retrievedAccount.getId());
    }

    @Test
    void shouldReturnAllAccounts() {
        Account account1 = new Account(1L, "EE12345678910", "Juhan Juurikas", 1000.00, "Saving");
        Account account2 = new Account(2L, "EE98765432110", "Jaan Tamm", 500.00, "Checking");
        accountRepository.save(account1);
        accountRepository.save(account2);
        assertEquals(2, accountRepository.findAll().size());
    }

    @Test
    void shouldDeleteAccountById() {
        Account newAccount = new Account(6L, "EE11112222333", "Kert Aed", 2500.00, "Business");
        accountRepository.save(newAccount);
        accountRepository.deleteById(6L);
        Account deletedAccount = accountRepository.getById(6L);
        assertNull(deletedAccount);
    }
}