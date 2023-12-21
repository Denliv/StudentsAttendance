package response;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Objects;

public class AuxiliaryResponseEntity<T> {
    private final T response;
    private final List<String> errors;

    @ConstructorProperties({"response", "errors"})
    public AuxiliaryResponseEntity(T response, List<String> errors) {
        this.response = response;
        this.errors = errors;
    }

    public AuxiliaryResponseEntity(T response) {
        this(response, null);
    }

    public AuxiliaryResponseEntity(List<String> errors) {
        this(null, errors);
    }

    public T getResponse() {
        return response;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuxiliaryResponseEntity<?> that = (AuxiliaryResponseEntity<?>) o;
        return Objects.equals(response, that.response) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, errors);
    }
}
