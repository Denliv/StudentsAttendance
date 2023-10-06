package Response.StudentGroupResponse;

public class GetStudentGroupByIdResponse {
    private final String name;

    public GetStudentGroupByIdResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
