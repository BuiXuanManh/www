package fit.se.week7.backend.services;

import fit.se.week7.backend.models.UserRole;
import fit.se.week7.backend.pks.UserRolePK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRoleService {
    List<UserRole> getAll();
    Optional<UserRole> findById(UserRolePK userRolePK);
    UserRole save(UserRole userRole);
}
