package validator.class_validator.student_request_validator;

import request.student_request.GetStudentsByGroupRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentsByGroupRequestValidator implements IClassValidator<GetStudentsByGroupRequest> {
    private final IdValidator idValidator;

    public GetStudentsByGroupRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentsByGroupRequest request) {
        var list = new ArrayList<String>();
        if (!idValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
