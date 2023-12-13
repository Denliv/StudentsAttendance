package request.lesson_request;

import java.beans.ConstructorProperties;

public class EditLessonRequest {
    private final long id;
    private final long subjectId;
    private final String date;
    private final int number;
    private final long teacherId;
    private final long groupId;

    @ConstructorProperties({"id", "subjectId", "date", "number", "teacherId", "groupId"})
    public EditLessonRequest(long id, long subjectId, String date, int number, long teacherId, long groupId) {
        this.id = id;
        this.subjectId = subjectId;
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public long getId() {
        return id;
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
}
