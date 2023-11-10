package com.example.week.services;

import com.example.week.models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAll();
    Optional<Role> findById(String id);
    boolean create(Role a);
    boolean update(Role a);
    List<Role> findByAccId(String id);
    Role findByRoleName(String name);
}
