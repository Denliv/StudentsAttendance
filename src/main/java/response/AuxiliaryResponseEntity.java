package response;

import java.beans.ConstructorProperties;
import java.util.List;

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
}
