package service;

import dto.CreateUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    public Long create(CreateUserDto userDto){
        //validation

        //map
        //userDao
        //return id
        return null;
    }
    public static UserService getInstance(){
        return INSTANCE;
    }
}
