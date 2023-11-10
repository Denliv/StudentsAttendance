package request.student_request;

public class GetStudentByIdRequest {
    private final long id;

    public GetStudentByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
