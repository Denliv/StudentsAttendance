package Request.LessonRequest;

public class GetLessonByIdRequest {
    private final long id;

    public GetLessonByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
