package com.example.www_week6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WwwWeek6Application {

    public static void main(String[] args) {
        SpringApplication.run(WwwWeek6Application.class, args);
    }
//    @Bean
//    CommandLineRunner init() {
//        return args -> {
//            Random random = new Random();
//            for (int i = 0; i < 100; i++) {
//                User user = new User("Mr", ".", "Join", "043255235", "a" + i + "@mail", "intro", "profile", "pass", Instant.now(), Instant.now());
//                userService.save(user);
//                Post post = new Post("content" + i, Instant.now(), "meta title", true, Instant.now(), "summary" + i, "title" + i, Instant.now(), null, user);
//                service.save(post);
//            }
//        };
//    }
}
