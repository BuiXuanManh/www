package fit.se.week7.backend.repositories;

import fit.se.week7.backend.enums.RoleName;
import fit.se.week7.backend.enums.UserRoleStatus;
import fit.se.week7.backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
