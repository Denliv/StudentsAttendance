package repository.repository_interface;

import entity.StudentGroup;

public interface IStudentGroupRepository {
    long add(StudentGroup group);
    void edit(long id, StudentGroup group);
    void delete(long id);
    StudentGroup get(long id);
}
