package validator.class_validator.student_request_validator;

import request.student_request.GetStudentByIdRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByIdRequestValidator implements IClassValidator<GetStudentByIdRequest> {
    private final IdValidator idValidator;

    public GetStudentByIdRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentByIdRequest request) {
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        return list;
    }
}
