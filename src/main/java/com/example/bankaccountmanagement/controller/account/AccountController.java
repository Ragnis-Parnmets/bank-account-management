package com.example.bankaccountmanagement.controller.account;

import com.example.bankaccountmanagement.persistence.account.Account;
import com.example.bankaccountmanagement.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    // Constructor for AccountController, injecting the AccountService
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Endpoint to get all accounts
    // It calls the getAllAccounts method in AccountService and returns a list of Account objects
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Endpoint to get an account by its ID
    // It calls the getAccountById method in AccountService, passing the ID as a path variable
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // Endpoint to create a new account
    // It calls the createAccount method in AccountService and sends the Account object in the request body
    @PostMapping
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    // Endpoint to update an existing account by ID
    // It calls the updateAccount method in AccountService, passing the account ID and updated account details
    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        accountService.updateAccount(id, updatedAccount);
    }

    // Endpoint to delete an account by its ID
    // It calls the deleteAccount method in AccountService, passing the account ID
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    // Endpoint to get the balance of an account by its ID
    // It calls the getAccountBalance method in AccountService, passing the account ID
    @GetMapping("/{id}/balance")
    public Double getAccountBalance(@PathVariable Long id) {
        return accountService.getAccountBalance(id);
    }
}
