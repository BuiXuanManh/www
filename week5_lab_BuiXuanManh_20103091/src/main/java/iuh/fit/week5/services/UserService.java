package iuh.fit.week5.services;

import iuh.fit.week5.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findByUserName(String userName);
    User save(User user);
}
