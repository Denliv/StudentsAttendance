package response;

import java.util.List;

public class AuxiliaryResponseEntity<T> {
    private T response;
    private List<String> errors;

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
}
