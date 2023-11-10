package entity;

import java.util.Objects;

public class Lesson {
    private final Long id;
    private final Subject subject;
    private final String date;
    private final int number;
    private final long teacherId;
    private final long groupId;

    public Lesson(Long id, Subject subject, String date, int number, long teacherId, long groupId) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public Lesson(Lesson lesson) {
        this(lesson.getId(), lesson.getSubject(), lesson.getDate(), lesson.getNumber(), lesson.getTeacherId(), lesson.getGroupId());
    }

    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public long getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return number == lesson.number && teacherId == lesson.teacherId && Objects.equals(id, lesson.id) && Objects.equals(subject, lesson.subject) && Objects.equals(date, lesson.date) && Objects.equals(groupId, lesson.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, date, number, teacherId, groupId);
    }
}
