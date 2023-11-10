package request.teacher_request;

public class GetTeacherByIdRequest {
    private final long id;

    public GetTeacherByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
