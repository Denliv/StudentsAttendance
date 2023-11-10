package validator.simple_validator;

import java.util.List;
import java.util.Objects;

public class ListValidator {
    public <T> boolean validate(List<T> list) {
        return list != null && list.stream().noneMatch(Objects::isNull);
    }
}
