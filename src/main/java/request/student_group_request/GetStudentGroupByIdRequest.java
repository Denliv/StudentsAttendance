package request.student_group_request;

import java.beans.ConstructorProperties;

public class GetStudentGroupByIdRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public GetStudentGroupByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
