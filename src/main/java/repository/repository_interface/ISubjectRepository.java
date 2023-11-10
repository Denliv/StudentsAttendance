package repository.repository_interface;

import entity.Subject;

public interface ISubjectRepository {
    long add(Subject group);

    void edit(long id, Subject group);

    void delete(long id);

    Subject get(long id);
}
