package request.student_request;

public class DeleteStudentRequest {
    private final long id;

    public DeleteStudentRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
