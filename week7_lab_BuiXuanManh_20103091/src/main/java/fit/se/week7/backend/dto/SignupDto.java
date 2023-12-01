package fit.se.week7.backend.dto;

import fit.se.week7.backend.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    private String userName;
    private String passWord;
    private String confirmPassWord;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String note;
}
