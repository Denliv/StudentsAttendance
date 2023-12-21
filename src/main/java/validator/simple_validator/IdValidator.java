package validator.simple_validator;

import java.util.List;

public class IdValidator {
    public IdValidator isPositive(long id, List<String> errors, String fieldName) {
        if (id < 0) {
            errors.add(fieldName + " should be >= 0");
        }
        return this;
    }
}
