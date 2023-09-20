package com.example.week.service;

import com.example.week.models.Account;
import com.example.week.models.Role;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Qualifier;

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
