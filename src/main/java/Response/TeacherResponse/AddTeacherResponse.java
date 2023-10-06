package Response.TeacherResponse;

public class AddTeacherResponse {
    private final Long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;

    public AddTeacherResponse(Long id, String lastName, String firstName, String middleName) {
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
