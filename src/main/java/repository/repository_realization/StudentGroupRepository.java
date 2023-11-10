package repository.repository_realization;

import entity.Lesson;
import entity.StudentGroup;
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
    public void edit(long id, StudentGroup group) {
        dataBase.studentGroups.put(group.getId(), group);
    }

    @Override
    public void delete(long id) {
        dataBase.studentGroups.remove(id, dataBase.studentGroups.get(id));
    }

    @Override
    public StudentGroup get(long id) {
        return dataBase.studentGroups.get(id);
    }
}
