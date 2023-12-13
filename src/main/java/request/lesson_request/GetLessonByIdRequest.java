package request.lesson_request;

import java.beans.ConstructorProperties;

public class GetLessonByIdRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public GetLessonByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
