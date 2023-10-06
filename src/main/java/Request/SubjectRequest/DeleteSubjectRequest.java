package Request.SubjectRequest;

public class DeleteSubjectRequest {
    private final long id;

    public DeleteSubjectRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
