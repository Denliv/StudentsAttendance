package request.student_group_request;

public class AddStudentGroupRequest {
    private final String name;

    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
