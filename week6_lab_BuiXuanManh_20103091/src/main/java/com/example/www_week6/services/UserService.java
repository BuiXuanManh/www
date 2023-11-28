package com.example.www_week6.services;

import com.example.www_week6.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User save(User u);
}
