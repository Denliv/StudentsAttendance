package service.service_realization;

import entity.StudentGroup;
import exception.repository_exception.NotFoundRepository;
import exception.service_exception.NotFoundService;
import repository.repository_realization.StudentGroupRepository;
import request.student_group_request.AddStudentGroupRequest;
import request.student_group_request.DeleteStudentGroupRequest;
import request.student_group_request.EditStudentGroupRequest;
import request.student_group_request.GetStudentGroupByIdRequest;
import response.student_group_response.AddStudentGroupResponse;
import response.student_group_response.GetStudentGroupByIdResponse;
import service.service_interface.IStudentGroupService;

public class StudentGroupService implements IStudentGroupService {
    private final StudentGroupRepository groupRepository;

    public StudentGroupService(StudentGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public AddStudentGroupResponse add(AddStudentGroupRequest request) {
        var group = new StudentGroup(null, request.getName());
        var id = groupRepository.add(group);
        return new AddStudentGroupResponse(id, group.getName());
    }

    @Override
    public void delete(DeleteStudentGroupRequest request) throws NotFoundService {
        try {
            groupRepository.delete(request.getId());
        } catch (NotFoundRepository ex) {
            throw new NotFoundService();
        }
    }

    @Override
    public void edit(EditStudentGroupRequest request) throws NotFoundService {
        try {
            var group = new StudentGroup(null, request.getName());
            groupRepository.edit(request.getId(), group);
        } catch (NotFoundRepository ex) {
            throw new NotFoundService();
        }
    }

    @Override
    public GetStudentGroupByIdResponse getById(GetStudentGroupByIdRequest request) throws NotFoundService {
        try {
            var group = groupRepository.get(request.getId());
            return new GetStudentGroupByIdResponse(group.getId(), group.getName());
        } catch (NotFoundRepository ex) {
            throw new NotFoundService();
        }
    }
}
