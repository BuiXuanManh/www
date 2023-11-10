package com.example.week.implement;

import com.example.week.models.Role;
import com.example.week.repositories.RoleRepository;
import com.example.week.services.RoleService;

import java.util.List;
import java.util.Optional;

public class RoleImplement implements RoleService {
    //    @Inject
//    private RoleRepository repository;
    private RoleRepository repository;

    public RoleImplement() {
        repository = new RoleRepository();
    }

    @Override
    public List<Role> getAll() {
        return repository.getAll();
    }

    @Override
    public Optional<Role> findById(String id) {
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
    public List<Role> findByAccId(String id) {
        return repository.findByAccId(id);
    }

    @Override
    public Role findByRoleName(String name) {
        return repository.findByRoleName(name);
    }
}
