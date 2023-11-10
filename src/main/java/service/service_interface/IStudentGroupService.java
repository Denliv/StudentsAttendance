package service.service_interface;

import exception.service_exception.NotFoundService;
import request.student_group_request.AddStudentGroupRequest;
import request.student_group_request.DeleteStudentGroupRequest;
import request.student_group_request.EditStudentGroupRequest;
import request.student_group_request.GetStudentGroupByIdRequest;
import response.student_group_response.AddStudentGroupResponse;
import response.student_group_response.GetStudentGroupByIdResponse;

public interface IStudentGroupService {
    AddStudentGroupResponse add(AddStudentGroupRequest request);
    void delete(DeleteStudentGroupRequest request) throws NotFoundService;
    void edit(EditStudentGroupRequest request) throws NotFoundService;
    GetStudentGroupByIdResponse getById(GetStudentGroupByIdRequest request) throws NotFoundService;
}
