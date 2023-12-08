package fit.se.week7.backend.repositories;

import fit.se.week7.backend.enums.UserStatus;
import fit.se.week7.backend.models.UserRole;
import fit.se.week7.backend.pks.UserRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK> {
    @Query("select ur from UserRole ur join User u on u.userName=ur.userRolePK.user.userName where u.status=:status and ur.status=:status")
    List<UserRole> findAll(@Param("status")UserStatus userStatus);


    @Query("select ur from UserRole ur where ur.userRolePK.user.userName=:id")
    List<UserRole> findByUserName(@Param("id") String userName);
}
