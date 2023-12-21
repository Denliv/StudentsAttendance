package response;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class ResponseEntity<T> {
    private final short status;
    private final T response;

    @ConstructorProperties({"response", "status"})
    public ResponseEntity(T response, short status) {
        this.status = status;
        this.response = response;
    }


    public ResponseEntity(short status) {
        this(null, status);
    }

    public short getStatus() {
        return status;
    }

    public T getResponse() {
        return response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseEntity<?> that = (ResponseEntity<?>) o;
        return status == that.status && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, response);
    }
}
