package Response.SubjectResponse;

public class EditSubjectResponse {
    private final long id;
    private final String name;

    public EditSubjectResponse(long id, String name) {
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
