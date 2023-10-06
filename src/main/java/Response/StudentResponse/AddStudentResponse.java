package Response.StudentResponse;

import Entity.StudentStatus;

public class AddStudentResponse {
    private final long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final StudentStatus status;
    private final String groupName;

    public AddStudentResponse(long id, String lastName, String firstName, String middleName, StudentStatus status, String groupName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
        this.groupName = groupName;
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

    public String getGroupName() {
        return groupName;
    }
}
