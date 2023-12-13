package request.student_group_request;

import java.beans.ConstructorProperties;

public class AddStudentGroupRequest {
    private final String name;

    @ConstructorProperties({"name"})
    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
