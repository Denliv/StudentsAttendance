package request.lesson_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class GetLessonsByTeacherRequest {
    private final String startDate;
    private final String endDate;
    private final long teacherId;

    @ConstructorProperties({"startDate", "endDate", "teacherId"})
    public GetLessonsByTeacherRequest(String startDate, String endDate, long teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getTeacherId() {
        return teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonsByTeacherRequest that = (GetLessonsByTeacherRequest) o;
        return teacherId == that.teacherId && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, teacherId);
    }
}
