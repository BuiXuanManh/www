package com.example.week.services;

import com.example.week.models.Account;
import com.example.week.models.Role;

import java.util.List;

public interface AccountService {
    List<Account> getAll();
    Account findById(String id);
    boolean create(Account a);
    boolean update(Account a);
    void delete(String userName);
    List<Account> dAccByRole();
    Role findRole(String username);
}
