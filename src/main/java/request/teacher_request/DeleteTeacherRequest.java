package request.teacher_request;

public class DeleteTeacherRequest {
    private final long id;

    public DeleteTeacherRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
