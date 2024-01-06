package service;

import dao.UserDao;
import dto.CreateUserDto;
import exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mapper.CreateUserMapper;
import validator.CreateUserValidator;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    public Integer create(CreateUserDto userDto){
        //validation
        var validationResult = createUserValidator.isValid(userDto);
        if(!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }
        //map
        var userEntity = createUserMapper.mapFrom(userDto);
        //userDao.save
        userDao.save(userEntity);
        //return id
        return userEntity.getId();
    }
    public static UserService getInstance(){
        return INSTANCE;
    }
}
