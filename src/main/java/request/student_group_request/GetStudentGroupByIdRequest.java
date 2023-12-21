package request.student_group_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class GetStudentGroupByIdRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public GetStudentGroupByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentGroupByIdRequest that = (GetStudentGroupByIdRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
