package response.student_response;

import entity.StudentStatus;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class AddStudentResponse {
    private final long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final StudentStatus status;
    private final long groupId;

    @ConstructorProperties({"id", "lastName", "firstName", "middleName", "status", "groupId"})
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

    @Override
    public String toString() {
        return "AddStudentResponse{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", status=" + status +
                ", groupId=" + groupId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddStudentResponse that = (AddStudentResponse) o;
        return id == that.id && groupId == that.groupId && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, status, groupId);
    }
}
