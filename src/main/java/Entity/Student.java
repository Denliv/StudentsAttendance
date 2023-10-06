package Entity;

import java.util.Objects;

public class Student {
    private final Long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final StudentStatus status;
    private final StudentGroup group;

    public Student(Long id, String lastName, String firstName, String middleName, StudentStatus status, StudentGroup group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
        this.group = group;
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

    public StudentStatus getStatus() {
        return status;
    }

    public StudentGroup getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) && Objects.equals(middleName, student.middleName) && status == student.status && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, status, group);
    }
}
