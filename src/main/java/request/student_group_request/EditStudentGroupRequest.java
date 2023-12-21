package request.student_group_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class EditStudentGroupRequest {
    private final long id;
    private final String name;

    @ConstructorProperties({"id", "name"})
    public EditStudentGroupRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditStudentGroupRequest that = (EditStudentGroupRequest) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
