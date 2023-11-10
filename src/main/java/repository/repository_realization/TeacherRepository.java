package repository.repository_realization;

import entity.Student;
import entity.Teacher;
import repository.repository_interface.ITeacherRepository;

import java.util.Comparator;

public class TeacherRepository implements ITeacherRepository {
    private final DataBase dataBase;

    public TeacherRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private long createId() {
        return dataBase.teachers.keySet().stream().max(Comparator.naturalOrder()).orElse(0L) + 1L;
    }

    @Override
    public long add(Teacher teacher) {
        long id = createId();
        var teacher1 = new Teacher(id, teacher.getLastName(), teacher.getFirstName(), teacher.getMiddleName());
        dataBase.teachers.putIfAbsent(id, teacher1);
        return id;
    }

    @Override
    public void edit(long id, Teacher teacher) {
        dataBase.teachers.put(teacher.getId(), teacher);
    }

    @Override
    public void delete(long id) {
        dataBase.teachers.remove(id, dataBase.teachers.get(id));
    }

    @Override
    public Teacher get(long id) {
        return dataBase.teachers.get(id);
    }
}
