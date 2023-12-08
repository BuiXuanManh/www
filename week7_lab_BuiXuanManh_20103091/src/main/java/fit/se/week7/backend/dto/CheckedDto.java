package fit.se.week7.backend.dto;

import fit.se.week7.backend.models.Role;
import fit.se.week7.backend.models.User;
import fit.se.week7.backend.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckedDto {
    private String roleName;
    private boolean check;
}
