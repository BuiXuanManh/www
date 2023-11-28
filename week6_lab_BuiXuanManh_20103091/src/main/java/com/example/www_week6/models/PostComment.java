package com.example.www_week6.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "post_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(100)")
    private String title;
    @Lob
    private String content;
    private boolean published;
    @Column(columnDefinition = "datetime(6)")
    private Instant publishedAt;
    @Column(name = "create_at",columnDefinition = "datetime(6)")
    private String createAt;
    @ManyToOne
    private PostComment parent;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;
}
