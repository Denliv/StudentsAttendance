package response.student_response;

import entity.StudentStatus;

public class AddStudentResponse {
    private final long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final StudentStatus status;
    private final long groupId;

    public AddStudentResponse(long id, String lastName, String firstName, String middleName, StudentStatus status, long groupId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
        this.groupId = groupId;
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
