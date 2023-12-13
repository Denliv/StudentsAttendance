import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.StudentStatus;
import repository.repository_realization.DataBase;
import request.student_request.AddStudentRequest;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        DataBase dataBase = new DataBase();
        Server server = new Server(dataBase);
        AddStudentRequest addStudentRequest = new AddStudentRequest(
                "Ivanov",
                "Ivan",
                "Ivan",
                StudentStatus.Studying,
                101L);
        String jsonAddStudentRequest = new ObjectMapper().writeValueAsString(addStudentRequest);

        var answer = server.call("addStudent", jsonAddStudentRequest);
        System.out.println(answer.getStatus());
        System.out.println(answer.getResponse().getResponse());
    }
}
