package validator;

import dto.CreateUserDto;
import entity.Gender;
import entity.Role;
import util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();
    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if(object.getName()==null){
            validationResult.add(Error.of("invalid.name","Name is invalid"));
        }
        if(object.getName()!=null){
            for(int i=0;i<object.getName().length();i++){
                if(object.getName().charAt(i)>='1'&&object.getName().charAt(i)<='0'){
                    validationResult.add(Error.of("invalid.name","Name contains numbers"));
                    break;
                }
            }
        }
        if(object.getEmail()==null){
            validationResult.add(Error.of("invalid.email","Email is invalid"));
        }
        if(object.getPassword()==null){
            validationResult.add(Error.of("invalid.password","Password is invalid"));
        }
        if(!LocalDateFormatter.isValid(object.getBirthday())){
            validationResult.add(Error.of("invalid.birthday","Birthday is invalid"));
        }
        if(object.getRole()==null||Role.valueOf(object.getRole())==null){
            validationResult.add(Error.of("invalid.role","Role is invalid"));
        }
        if(object.getGender()==null||Gender.valueOf(object.getGender())==null){
            validationResult.add(Error.of("invalid.gender","Gender is invalid"));
        }
        return validationResult;
    }
    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }
}
