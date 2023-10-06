package Response.LessonResponse;

public class AddLessonResponse {
    private final long id;
    private final String subjectName;
    private final String date;
    private final int number;
    private final String teacherLastName;
    private final String teacherFirstName;
    private final String teacherMiddleName;
    private final String groupName;

    public AddLessonResponse(long id, String subjectName, String date, int number, String teacherLastName,
                             String teacherFirstName, String teacherMiddleName, String groupName) {
        this.id = id;
        this.subjectName = subjectName;
        this.date = date;
        this.number = number;
        this.teacherLastName = teacherLastName;
        this.teacherFirstName = teacherFirstName;
        this.teacherMiddleName = teacherMiddleName;
        this.groupName = groupName;
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

    public String getGroupName() {
        return groupName;
    }
}
