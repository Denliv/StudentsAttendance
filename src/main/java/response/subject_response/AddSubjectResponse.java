package response.subject_response;

public class AddSubjectResponse {
    private final long id;
    private final String name;

    public AddSubjectResponse(long id, String name) {
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
