package fit.se.week7.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCheckedDto {
    private String userName;
    private List<CheckedDto> roles;
}
