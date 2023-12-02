package fit.se.week7.backend.models;

import fit.se.week7.backend.enums.UserRoleStatus;
import fit.se.week7.backend.pks.UserRolePK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_role")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    private UserRolePK userRolePK;
    @Enumerated(EnumType.STRING)
    private UserRoleStatus status;
}
