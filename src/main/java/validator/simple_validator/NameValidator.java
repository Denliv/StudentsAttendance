package validator.simple_validator;

public class NameValidator {
    public boolean validate(String name, int maxLen) {
        return name != null && !name.equals("") && name.length() <= maxLen;
    }
}
