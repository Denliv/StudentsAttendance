package Validator.SimpleValidator;

public class IdValidator {
    public static boolean validate(long id) {
        return id >= 0;
    }
}
