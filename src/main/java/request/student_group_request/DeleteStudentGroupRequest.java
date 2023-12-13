package request.student_group_request;

import java.beans.ConstructorProperties;

public class DeleteStudentGroupRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public DeleteStudentGroupRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
