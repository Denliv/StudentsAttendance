package response.student_group_response;

public class GetStudentGroupByIdResponse {
    private final long id;
    private final String name;

    public GetStudentGroupByIdResponse(long id, String name) {
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
