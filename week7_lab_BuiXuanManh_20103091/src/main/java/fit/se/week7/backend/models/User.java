package fit.se.week7.backend.models;

import fit.se.week7.backend.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userName;
    private String passWord;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
