package Validator.SimpleValidator;

import java.util.List;
import java.util.Objects;

public class ListValidator {
    public static <T> boolean validate(List<T> list) {
        return list != null && list.stream().noneMatch(Objects::isNull);
    }
}
