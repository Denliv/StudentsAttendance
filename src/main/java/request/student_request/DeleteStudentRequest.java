package request.student_request;

import java.beans.ConstructorProperties;

public class DeleteStudentRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public DeleteStudentRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
