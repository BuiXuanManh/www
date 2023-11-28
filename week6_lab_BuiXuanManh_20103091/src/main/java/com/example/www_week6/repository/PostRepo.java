package com.example.www_week6.repository;

import com.example.www_week6.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo  extends JpaRepository<Post,Long> {
}
