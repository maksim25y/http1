package mapper;

import dto.UserDto;
import entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<User, UserDto> {
    private static final UserMapper INSTANCE = new UserMapper();
    public static UserMapper getInstance(){
        return INSTANCE;
    }

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .email(object.getEmail())
                .birthday(object.getBirthday())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }
}
