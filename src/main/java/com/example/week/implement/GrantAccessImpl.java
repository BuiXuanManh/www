package com.example.week.implement;

import com.example.week.models.GrantAccess;
import com.example.week.resource.GrantAccessRepository;
import com.example.week.service.GrantAccessService;
import jakarta.inject.Inject;

public class GrantAccessImpl implements GrantAccessService {
    @Inject
    private GrantAccessRepository repository;
    @Override
    public boolean grantAccess(GrantAccess grantAccess) {
        return repository.grantAccess(grantAccess);
    }
}
