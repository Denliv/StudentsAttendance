package repository.repository_realization;

import entity.Lesson;
import repository.repository_interface.ILessonRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LessonRepository implements ILessonRepository {
    private final DataBase dataBase;

    public LessonRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private long createId() {
        return dataBase.lessons.keySet().stream().max(Comparator.naturalOrder()).orElse(0L) + 1;
    }

    @Override
    public long add(Lesson lesson) {
        long id = createId();
        var objectLesson = new Lesson(id, lesson.getSubject(), lesson.getDate(), lesson.getNumber(), lesson.getTeacherId(), lesson.getGroupId());
        dataBase.lessons.putIfAbsent(id, objectLesson);
        return id;
    }

    @Override
    public void edit(long id, Lesson lesson) {
        dataBase.lessons.put(id, lesson);
    }

    @Override
    public void deleteById(long id) {
        dataBase.lessons.remove(id, dataBase.lessons.get(id));
    }

    @Override
    public List<Lesson> deleteByGroupId(long groupId) {
        var list = new ArrayList<Lesson>();
        for (var i : dataBase.lessons.entrySet()) {
            if (i.getValue().getGroupId() == groupId)
                list.add(i.getValue());
        }
        return list;
    }

    @Override
    public List<Lesson> deleteByTeacherId(long teacherId) {
        var list = new ArrayList<Lesson>();
        for (var i : dataBase.lessons.entrySet()) {
            if (i.getValue().getTeacherId() == teacherId)
                list.add(i.getValue());
        }
        return list;
    }

    @Override
    public Lesson getById(long id) {
        return dataBase.lessons.get(id);
    }

    @Override
    public List<Lesson> getByGroupIdWithDates(String startDate, String endDate, long groupId) {
        var list = new ArrayList<Lesson>();
        for (var i : dataBase.lessons.entrySet()) {
            var temp = i.getValue();
            if (temp.getGroupId() == groupId
                    && temp.getDate().compareTo(startDate) > 0
                    && temp.getDate().compareTo(endDate) < 0)
                list.add(i.getValue());
        }
        return list;
    }

    @Override
    public List<Lesson> getByTeacherIdWithDates(String startDate, String endDate, long teacherId) {
        var list = new ArrayList<Lesson>();
        for (var i : dataBase.lessons.entrySet()) {
            var temp = i.getValue();
            if (temp.getTeacherId() == teacherId
                    && temp.getDate().compareTo(startDate) > 0
                    && temp.getDate().compareTo(endDate) < 0)
                list.add(i.getValue());
        }
        return list;
    }
}
