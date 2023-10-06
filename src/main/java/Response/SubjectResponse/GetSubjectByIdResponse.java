package Response.SubjectResponse;

public class GetSubjectByIdResponse {
    private final long id;
    private final String name;

    public GetSubjectByIdResponse(long id, String name) {
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
