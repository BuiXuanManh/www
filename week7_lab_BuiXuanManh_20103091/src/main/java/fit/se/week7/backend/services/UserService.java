package fit.se.week7.backend.services;

import fit.se.week7.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findByUserName(String username);
    Optional<User> findByEmail(String email);
    List<User> getAll();
    User save(User user);
}
