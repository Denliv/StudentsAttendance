package response.lesson_response;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class AddLessonResponse {
    private final long id;
    private final String subjectName;
    private final String date;
    private final int number;
    private final String teacherLastName;
    private final String teacherFirstName;
    private final String teacherMiddleName;
    private final long groupId;

    @ConstructorProperties({"id", "subjectName", "date", "number", "teacherLastName", "teacherFirstName", "teacherMiddleName", "groupId"})
    public AddLessonResponse(long id, String subjectName, String date, int number, String teacherLastName,
                             String teacherFirstName, String teacherMiddleName, long groupId) {
        this.id = id;
        this.subjectName = subjectName;
        this.date = date;
        this.number = number;
        this.teacherLastName = teacherLastName;
        this.teacherFirstName = teacherFirstName;
        this.teacherMiddleName = teacherMiddleName;
        this.groupId = groupId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddLessonResponse that = (AddLessonResponse) o;
        return id == that.id && number == that.number && groupId == that.groupId && Objects.equals(subjectName, that.subjectName) && Objects.equals(date, that.date) && Objects.equals(teacherLastName, that.teacherLastName) && Objects.equals(teacherFirstName, that.teacherFirstName) && Objects.equals(teacherMiddleName, that.teacherMiddleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName, date, number, teacherLastName, teacherFirstName, teacherMiddleName, groupId);
    }
}
