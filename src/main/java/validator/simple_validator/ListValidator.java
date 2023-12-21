package validator.simple_validator;

import java.util.List;
import java.util.Objects;

public class ListValidator {
    public <T> ListValidator isNotNullAndNotContainsNull(List<T> list, List<String> errors, String fieldName) {
        return isNotNull(list, errors, fieldName)
                .notContainsNull(list, errors, fieldName);
    }

    public <T> ListValidator isNotNull(List<T> list, List<String> errors, String fieldName) {
        if (list == null) {
            errors.add(fieldName + " should not be null");
        }
        return this;
    }

    public <T> ListValidator notContainsNull(List<T> list, List<String> errors, String fieldName) {
        if (list.stream().anyMatch(Objects::isNull)) {
            errors.add(fieldName + " should not contains null");
        }
        return this;
    }
}
