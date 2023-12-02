package fit.se.week7.backend.implement;

import fit.se.week7.backend.models.UserRole;
import fit.se.week7.backend.pks.UserRolePK;
import fit.se.week7.backend.repositories.UserRoleRepository;
import fit.se.week7.backend.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRoleImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository repository;
    @Override
    public List<UserRole> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UserRole> findById(UserRolePK userRolePK) {
        return repository.findById(userRolePK);
    }

    @Override
    public UserRole save(UserRole userRole) {
        return repository.save(userRole);
    }
}
