package repository.repository_realization;

import entity.StudentGroup;
import exception.repository_exception.NotFoundRepository;
import repository.repository_interface.IStudentGroupRepository;

import java.util.Comparator;

public class StudentGroupRepository implements IStudentGroupRepository {
    private final DataBase dataBase;

    public StudentGroupRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private long createId() {
        return dataBase.studentGroups.keySet().stream().max(Comparator.naturalOrder()).orElse(0L) + 1;
    }

    @Override
    public long add(StudentGroup group) {
        long id = createId();
        var studentGroup = new StudentGroup(id, group.getName());
        dataBase.studentGroups.putIfAbsent(id, studentGroup);
        return id;
    }

    @Override
    public void edit(long id, StudentGroup group) throws NotFoundRepository {
        var oldGroup = dataBase.studentGroups.get(id);
        if (oldGroup == null) throw new NotFoundRepository();
        dataBase.studentGroups.put(id, group);
    }

    @Override
    public void delete(long id) throws NotFoundRepository {
        var group = dataBase.studentGroups.get(id);
        if (group == null) throw new NotFoundRepository();
        dataBase.studentGroups.remove(id, group);
    }

    @Override
    public StudentGroup get(long id) throws NotFoundRepository {
        var group = dataBase.studentGroups.get(id);
        if (group == null) throw new NotFoundRepository();
        return group;
    }
}
