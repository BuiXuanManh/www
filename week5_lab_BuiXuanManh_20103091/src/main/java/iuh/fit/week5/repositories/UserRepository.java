package iuh.fit.week5.repositories;

import iuh.fit.week5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("select u from User u where u.userName=:id")
    Optional<User> findByUserName(@Param("id") String userName);
}
