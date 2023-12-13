package request.teacher_request;

import java.beans.ConstructorProperties;

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
}
