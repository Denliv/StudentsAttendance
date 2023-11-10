package repository.repository_interface;

import entity.Student;
import exception.repository_exception.NotFoundRepository;

import java.util.Collection;

public interface IStudentRepository {
    long add(Student group);

    void edit(long id, Student group) throws NotFoundRepository;

    void delete(long id) throws NotFoundRepository;

    Student getById(long id) throws NotFoundRepository;

    Collection<Student> getByGroupId(long id);
}
