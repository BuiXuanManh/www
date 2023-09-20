package com.example.week.service;

import com.example.week.models.Account;
import com.example.week.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role findById(String id);
    boolean create(Role a);
    boolean update(Role a);
    void delete(String id);

}
