package validator.class_validator.student_request_validator;

import request.student_request.GetStudentByIdRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.DateValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.ListValidator;
import validator.simple_validator.NameValidator;

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
        if (!idValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
