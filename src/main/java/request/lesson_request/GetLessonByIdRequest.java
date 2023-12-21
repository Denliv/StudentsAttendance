package request.lesson_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class GetLessonByIdRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public GetLessonByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonByIdRequest that = (GetLessonByIdRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
