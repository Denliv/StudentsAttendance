package service.service_interface;

import entity.Student;
import exception.service_exception.NotFoundService;
import request.student_request.*;
import response.student_response.AddStudentResponse;
import response.student_response.GetStudentByIdResponse;

import java.util.Collection;

public interface IStudentService {
    AddStudentResponse add(AddStudentRequest request);

    void delete(DeleteStudentRequest request) throws NotFoundService;

    void edit(EditStudentRequest request) throws NotFoundService;

    GetStudentByIdResponse getById(GetStudentByIdRequest request) throws NotFoundService;

    Collection<Student> getByGroupId(GetStudentsByGroupRequest request);
}
