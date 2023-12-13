package request.subject_request;

import java.beans.ConstructorProperties;

public class DeleteSubjectRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public DeleteSubjectRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
