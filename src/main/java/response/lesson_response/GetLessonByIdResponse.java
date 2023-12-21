package response.lesson_response;

import entity.Student;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetLessonByIdResponse {
    private final long id;
    private final String subjectName;
    private final String date;
    private final int number;
    private final String teacherLastName;
    private final String teacherFirstName;
    private final String teacherMiddleName;
    private final long groupId;
    private final List<Student> students = new ArrayList<>();

    @ConstructorProperties({"id", "subjectName", "date", "number", "teacherLastName", "teacherFirstName", "teacherMiddleName", "groupId", "list"})
    public GetLessonByIdResponse(long id, String subjectName, String date, int number, String teacherLastName,
                                 String teacherFirstName, String teacherMiddleName, long groupId, List<Student> list) {
        this.id = id;
        this.subjectName = subjectName;
        this.date = date;
        this.number = number;
        this.teacherLastName = teacherLastName;
        this.teacherFirstName = teacherFirstName;
        this.teacherMiddleName = teacherMiddleName;
        this.groupId = groupId;
        students.addAll(list);
    }

    public long getId() {
        return id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public String getTeacherMiddleName() {
        return teacherMiddleName;
    }

    public long getGroupId() {
        return groupId;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonByIdResponse that = (GetLessonByIdResponse) o;
        return id == that.id && number == that.number && groupId == that.groupId && Objects.equals(subjectName, that.subjectName) && Objects.equals(date, that.date) && Objects.equals(teacherLastName, that.teacherLastName) && Objects.equals(teacherFirstName, that.teacherFirstName) && Objects.equals(teacherMiddleName, that.teacherMiddleName) && Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName, date, number, teacherLastName, teacherFirstName, teacherMiddleName, groupId, students);
    }
}
