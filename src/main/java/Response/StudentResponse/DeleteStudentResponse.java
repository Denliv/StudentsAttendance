package Response.StudentResponse;

import Entity.StudentStatus;

public class DeleteStudentResponse {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final StudentStatus status;
    private final String groupName;

    public DeleteStudentResponse(String lastName, String firstName, String middleName, StudentStatus status, String groupName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
        this.groupName = groupName;
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
