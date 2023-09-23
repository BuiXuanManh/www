package com.example.week.services;

import com.example.week.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role findById(String id);
    boolean create(Role a);
    boolean update(Role a);
    void delete(String id);

}
