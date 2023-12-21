package request.lesson_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class DeleteLessonRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public DeleteLessonRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteLessonRequest that = (DeleteLessonRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
