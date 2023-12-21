package validator.class_validator.teacher_request_validator;

import request.teacher_request.DeleteTeacherRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteTeacherRequestValidator implements IClassValidator<DeleteTeacherRequest> {
    private final IdValidator idValidator;

    public DeleteTeacherRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(DeleteTeacherRequest request) {
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        return list;
    }
}
