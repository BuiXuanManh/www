package fit.se.week7.backend.repositories;

import fit.se.week7.backend.models.UserRole;
import fit.se.week7.backend.pks.UserRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK> {

}
