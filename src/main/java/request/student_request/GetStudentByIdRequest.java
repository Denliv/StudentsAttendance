package request.student_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class GetStudentByIdRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public GetStudentByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentByIdRequest that = (GetStudentByIdRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
