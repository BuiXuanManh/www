package com.example.week.services;

import com.example.week.models.Account;
import com.example.week.models.Role;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAll();
    Optional<Account> findById(String id);
    boolean create(Account a);
    boolean update(Account a);
    void delete(Account a);
    List<Account> dAccByRole();
    List<Account> findByNotAdmin(String name);
}
