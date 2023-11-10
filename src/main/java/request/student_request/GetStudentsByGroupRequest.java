package request.student_request;

public class GetStudentsByGroupRequest {
    private final long id;

    public GetStudentsByGroupRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
