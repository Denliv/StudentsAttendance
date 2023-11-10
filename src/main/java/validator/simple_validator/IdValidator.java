package validator.simple_validator;

public class IdValidator {
    public boolean validate(long id) {
        return id >= 0;
    }
}
