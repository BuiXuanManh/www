package com.example.week.implement;

import com.example.week.models.GrantAccess;
import com.example.week.resources.GrantAccessRepository;
import com.example.week.services.GrantAccessService;
import jakarta.inject.Inject;

public class GrantAccessImpl implements GrantAccessService {
//    @Inject
//    private GrantAccessRepository repository;
private GrantAccessRepository repository= new GrantAccessRepository();
    @Override
    public boolean grantAccess(GrantAccess grantAccess) {
        return repository.grantAccess(grantAccess);
    }
}
