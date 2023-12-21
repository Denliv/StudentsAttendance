import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.*;
import org.junit.Test;
import request.student_request.*;
import response.*;
import response.student_response.*;

import static org.junit.Assert.assertEquals;

public class ServerTest {
    private final Server server = new Server();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void acceptTest_AddStudent_Valid() throws JsonProcessingException {
        //Arrange
        String lastName = "Ivanov";
        String firstName = "Ivan";
        String middleName = "Ivan";
        StudentStatus status = StudentStatus.Studying;
        long groupId = 101L;

        //Act - Adding New Student
        AddStudentRequest addStudentRequest = new AddStudentRequest(lastName, firstName, middleName, status, groupId);
        String jsonAddStudentRequest = objectMapper.writeValueAsString(addStudentRequest);
        var addStudentAnswer = server.accept("addStudent", jsonAddStudentRequest);
        var addStudentResponse =
                objectMapper.readValue(addStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<AddStudentResponse>>>() {});

        //Check - Successfully Added
        assertEquals(200, addStudentResponse.getStatus());

        //Arrange - Get Added Student Id
        var id = objectMapper
                .readValue(addStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<AddStudentResponse>>>() {})
                .getResponse().getResponse().getId();

        //Act - Get Added Student By ID
        GetStudentByIdRequest getStudentByIdRequest = new GetStudentByIdRequest(id);
        String jsonGetStudentRequest = objectMapper.writeValueAsString(getStudentByIdRequest);
        var getStudentAnswer = server.accept("getStudentById", jsonGetStudentRequest);
        var getStudentResponse =
                objectMapper.readValue(getStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<GetStudentByIdResponse>>>() {});

        //Check - Get The Same Student That Was Added
        assertEquals(new GetStudentByIdResponse(id, lastName, firstName, middleName, status, groupId),
                getStudentResponse.getResponse().getResponse());
    }

    @Test
    public void acceptTest_EditStudent_Valid() throws JsonProcessingException {
        //Arrange
        String lastName = "Ivanov";
        String firstName = "Ivan";
        String middleName = "Ivan";
        StudentStatus status = StudentStatus.Studying;
        long groupId = 101L;
        String changedLastName = "Abc";
        String changedFirstName = "Abc";
        String changedMiddleName = "Abc";
        StudentStatus changedStatus = StudentStatus.Academic_Leave;

        //Act - Adding New Student
        AddStudentRequest addStudentRequest = new AddStudentRequest(lastName, firstName, middleName, status, groupId);
        String jsonAddStudentRequest = objectMapper.writeValueAsString(addStudentRequest);
        var addStudentAnswer = server.accept("addStudent", jsonAddStudentRequest);

        //Arrange - Get Added Student's Id
        var id = objectMapper
                .readValue(addStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<AddStudentResponse>>>() {})
                .getResponse().getResponse().getId();

        //Act - Editing Student
        EditStudentRequest editStudentRequest = new EditStudentRequest(
                id, changedLastName, changedFirstName, changedMiddleName, changedStatus, groupId);
        String jsonEditStudentRequest = objectMapper.writeValueAsString(editStudentRequest);
        var editStudentAnswer = server.accept("editStudent", jsonEditStudentRequest);
        var editStudentResponse =
                objectMapper.readValue(editStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<Boolean>>>() {});

        //Check - Successfully Added
        assertEquals(200, editStudentResponse.getStatus());

        //Act - Get Edited Student By ID
        GetStudentByIdRequest getStudentByIdRequest = new GetStudentByIdRequest(id);
        String jsonGetStudentRequest = objectMapper.writeValueAsString(getStudentByIdRequest);
        var getStudentAnswer = server.accept("getStudentById", jsonGetStudentRequest);
        var getStudentResponse =
                objectMapper.readValue(getStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<GetStudentByIdResponse>>>() {});

        //Check - The Student Was Changed
        assertEquals(new GetStudentByIdResponse(id, changedLastName, changedFirstName, changedMiddleName, changedStatus, groupId),
                getStudentResponse.getResponse().getResponse());
    }

    @Test
    public void acceptTest_DeleteStudent_Valid() throws JsonProcessingException {
        //Arrange
        String lastName = "Ivanov";
        String firstName = "Ivan";
        String middleName = "Ivan";
        StudentStatus status = StudentStatus.Studying;
        long groupId = 101L;

        //Act - Adding New Student
        AddStudentRequest addStudentRequest = new AddStudentRequest(lastName, firstName, middleName, status, groupId);
        String jsonAddStudentRequest = objectMapper.writeValueAsString(addStudentRequest);
        var addStudentAnswer = server.accept("addStudent", jsonAddStudentRequest);
        var addStudentResponse =
                objectMapper.readValue(addStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<AddStudentResponse>>>() {});

        //Check - Successfully Added
        assertEquals(200, addStudentResponse.getStatus());

        //Arrange - Get Added Student Id
        var id = objectMapper
                .readValue(addStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<AddStudentResponse>>>() {})
                .getResponse().getResponse().getId();

        //Act - Deleting Student
        DeleteStudentRequest deleteStudentRequest = new DeleteStudentRequest(id);
        String jsonDeleteStudentRequest = objectMapper.writeValueAsString(deleteStudentRequest);
        var deleteStudentAnswer = server.accept("deleteStudent", jsonDeleteStudentRequest);
        var deleteStudentResponse =
                objectMapper.readValue(deleteStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<Boolean>>>() {});

        //Check - Successfully Deleted
        assertEquals(200, deleteStudentResponse.getStatus());

        //Act - Get Deleted Student By ID
        GetStudentByIdRequest getStudentByIdRequest = new GetStudentByIdRequest(id);
        String jsonGetStudentRequest = objectMapper.writeValueAsString(getStudentByIdRequest);
        var getStudentAnswer = server.accept("getStudentById", jsonGetStudentRequest);
        var getStudentResponse =
                objectMapper.readValue(getStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<GetStudentByIdResponse>>>() {});

        //Check - No Such Student
        assertEquals(404, getStudentResponse.getStatus());
    }

    @Test
    public void acceptTest_AddStudent_Invalid() throws JsonProcessingException {
        //Arrange
        String lastName = null;
        String firstName = "Ivan";
        String middleName = "Ivan";
        StudentStatus status = StudentStatus.Studying;
        long groupId = 101L;

        //Act - Adding Invalid Student
        AddStudentRequest addStudentRequest = new AddStudentRequest(lastName, firstName, middleName, status, groupId);
        String jsonAddStudentRequest = objectMapper.writeValueAsString(addStudentRequest);
        var addStudentAnswer = server.accept("addStudent", jsonAddStudentRequest);
        var addStudentResponse =
                objectMapper.readValue(addStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<AddStudentResponse>>>() {});

        //Check - Error
        assertEquals(400, addStudentResponse.getStatus());
    }

    @Test
    public void acceptTest_EditStudent_Invalid() throws JsonProcessingException {
        //Arrange
        var id = 1;
        String changedLastName = "Abc";
        String changedFirstName = "Abc";
        String changedMiddleName = "Abc";
        StudentStatus changedStatus = StudentStatus.Academic_Leave;
        long groupId = 101L;

        //Act - Editing Student
        EditStudentRequest editStudentRequest = new EditStudentRequest(
                id, changedLastName, changedFirstName, changedMiddleName, changedStatus, groupId);
        String jsonEditStudentRequest = objectMapper.writeValueAsString(editStudentRequest);
        var editStudentAnswer = server.accept("editStudent", jsonEditStudentRequest);
        var editStudentResponse =
                objectMapper.readValue(editStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<Boolean>>>() {});

        //Check - Error
        assertEquals(404, editStudentResponse.getStatus());
    }

    @Test
    public void acceptTest_DeleteStudent_Invalid() throws JsonProcessingException {
        //Arrange - Set Non Existent ID
        var id = 1;

        //Act - Deleting Student
        DeleteStudentRequest deleteStudentRequest = new DeleteStudentRequest(id);
        String jsonDeleteStudentRequest = objectMapper.writeValueAsString(deleteStudentRequest);
        var deleteStudentAnswer = server.accept("deleteStudent", jsonDeleteStudentRequest);
        var deleteStudentResponse =
                objectMapper.readValue(deleteStudentAnswer, new TypeReference<ResponseEntity<AuxiliaryResponseEntity<Boolean>>>() {});

        //Check - Error
        assertEquals(404, deleteStudentResponse.getStatus());
    }
}