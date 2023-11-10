package repository.repository_interface;

import entity.AttendanceList;
import entity.Student;

import java.util.List;

public interface IAttendanceListRepository {

    void addByLessonId(long lessonId, List<Student> list);

    void editByLessonId(long lessonId, AttendanceList list);

    AttendanceList getByLessonId(long lessonId);

    void deleteByLessonId(long lessonId);
}
