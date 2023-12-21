package request.teacher_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class EditTeacherRequest {
    private final Long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;

    @ConstructorProperties({"id", "lastName", "firstName", "middleName"})
    public EditTeacherRequest(Long id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditTeacherRequest that = (EditTeacherRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName);
    }
}
