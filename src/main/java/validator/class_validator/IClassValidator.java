package validator.class_validator;

import java.util.List;

public interface IClassValidator<T> {
    List<String> validate(T o);
}
