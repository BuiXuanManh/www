package com.example.week.implement;

import com.example.week.models.Role;
import com.example.week.resource.RoleRepository;
import com.example.week.service.RoleService;
import jakarta.inject.Inject;

import java.util.List;

public class RoleImplement implements RoleService {
    @Inject
    private RoleRepository repository;

    public RoleImplement() {
        this.repository = new RoleRepository();
    }

    @Override
    public List<Role> getAll() {
        return repository.getAll();
    }

    @Override
    public Role findById(String id) {
        return repository.find(id);
    }

    @Override
    public boolean create(Role a) {
        return repository.createRole(a);
    }

    @Override
    public boolean update(Role a) {
        return repository.updateRole(a);
    }

    @Override
    public void delete(String id) {
        Role a = repository.find(id);
        repository.deleteRole(a);
    }
}
