package entity;

import java.util.Objects;

public class Lesson {
    private final Long id;
    private final Subject subject;
    private final String date;
    private final int number;
    private final Teacher teacher;
    private final StudentGroup group;

    public Lesson(Long id, Subject subject, String date, int number, Teacher teacher, StudentGroup group) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.number = number;
        this.teacher = teacher;
        this.group = group;
    }

    public Lesson(Lesson lesson) {
        this(lesson.getId(), lesson.getSubject(), lesson.getDate(), lesson.getNumber(), lesson.getTeacher(), lesson.getGroup());
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

    public Teacher getTeacher() {
        return teacher;
    }

    public StudentGroup getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return number == lesson.number && Objects.equals(id, lesson.id) && Objects.equals(subject, lesson.subject) && Objects.equals(date, lesson.date) && Objects.equals(teacher, lesson.teacher) && Objects.equals(group, lesson.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, date, number, teacher, group);
    }
}
