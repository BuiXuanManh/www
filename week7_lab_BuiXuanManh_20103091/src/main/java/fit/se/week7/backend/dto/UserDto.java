package fit.se.week7.backend.dto;

import fit.se.week7.backend.models.Role;
import fit.se.week7.backend.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private User user;
    private List<Role> roles;
}
