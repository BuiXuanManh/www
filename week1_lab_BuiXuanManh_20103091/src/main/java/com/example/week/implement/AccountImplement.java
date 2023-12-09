package com.example.week.implement;

import com.example.week.models.Account;
import com.example.week.enums.AccountStatus;
import com.example.week.repositories.AccountRepository;
import com.example.week.services.AccountService;

import java.util.List;
import java.util.Optional;

public class AccountImplement implements AccountService {
//    @Inject
//    private AccountRepository repository;
    private AccountRepository repository;

    public AccountImplement() {
        repository= new AccountRepository();
    }

    @Override
    public List<Account> getAll() {
        return repository.getAll();
    }

    @Override
    public Optional<Account> findById(String id) {
        return repository.find(id);
    }

    @Override
    public boolean create(Account a) {
        return repository.createAccount(a);
    }

    @Override
    public boolean update(Account a) {
        return repository.updateAccount(a);
    }

    @Override
    public void delete(Account a) {
        a.setStatus(AccountStatus.DELETED);
        repository.updateAccount(a);
    }

    @Override
    public List<Account> dAccByRole() {

        return repository.findAcByRole();
    }

    @Override
    public List<Account> findByNotAdmin(String name) {
        return repository.findByNotAdmin(name);
    }

}
