package fit.se.week7.backend.services;

import fit.se.week7.backend.enums.RoleName;
import fit.se.week7.backend.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService {
    List<Role> getAll();
    Optional<Role> findByRoleName(RoleName name);
    Role save(Role role);
}
