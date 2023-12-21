package request.student_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class DeleteStudentRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public DeleteStudentRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteStudentRequest that = (DeleteStudentRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
