package request.lesson_request;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

public class AddLessonRequest {
    private final long subjectId;
    private final String date;
    private final int number;
    private final long teacherId;
    private final long groupId;
    private final List<Long> attendanceList;

    @ConstructorProperties({"subjectId", "date", "number", "teacherId", "groupId", "attendanceList"})
    public AddLessonRequest(long subjectId, String date, int number, long teacherId, long groupId, List<Long> attendanceList) {
        this.subjectId = subjectId;
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.attendanceList = new ArrayList<>(attendanceList.size());
        this.attendanceList.addAll(attendanceList);
    }

    public long getSubjectId() {
        return subjectId;
    }

    public String getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public long getGroupId() {
        return groupId;
    }

    public List<Long> getAttendanceList() {
        return attendanceList;
    }
}
