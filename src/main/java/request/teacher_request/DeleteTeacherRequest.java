package request.teacher_request;

import java.beans.ConstructorProperties;

public class DeleteTeacherRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public DeleteTeacherRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
