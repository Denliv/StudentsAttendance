package Validator.SimpleValidator;

public class NameValidator {
    public static boolean validate(String name, int maxLen) {
        return name != null && !name.equals("") && name.length() <= maxLen;
    }
}
