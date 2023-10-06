package Response.TeacherResponse;

public class DeleteTeacherResponse {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    public DeleteTeacherResponse(Long id, String lastName, String firstName, String middleName) {
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
