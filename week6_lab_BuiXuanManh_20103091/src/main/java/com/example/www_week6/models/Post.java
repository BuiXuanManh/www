package com.example.www_week6.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String content;
    @Column(name = "create_at",columnDefinition = "datetime(6)")
    private Instant createdAt;
    @Column(name = "meta_title",columnDefinition = "varchar(100)")
    private String metaTitle;
    private boolean published;
    @Column(columnDefinition = "datetime(6)")
    private Instant publishedAt;
    @Lob
    private String summary;
    @Column(columnDefinition = "varchar(75)")
    private String title;
    @Column(name = "update_at",columnDefinition = "datetime")
    private Instant updateAt;
    @ManyToOne
    private Post parent;
    @ManyToOne
    private User author;

    public Post(String content, Instant createdAt, String metaTitle, boolean published, Instant publishedAt, String summary, String title, Instant updateAt, Post parent, User author) {
        this.content = content;
        this.createdAt = createdAt;
        this.metaTitle = metaTitle;
        this.published = published;
        this.publishedAt = publishedAt;
        this.summary = summary;
        this.title = title;
        this.updateAt = updateAt;
        this.parent = parent;
        this.author = author;
    }
}
