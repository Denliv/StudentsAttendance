import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.StudentStatus;
import request.student_request.AddStudentRequest;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Server server = new Server();
        AddStudentRequest addStudentRequest = new AddStudentRequest(
                "Ivanov",
                "Ivan",
                "Ivan",
                StudentStatus.Studying,
                101L);
        String jsonAddStudentRequest = new ObjectMapper().writeValueAsString(addStudentRequest);

        var answer = server.accept("addStudent", jsonAddStudentRequest);
//        System.out.println(answer.getStatus());
//        System.out.println(answer.getResponse().getResponse());
    }
}
