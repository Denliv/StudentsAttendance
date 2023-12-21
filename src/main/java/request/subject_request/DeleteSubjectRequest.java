package request.subject_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class DeleteSubjectRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public DeleteSubjectRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteSubjectRequest that = (DeleteSubjectRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
