package request.teacher_request;

import java.beans.ConstructorProperties;

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
}
