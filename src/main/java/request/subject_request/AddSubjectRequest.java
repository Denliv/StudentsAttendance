package request.subject_request;

import java.beans.ConstructorProperties;

public class AddSubjectRequest {
    private final String name;

    @ConstructorProperties({"name"})
    public AddSubjectRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
