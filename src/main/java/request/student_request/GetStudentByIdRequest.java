package request.student_request;

import java.beans.ConstructorProperties;

public class GetStudentByIdRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public GetStudentByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
