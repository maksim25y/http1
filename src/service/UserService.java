package service;

import dao.UserDao;
import dto.CreateUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import validator.CreateUserValidator;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
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
