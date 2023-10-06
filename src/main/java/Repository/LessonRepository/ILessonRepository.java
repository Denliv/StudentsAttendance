package Repository.LessonRepository;

import Entity.Lesson;

import java.util.List;

public interface ILessonRepository {
    Long add(Lesson lesson);
    Long edit(Lesson lesson);
    Lesson delete(long id);
    Lesson get(long id);
    List<Lesson> getAll();
}
