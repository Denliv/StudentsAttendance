import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.StudentController;
import controller.StudentGroupController;
import repository.repository_realization.DataBase;
import repository.repository_realization.StudentGroupRepository;
import repository.repository_realization.StudentRepository;
import request.student_group_request.AddStudentGroupRequest;
import request.student_group_request.DeleteStudentGroupRequest;
import request.student_group_request.EditStudentGroupRequest;
import request.student_group_request.GetStudentGroupByIdRequest;
import request.student_request.*;
import response.ResponseEntity;
import service.service_realization.StudentGroupService;
import service.service_realization.StudentService;
import validator.class_validator.student_group_request_validator.AddStudentGroupRequestValidator;
import validator.class_validator.student_group_request_validator.DeleteStudentGroupRequestValidator;
import validator.class_validator.student_group_request_validator.EditStudentGroupRequestValidator;
import validator.class_validator.student_group_request_validator.GetStudentGroupByIdRequestValidator;
import validator.class_validator.student_request_validator.*;
import validator.simple_validator.IdValidator;
import validator.simple_validator.NameValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Server {
    private Map<String, Function<String, String>> processes;

    private DataBase dataBase;

    private void init() {
        this.processes = new HashMap<>();
        this.dataBase = new DataBase();
        processes.put("addStudent", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.addStudent(new ObjectMapper().readValue(json, AddStudentRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            }
        });
        processes.put("deleteStudent", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.deleteStudent(new ObjectMapper().readValue(json, DeleteStudentRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("editStudent", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.editStudent(new ObjectMapper().readValue(json, EditStudentRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("getStudentById", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.getStudentById(new ObjectMapper().readValue(json, GetStudentByIdRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("getStudentsByGroup", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.getStudentsByGroup(new ObjectMapper().readValue(json, GetStudentsByGroupRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("addStudentGroup", json -> {
            StudentGroupController controller = new StudentGroupController(
                    new AddStudentGroupRequestValidator(new NameValidator()),
                    new DeleteStudentGroupRequestValidator(new IdValidator()),
                    new EditStudentGroupRequestValidator(new NameValidator(), new IdValidator()),
                    new GetStudentGroupByIdRequestValidator(new IdValidator()),
                    new StudentGroupService(new StudentGroupRepository(dataBase)));
            try {
                var response = controller.addStudentGroup(new ObjectMapper().readValue(json, AddStudentGroupRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("deleteStudentGroup", json -> {
            StudentGroupController controller = new StudentGroupController(
                    new AddStudentGroupRequestValidator(new NameValidator()),
                    new DeleteStudentGroupRequestValidator(new IdValidator()),
                    new EditStudentGroupRequestValidator(new NameValidator(), new IdValidator()),
                    new GetStudentGroupByIdRequestValidator(new IdValidator()),
                    new StudentGroupService(new StudentGroupRepository(dataBase)));
            try {
                var response = controller.deleteStudentGroup(new ObjectMapper().readValue(json, DeleteStudentGroupRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("editStudentGroup", json -> {
            StudentGroupController controller = new StudentGroupController(
                    new AddStudentGroupRequestValidator(new NameValidator()),
                    new DeleteStudentGroupRequestValidator(new IdValidator()),
                    new EditStudentGroupRequestValidator(new NameValidator(), new IdValidator()),
                    new GetStudentGroupByIdRequestValidator(new IdValidator()),
                    new StudentGroupService(new StudentGroupRepository(dataBase)));
            try {
                var response = controller.editStudentGroup(new ObjectMapper().readValue(json, EditStudentGroupRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("getStudentGroupById", json -> {
            StudentGroupController controller = new StudentGroupController(
                    new AddStudentGroupRequestValidator(new NameValidator()),
                    new DeleteStudentGroupRequestValidator(new IdValidator()),
                    new EditStudentGroupRequestValidator(new NameValidator(), new IdValidator()),
                    new GetStudentGroupByIdRequestValidator(new IdValidator()),
                    new StudentGroupService(new StudentGroupRepository(dataBase)));
            try {
                var response = controller.getStudentGroupById(new ObjectMapper().readValue(json, GetStudentGroupByIdRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
    }

    public Server() {
        init();
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public String accept(String endPoint, String jsonRequest) throws JsonProcessingException {
        try {
            return processes.get(endPoint).apply(jsonRequest);
        } catch (IllegalArgumentException ex) {
            return new ObjectMapper().writeValueAsString(new ResponseEntity<>((short) 400));
        }
    }
}
