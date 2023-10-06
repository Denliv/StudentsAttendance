package Request.StudentGroupRequest;

public class AddStudentGroupRequest {
    private final String name;

    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
