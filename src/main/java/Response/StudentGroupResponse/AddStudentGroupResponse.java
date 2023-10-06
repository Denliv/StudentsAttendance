package Response.StudentGroupResponse;

public class AddStudentGroupResponse {

    private final long id;
    private final String name;

    public AddStudentGroupResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
