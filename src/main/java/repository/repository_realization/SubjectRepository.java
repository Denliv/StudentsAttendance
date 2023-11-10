package repository.repository_realization;

import entity.Subject;
import repository.repository_interface.ISubjectRepository;

import java.util.Comparator;

public class SubjectRepository implements ISubjectRepository {
    private final DataBase dataBase;

    public SubjectRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private long createId() {
        return dataBase.subjects.keySet().stream().max(Comparator.naturalOrder()).orElse(0L) + 1L;
    }

    @Override
    public long add(Subject subject) {
        long id = createId();
        var subject1 = new Subject(id, subject.getName());
        dataBase.subjects.putIfAbsent(id, subject1);
        return id;
    }

    @Override
    public void edit(long id, Subject subject) {
        dataBase.subjects.put(id, subject);
    }

    @Override
    public void delete(long id) {
        dataBase.subjects.remove(id, dataBase.subjects.get(id));
    }

    @Override
    public Subject get(long id) {
        return dataBase.subjects.get(id);
    }
}
