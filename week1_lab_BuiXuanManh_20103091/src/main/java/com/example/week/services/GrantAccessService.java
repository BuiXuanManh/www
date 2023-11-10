package com.example.week.services;

import com.example.week.models.GrantAccess;

import java.util.Optional;

public interface GrantAccessService {
    boolean grantAccess(GrantAccess grantAccess);
    void grantCancel(GrantAccess grantAccess);
    Optional<GrantAccess> findByAR(String id, String name);
}
