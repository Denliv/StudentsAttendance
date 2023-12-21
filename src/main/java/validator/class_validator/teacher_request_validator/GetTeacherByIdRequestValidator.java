package validator.class_validator.teacher_request_validator;

import request.teacher_request.GetTeacherByIdRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetTeacherByIdRequestValidator implements IClassValidator<GetTeacherByIdRequest> {
    private final IdValidator idValidator;

    public GetTeacherByIdRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetTeacherByIdRequest request) {
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        return list;
    }
}
