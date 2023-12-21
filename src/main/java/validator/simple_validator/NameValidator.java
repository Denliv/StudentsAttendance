package validator.simple_validator;

import java.util.List;
import java.util.Objects;

public class NameValidator {
    public NameValidator isNotNull(String str, List<String> errors, String fieldName) {
        if (str == null) {
            errors.add(fieldName + " should not be null");
        }
        return this;
    }

    public NameValidator isNotEmpty(String str, List<String> errors, String fieldName) {
        if (Objects.equals(str, "")) {
            errors.add(fieldName + " should not be empty");
        }
        return this;
    }

    public NameValidator isNotNullOrEmpty(String str, List<String> errors, String fieldName) {
        return isNotNull(str, errors, fieldName)
                .isNotEmpty(str, errors, fieldName);
    }

    public NameValidator isLessThanMaxLen(String str, int maxLen, List<String> errors, String fieldName) {
        if (str.length() > maxLen) {
            errors.add(fieldName + " should be less than " + maxLen + "symbols");
        }
        return this;
    }

    public NameValidator isNotNullOrEmptyAndLessThanMaxLen(String str, int maxLen, List<String> errors, String fieldName) {
        return isNotNull(str, errors, fieldName)
                .isNotEmpty(str, errors, fieldName)
                .isLessThanMaxLen(str, maxLen, errors, fieldName);
    }
}
