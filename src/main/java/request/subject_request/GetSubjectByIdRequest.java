package request.subject_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class GetSubjectByIdRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public GetSubjectByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetSubjectByIdRequest that = (GetSubjectByIdRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
