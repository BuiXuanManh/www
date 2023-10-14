package iuh.fit.week5.implement;

import iuh.fit.week5.entities.User;
import iuh.fit.week5.repositories.UserRepository;
import iuh.fit.week5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserImplement implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public Optional<User> findByUserName(String userName) {
        return repository.findByUserName(userName);
    }
    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
