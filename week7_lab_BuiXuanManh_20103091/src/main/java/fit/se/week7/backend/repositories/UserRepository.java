package fit.se.week7.backend.repositories;

import fit.se.week7.backend.enums.UserRoleStatus;
import fit.se.week7.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("select u from User u join UserRole ur on ur.userRolePK.user.userName=u.userName where u.userName=:id and ur.status=:status")
    Optional<User> findById(@Param("id") String s,@Param("status") UserRoleStatus status);

    @Query("select u from User u join UserRole ur on ur.userRolePK.user.userName=u.userName where u.email=:email and ur.status=:status")
    Optional<User> findByEmail(@Param("email") String email, @Param("status")UserRoleStatus status);
}
