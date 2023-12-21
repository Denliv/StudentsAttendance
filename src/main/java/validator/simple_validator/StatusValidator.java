package validator.simple_validator;

import entity.StudentStatus;

import java.util.List;

public class StatusValidator {
    public StatusValidator isNotNull(StudentStatus status, List<String> errors, String fieldName) {
        if (status == null) {
            errors.add(fieldName + " should not be null");
        }
        return this;
    }
}
