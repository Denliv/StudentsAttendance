package request.subject_request;

public class GetSubjectByIdRequest {
    private final long id;

    public GetSubjectByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
