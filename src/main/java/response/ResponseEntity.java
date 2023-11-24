package response;

public class ResponseEntity<T> {
    private final short status;
    private final T response;

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
}
