package com.example.www_week6.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",columnDefinition = "varchar(50)")
    private String firstName;
    @Column(name = "middle_name",columnDefinition = "varchar(50)")
    private String middleName;
    @Column(name = "last_name",columnDefinition = "varchar(50)")
    private String lastName;
    @Column(columnDefinition = "varchar(15)")
    private String mobile;
    @Column(columnDefinition = "varchar(50)")
    private String email;
    @Lob
    private String intro;
    @Lob
    private String profile;
    @Column(name = "password_hash",columnDefinition = "varchar(32)")
    private String passwordHash;
    @Column(name = "registered_at",columnDefinition = "datetime(6)")
    private Instant registeredAt;
    @Column( name = "last_login",columnDefinition = "datetime(6)")
    private Instant lastLogin;

    public User(String firstName, String middleName, String lastName, String mobile, String email, String intro, String profile, String passwordHash, Instant registeredAt, Instant lastLogin) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.intro = intro;
        this.profile = profile;
        this.passwordHash = passwordHash;
        this.registeredAt = registeredAt;
        this.lastLogin = lastLogin;
    }
}
