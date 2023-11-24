package repository.repository_realization;

import entity.*;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public Map<Long, Lesson> lessons = new HashMap<>();
    public Map<Long, AttendanceList> attendanceLists = new HashMap<>();
    public Map<Long, StudentGroup> studentGroups = new HashMap<>();
    public Map<Long, Student> students = new HashMap<>();
    public Map<Long, Subject> subjects = new HashMap<>();
    public Map<Long, Teacher> teachers = new HashMap<>();

}
