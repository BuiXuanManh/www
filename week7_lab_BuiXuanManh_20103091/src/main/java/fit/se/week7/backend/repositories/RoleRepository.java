package fit.se.week7.backend.repositories;

import fit.se.week7.backend.enums.RoleName;
import fit.se.week7.backend.enums.UserRoleStatus;
import fit.se.week7.backend.enums.UserStatus;
import fit.se.week7.backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(RoleName roleName);
    @Query("select ur.userRolePK.role from User u join UserRole ur on ur.userRolePK.user.userName= u.userName where u.status=:status and u.userName=:userName ")
    List<Role> findByUserName(@Param("userName") String userName, @Param("status")UserStatus status);
}
