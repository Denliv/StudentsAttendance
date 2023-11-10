package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AttendanceList {
    private final Long id;
    private final long lessonId;
    private final List<Student> attendanceList = new ArrayList<>();

    public AttendanceList(Long id, long lessonId, List<Student> attendanceList) {
        this.id = id;
        this.lessonId = lessonId;
        this.attendanceList.addAll(attendanceList);
    }

    public Long getId() {
        return id;
    }

    public long getLessonId() {
        return lessonId;
    }

    public List<Student> getAttendanceList() {
        return attendanceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceList that = (AttendanceList) o;
        return lessonId == that.lessonId && Objects.equals(id, that.id) && Objects.equals(attendanceList, that.attendanceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lessonId, attendanceList);
    }
}
