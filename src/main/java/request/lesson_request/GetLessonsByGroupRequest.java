package request.lesson_request;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class GetLessonsByGroupRequest {
    private final String startDate;
    private final String endDate;
    private final long groupId;

    @ConstructorProperties({"startDate", "endDate", "groupId"})
    public GetLessonsByGroupRequest(String startDate, String endDate, long groupId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupId = groupId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonsByGroupRequest that = (GetLessonsByGroupRequest) o;
        return groupId == that.groupId && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, groupId);
    }
}
