package repository.repository_realization;

import entity.Student;
import exception.repository_exception.NotFoundRepository;
import repository.repository_interface.IStudentRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentRepository implements IStudentRepository {
    private final DataBase dataBase;

    public StudentRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private long createId() {
        return dataBase.students.keySet().stream().max(Comparator.naturalOrder()).orElse(0L) + 1L;
    }

    @Override
    public long add(Student student) {
        long id = createId();
        var student1 = new Student(id, student.getLastName(), student.getFirstName(), student.getMiddleName(),
                student.getStatus(), student.getGroupId());
        dataBase.students.putIfAbsent(id, student1);
        return id;
    }

    @Override
    public void edit(long id, Student student) throws NotFoundRepository {
        var oldStudent = dataBase.students.get(id);
        if (oldStudent == null) throw new NotFoundRepository();
        dataBase.students.put(id, student);
    }

    @Override
    public void delete(long id) throws NotFoundRepository {
        var student = dataBase.students.get(id);
        if (student == null) throw new NotFoundRepository();
        dataBase.students.remove(id, student);
    }

    @Override
    public Student getById(long id) throws NotFoundRepository {
        var student = dataBase.students.get(id);
        if (student == null) throw new NotFoundRepository();
        return student;
    }

    @Override
    public Collection<Student> getByGroupId(long id) {
        return dataBase.students.entrySet().stream()
                .filter(Objects::nonNull)
                .filter(o -> o.getValue().getGroupId() == id)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
