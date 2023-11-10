package repository.repository_realization;

import entity.AttendanceList;
import entity.Student;
import repository.repository_interface.IAttendanceListRepository;

import java.util.List;

public class AttendanceListRepository implements IAttendanceListRepository {
    private final DataBase dataBase;

    public AttendanceListRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void addByLessonId(long lessonId, List<Student> list) {
        var attendanceList = new AttendanceList(lessonId, dataBase.lessons.get(lessonId), list);
        dataBase.attendanceLists.putIfAbsent(lessonId, attendanceList);
    }

    @Override
    public void editByLessonId(long lessonId, AttendanceList list) {
        dataBase.attendanceLists.put(lessonId, list);
    }

    @Override
    public AttendanceList getByLessonId(long lessonId) {
        return dataBase.attendanceLists.get(lessonId);
    }

    @Override
    public void deleteByLessonId(long lessonId) {
        dataBase.attendanceLists.remove(lessonId);
    }
}
