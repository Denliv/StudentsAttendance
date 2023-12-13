package request.student_request;

import entity.StudentStatus;

import java.beans.ConstructorProperties;

public class EditStudentRequest {
    private final long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final StudentStatus status;
    private final long groupId;

    @ConstructorProperties({"id", "lastName", "firstName", "middleName", "status", "group"})
    public EditStudentRequest(long id, String lastName, String firstName, String middleName, StudentStatus status, long group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
        this.groupId = group;
    }

    public long getId() {
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

    public StudentStatus getStatus() {
        return status;
    }

    public long getGroupId() {
        return groupId;
    }
}
