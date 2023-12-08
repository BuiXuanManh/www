package fit.se.week7.backend.models;

import fit.se.week7.backend.enums.RoleName;
import fit.se.week7.backend.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

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
    private UserStatus status;
}
