package validator;

import dto.CreateUserDto;
import entity.Gender;

public class CreateUserValidator implements Validator<CreateUserDto> {
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();
    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if(Gender.valueOf(object.getGender())==null){
            validationResult.add(Error.of("invalid.gender","Gender is invalid"));
        }
        return validationResult;
    }
    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }
}
