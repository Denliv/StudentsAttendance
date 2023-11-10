package repository.repository_interface;

import entity.StudentGroup;
import exception.repository_exception.NotFoundRepository;

public interface IStudentGroupRepository {
    long add(StudentGroup group);
    void edit(long id, StudentGroup group) throws NotFoundRepository;
    void delete(long id) throws NotFoundRepository;
    StudentGroup get(long id) throws NotFoundRepository;
}
