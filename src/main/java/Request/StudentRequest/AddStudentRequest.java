package Request.StudentRequest;

import Entity.StudentStatus;

public class AddStudentRequest {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final StudentStatus status;
    private final long groupId;

    public AddStudentRequest(String lastName, String firstName, String middleName, StudentStatus status, long group) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
        this.groupId = group;
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
