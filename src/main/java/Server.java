import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.*;
import repository.repository_realization.*;
import request.student_group_request.*;
import request.student_request.*;
import response.*;
import service.service_realization.*;
import validator.class_validator.student_group_request_validator.*;
import validator.class_validator.student_request_validator.*;
import validator.simple_validator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Server {
    private Map<String, Function<String, String>> processes;

    private DataBase dataBase;

    private void init() {
        ObjectMapper objectMapper = new ObjectMapper();
        this.processes = new HashMap<>();
        processes.put("addStudent", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.addStudent(objectMapper.readValue(json, AddStudentRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            }
        });
        processes.put("deleteStudent", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.deleteStudent(objectMapper.readValue(json, DeleteStudentRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("editStudent", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.editStudent(objectMapper.readValue(json, EditStudentRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("getStudentById", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.getStudentById(objectMapper.readValue(json, GetStudentByIdRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
        processes.put("getStudentsByGroup", json -> {
            StudentController controller = new StudentController(
                    new AddStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new DeleteStudentRequestValidator(new IdValidator()),
                    new EditStudentRequestValidator(new StatusValidator(), new NameValidator(), new IdValidator()),
                    new GetStudentByIdRequestValidator(new IdValidator()),
                    new GetStudentsByGroupRequestValidator(new IdValidator()),
                    new StudentService(new StudentRepository(dataBase), new StudentGroupRepository(dataBase)));
            try {
                var response = controller.getStudentsByGroup(objectMapper.readValue(json, GetStudentsByGroupRequest.class));
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
                var response = controller.addStudentGroup(objectMapper.readValue(json, AddStudentGroupRequest.class));
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
                var response = controller.deleteStudentGroup(objectMapper.readValue(json, DeleteStudentGroupRequest.class));
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
                var response = controller.editStudentGroup(objectMapper.readValue(json, EditStudentGroupRequest.class));
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
                var response = controller.getStudentGroupById(objectMapper.readValue(json, GetStudentGroupByIdRequest.class));
                return new ObjectMapper().writeValueAsString(response);
            } catch (JsonProcessingException e) {
                return "";
            }
        });
    }

    public Server() {
        this.dataBase = new DataBase();
        init();
    }

    public Server(DataBase dataBase) {
        this.dataBase = dataBase;
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
