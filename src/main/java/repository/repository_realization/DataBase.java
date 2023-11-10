package repository.repository_realization;

import entity.*;

import java.util.Map;

public class DataBase {
    public Map<Long, Lesson> lessons;
    public Map<Long, AttendanceList> attendanceLists;
    public Map<Long, StudentGroup> studentGroups;
    public Map<Long, Student> students;
    public Map<Long, Subject> subjects;
    public Map<Long, Teacher> teachers;

}
