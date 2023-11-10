package service.service_realization;

import entity.Student;
import exception.repository_exception.NotFoundRepository;
import exception.service_exception.NotFoundService;
import repository.repository_realization.StudentRepository;
import request.student_request.*;
import response.student_response.AddStudentResponse;
import response.student_response.GetStudentByIdResponse;
import service.service_interface.IStudentService;

import java.util.Collection;

public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public AddStudentResponse add(AddStudentRequest request) {
        var student = new Student(null, request.getLastName(), request.getFirstName(), request.getMiddleName(),
                request.getStatus(), request.getGroupId());
        var id = studentRepository.add(student);
        return new AddStudentResponse(id, student.getLastName(), student.getFirstName(), student.getMiddleName(),
                student.getStatus(), student.getGroupId());
    }

    @Override
    public void delete(DeleteStudentRequest request) throws NotFoundService {
        try {
            studentRepository.delete(request.getId());
        } catch (NotFoundRepository ex) {
            throw new NotFoundService();
        }
    }

    @Override
    public void edit(EditStudentRequest request) throws NotFoundService {
        try {
            var student = new Student(null, request.getLastName(), request.getFirstName(), request.getMiddleName(),
                    request.getStatus(), request.getGroupId());
            studentRepository.edit(request.getId(), student);
        } catch (NotFoundRepository ex) {
            throw new NotFoundService();
        }
    }

    @Override
    public GetStudentByIdResponse getById(GetStudentByIdRequest request) throws NotFoundService {
        try {
            var student = studentRepository.getById(request.getId());
            return new GetStudentByIdResponse(student.getId(), student.getLastName(), student.getFirstName(), student.getMiddleName(),
                    student.getStatus(), student.getGroupId());
        } catch (NotFoundRepository ex) {
            throw new NotFoundService();
        }
    }

    @Override
    public Collection<Student> getByGroupId(GetStudentsByGroupRequest request) {
        return studentRepository.getByGroupId(request.getId());
    }
}
