package controller;

import exception.service_exception.NotFoundService;
import request.student_group_request.AddStudentGroupRequest;
import request.student_group_request.DeleteStudentGroupRequest;
import request.student_group_request.EditStudentGroupRequest;
import request.student_group_request.GetStudentGroupByIdRequest;
import response.AuxiliaryResponseEntity;
import response.ResponseEntity;
import response.student_group_response.AddStudentGroupResponse;
import response.student_group_response.GetStudentGroupByIdResponse;
import service.service_interface.IStudentGroupService;
import validator.class_validator.student_group_request_validator.AddStudentGroupRequestValidator;
import validator.class_validator.student_group_request_validator.DeleteStudentGroupRequestValidator;
import validator.class_validator.student_group_request_validator.EditStudentGroupRequestValidator;
import validator.class_validator.student_group_request_validator.GetStudentGroupByIdRequestValidator;

public class StudentGroupController {
    private final AddStudentGroupRequestValidator addStudentGroupRequestValidator;
    private final DeleteStudentGroupRequestValidator deleteStudentGroupRequestValidator;
    private final EditStudentGroupRequestValidator editStudentGroupRequestValidator;
    private final GetStudentGroupByIdRequestValidator getStudentGroupByIdRequestValidator;
    private final IStudentGroupService studentGroupService;

    public StudentGroupController(AddStudentGroupRequestValidator addStudentGroupRequestValidator,
                                  DeleteStudentGroupRequestValidator deleteStudentGroupRequestValidator,
                                  EditStudentGroupRequestValidator editStudentGroupRequestValidator,
                                  GetStudentGroupByIdRequestValidator getStudentGroupByIdRequestValidator,
                                  IStudentGroupService studentGroupService) {
        this.addStudentGroupRequestValidator = addStudentGroupRequestValidator;
        this.deleteStudentGroupRequestValidator = deleteStudentGroupRequestValidator;
        this.editStudentGroupRequestValidator = editStudentGroupRequestValidator;
        this.getStudentGroupByIdRequestValidator = getStudentGroupByIdRequestValidator;
        this.studentGroupService = studentGroupService;
    }

    public ResponseEntity<AuxiliaryResponseEntity<AddStudentGroupResponse>> addStudentGroup(AddStudentGroupRequest request) {
        try {
            var errorList = addStudentGroupRequestValidator.validate(request);
            if (errorList.size() != 0) {
                return new ResponseEntity<>(new AuxiliaryResponseEntity<>(errorList), (short) 400);
            }
            return new ResponseEntity<>(new AuxiliaryResponseEntity<>(studentGroupService.add(request)), (short) 200);
        } catch (Exception ex) {
            return new ResponseEntity<>((short) 422);
        }
    }

    public ResponseEntity<AuxiliaryResponseEntity<Boolean>> deleteStudentGroup(DeleteStudentGroupRequest request) {
        try {
            var errorList = deleteStudentGroupRequestValidator.validate(request);
            if (errorList.size() != 0) {
                return new ResponseEntity<>(new AuxiliaryResponseEntity<>(errorList), (short) 400);
            }
            studentGroupService.delete(request);
            return new ResponseEntity<>((short) 200);
        } catch (NotFoundService ex) {
            return new ResponseEntity<>((short) 404);
        } catch (Exception ex) {
            return new ResponseEntity<>((short) 422);
        }
    }

    public ResponseEntity<AuxiliaryResponseEntity<Boolean>> editStudentGroup(EditStudentGroupRequest request) {
        try {
            var errorList = editStudentGroupRequestValidator.validate(request);
            if (errorList.size() != 0) {
                return new ResponseEntity<>(new AuxiliaryResponseEntity<>(errorList), (short) 400);
            }
            studentGroupService.edit(request);
            return new ResponseEntity<>((short) 200);
        } catch (NotFoundService ex) {
            return new ResponseEntity<>((short) 404);
        } catch (Exception ex) {
            return new ResponseEntity<>((short) 422);
        }
    }

    public ResponseEntity<AuxiliaryResponseEntity<GetStudentGroupByIdResponse>> getStudentGroupById(GetStudentGroupByIdRequest request) {
        try {
            var errorList = getStudentGroupByIdRequestValidator.validate(request);
            if (errorList.size() != 0) {
                return new ResponseEntity<>(new AuxiliaryResponseEntity<>(errorList), (short) 400);
            }
            return new ResponseEntity<>(new AuxiliaryResponseEntity<>(studentGroupService.getById(request)), (short) 200);
        } catch (NotFoundService ex) {
            return new ResponseEntity<>((short) 404);
        } catch (Exception ex) {
            return new ResponseEntity<>((short) 422);
        }
    }
}
