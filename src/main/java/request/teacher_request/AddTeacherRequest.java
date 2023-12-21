package request.teacher_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class AddTeacherRequest {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    @ConstructorProperties({"lastName", "firstName", "middleName"})
    public AddTeacherRequest(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
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
        AddTeacherRequest that = (AddTeacherRequest) o;
        return Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName);
    }
}
