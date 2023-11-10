package repository.repository_interface;

import entity.Teacher;

public interface ITeacherRepository {
    long add(Teacher group);

    void edit(long id, Teacher group);

    void delete(long id);

    Teacher get(long id);
}
