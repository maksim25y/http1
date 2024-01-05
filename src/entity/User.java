package entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    Integer id;
    String name;
    LocalDateTime birthday;
    String email;
    String password;
    Role role;
    Gender gender;
}
