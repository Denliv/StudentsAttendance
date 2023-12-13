package request.student_request;

import java.beans.ConstructorProperties;

public class GetStudentsByGroupRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public GetStudentsByGroupRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
