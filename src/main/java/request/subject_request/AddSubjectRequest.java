package request.subject_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class AddSubjectRequest {
    private final String name;

    @ConstructorProperties({"name"})
    public AddSubjectRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddSubjectRequest that = (AddSubjectRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
