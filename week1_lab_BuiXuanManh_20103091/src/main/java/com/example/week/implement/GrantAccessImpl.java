package com.example.week.implement;

import com.example.week.models.GrantAccess;
import com.example.week.repositories.GrantAccessRepository;
import com.example.week.services.GrantAccessService;

import java.util.Optional;

public class GrantAccessImpl implements GrantAccessService {
//    @Inject
//    private GrantAccessRepository repository;
private GrantAccessRepository repository;


    public GrantAccessImpl() {
        repository= new GrantAccessRepository();
    }

    @Override
    public boolean grantAccess(GrantAccess grantAccess) {
        return repository.grantAccess(grantAccess);
    }

    @Override
    public void grantCancel(GrantAccess grantAccess) {
        repository.grantCancel(grantAccess);
    }

    @Override
    public Optional<GrantAccess> findByAR(String id, String name) {
        return repository.findByAR(id, name);
    }
}
