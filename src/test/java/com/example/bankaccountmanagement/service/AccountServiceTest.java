package com.example.bankaccountmanagement.service;

import com.example.bankaccountmanagement.persistence.account.Account;
import com.example.bankaccountmanagement.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllAccounts() {
        Account account1 = new Account(1L, "EE12345678910", "Juhan Juurikas", 1000.00, "Saving");
        Account account2 = new Account(2L, "EE98765432110", "Jaan Tamm", 500.00, "Checking");
        when(accountRepository.findAll()).thenReturn(List.of(account1, account2));
        List<Account> accounts = accountService.getAllAccounts();
        assertEquals(2, accounts.size());
    }

    @Test
    void shouldReturnAccountById() {
        Account account = new Account(1L, "EE12345678910", "Juhan Juurikas", 1000.00, "Saving");
        when(accountRepository.getById(1L)).thenReturn(account);
        Account retrievedAccount = accountService.getAccountById(1L);
        assertNotNull(retrievedAccount);
        assertEquals(1L, retrievedAccount.getId());
    }

    @Test
    void shouldReturnAccountBalance() {
        Account account = new Account(1L, "EE12345678910", "Juhan Juurikas", 1000.00, "Saving");
        when(accountRepository.getById(1L)).thenReturn(account);
        Double balance = accountService.getAccountBalance(1L);
        assertEquals(1000.00, balance);
    }

    @Test
    void shouldCreateAccount() {
        Account newAccount = new Account(3L, "EE55555555555", "Kalle Kiir", 3000.00, "Business");
        accountService.createAccount(newAccount);
        verify(accountRepository, times(1)).save(newAccount);
    }

    @Test
    void shouldUpdateAccount() {
        Account existingAccount = new Account(1L, "EE12345678910", "Juhan Juurikas", 1000.00, "Saving");
        Account updatedAccount = new Account(1L, "EE12345678910", "Juhan Juurikas", 1500.00, "Saving");
        when(accountRepository.getById(1L)).thenReturn(existingAccount);
        accountService.updateAccount(1L, updatedAccount);
        verify(accountRepository, times(1)).save(updatedAccount);
    }

    @Test
    void shouldDeleteAccount() {
        Account account = new Account(1L, "EE12345678910", "Juhan Juurikas", 1000.00, "Saving");
        when(accountRepository.getById(1L)).thenReturn(account);
        accountService.deleteAccount(1L);
        verify(accountRepository, times(1)).deleteById(1L);
    }
}