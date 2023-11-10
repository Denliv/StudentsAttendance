package controller;

import entity.Student;
import exception.service_exception.NotFoundService;
import request.student_request.*;
import response.AuxiliaryResponseEntity;
import response.ResponseEntity;
import response.student_response.AddStudentResponse;
import response.student_response.GetStudentByIdResponse;
import service.service_interface.IStudentService;
import validator.class_validator.student_request_validator.*;

import java.util.Collection;

public class StudentController {
    private final AddStudentRequestValidator addStudentRequestValidator;
    private final DeleteStudentRequestValidator deleteStudentRequestValidator;
    private final EditStudentRequestValidator editStudentRequestValidator;
    private final GetStudentByIdRequestValidator getStudentByIdRequestValidator;
    private final GetStudentsByGroupRequestValidator getStudentsByGroupRequestValidator;
    private final IStudentService studentService;

    public StudentController(AddStudentRequestValidator addStudentRequestValidator,
                             DeleteStudentRequestValidator deleteStudentRequestValidator,
                             EditStudentRequestValidator editStudentRequestValidator,
                             GetStudentByIdRequestValidator getStudentByIdRequestValidator,
                             GetStudentsByGroupRequestValidator getStudentsByGroupRequestValidator,
                             IStudentService studentService) {
        this.addStudentRequestValidator = addStudentRequestValidator;
        this.deleteStudentRequestValidator = deleteStudentRequestValidator;
        this.editStudentRequestValidator = editStudentRequestValidator;
        this.getStudentByIdRequestValidator = getStudentByIdRequestValidator;
        this.getStudentsByGroupRequestValidator = getStudentsByGroupRequestValidator;
        this.studentService = studentService;
    }

    public ResponseEntity<AuxiliaryResponseEntity<AddStudentResponse>> addStudent(AddStudentRequest request) {
        try {
            var errorList = addStudentRequestValidator.validate(request);
            if (errorList.size() != 0) {
                return new ResponseEntity<>(new AuxiliaryResponseEntity<>(errorList), (short) 400);
            }
            return new ResponseEntity<>(new AuxiliaryResponseEntity<>(studentService.add(request)), (short) 200);
        } catch (Exception ex) {
            return new ResponseEntity<>((short) 422);
        }
    }

    public ResponseEntity<AuxiliaryResponseEntity<Boolean>> deleteStudent(DeleteStudentRequest request) {
        try {
            var errorList = deleteStudentRequestValidator.validate(request);
            if (errorList.size() != 0) {
                return new ResponseEntity<>(new AuxiliaryResponseEntity<>(errorList), (short) 400);
            }
            studentService.delete(request);
            return new ResponseEntity<>((short) 200);
        } catch (NotFoundService ex) {
            return new ResponseEntity<>((short) 404);
        } catch (Exception ex) {
            return new ResponseEntity<>((short) 422);
        }
    }

    public ResponseEntity<AuxiliaryResponseEntity<Boolean>> editStudent(EditStudentRequest request) {
        try {
            var errorList = editStudentRequestValidator.validate(request);
            if (errorList.size() != 0) {
                return new ResponseEntity<>(new AuxiliaryResponseEntity<>(errorList), (short) 400);
            }
            studentService.edit(request);
            return new ResponseEntity<>((short) 200);
        } catch (NotFoundService ex) {
            return new ResponseEntity<>((short) 404);
        } catch (Exception ex) {
            return new ResponseEntity<>((short) 422);
        }
    }

    public ResponseEntity<AuxiliaryResponseEntity<GetStudentByIdResponse>> getStudentById(GetStudentByIdRequest request) {
        try {
            var errorList = getStudentByIdRequestValidator.validate(request);
            if (errorList.size() != 0) {
                return new ResponseEntity<>(new AuxiliaryResponseEntity<>(errorList), (short) 400);
            }
            return new ResponseEntity<>(new AuxiliaryResponseEntity<>(studentService.getById(request)), (short) 200);
        } catch (NotFoundService ex) {
            return new ResponseEntity<>((short) 404);
        } catch (Exception ex) {
            return new ResponseEntity<>((short) 422);
        }
    }

    public ResponseEntity<AuxiliaryResponseEntity<Collection<Student>>> getStudentsByGroup(GetStudentsByGroupRequest request) {
        try {
            var errorList = getStudentsByGroupRequestValidator.validate(request);
            if (errorList.size() != 0) {
                return new ResponseEntity<>(new AuxiliaryResponseEntity<>(errorList), (short) 400);
            }
            return new ResponseEntity<>(new AuxiliaryResponseEntity<>(studentService.getByGroupId(request)), (short) 200);
        } catch (Exception ex) {
            return new ResponseEntity<>((short) 422);
        }
    }
}
