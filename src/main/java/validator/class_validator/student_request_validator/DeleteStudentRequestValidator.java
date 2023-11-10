package validator.class_validator.student_request_validator;

import request.student_request.DeleteStudentRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.DateValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.ListValidator;
import validator.simple_validator.NameValidator;

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
        if (!idValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
