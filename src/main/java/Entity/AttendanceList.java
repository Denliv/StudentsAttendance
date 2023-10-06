package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AttendanceList {
    private final Long id;
    private final Lesson lesson;
    private final List<Student> attendanceList = new ArrayList<>();

    public AttendanceList(Long id, Lesson lesson, List<Student> attendanceList) {
        this.id = id;
        this.lesson = new Lesson(lesson);
        this.attendanceList.addAll(attendanceList);
    }

    public Long getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public List<Student> getAttendanceList() {
        return attendanceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceList that = (AttendanceList) o;
        return Objects.equals(id, that.id) && Objects.equals(lesson, that.lesson) && Objects.equals(attendanceList, that.attendanceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lesson, attendanceList);
    }
}
