package request.teacher_request;

import java.beans.ConstructorProperties;

public class GetTeacherByIdRequest {
    private final long id;

    @ConstructorProperties({"id"})
    public GetTeacherByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
