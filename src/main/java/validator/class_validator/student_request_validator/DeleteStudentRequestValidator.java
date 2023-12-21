package validator.class_validator.student_request_validator;

import request.student_request.DeleteStudentRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentRequestValidator implements IClassValidator<DeleteStudentRequest> {
    private final IdValidator idValidator;

    public DeleteStudentRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(DeleteStudentRequest request) {
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        return list;
    }
}
