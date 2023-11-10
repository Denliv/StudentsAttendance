package request.student_group_request;

public class GetStudentGroupByIdRequest {
    private final long id;

    public GetStudentGroupByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
