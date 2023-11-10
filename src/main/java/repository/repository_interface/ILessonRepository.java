package repository.repository_interface;

import entity.Lesson;

import java.util.List;

public interface ILessonRepository {
    long add(Lesson lesson);

    void edit(long id, Lesson lesson);

    void deleteById(long id);

    List<Lesson> deleteByGroupId(long groupId);

    List<Lesson> deleteByTeacherId(long teacherId);

    Lesson getById(long id);

    List<Lesson> getByGroupIdWithDates(String startDate, String endDate, long groupId);

    List<Lesson> getByTeacherIdWithDates(String startDate, String endDate, long teacherId);
}
