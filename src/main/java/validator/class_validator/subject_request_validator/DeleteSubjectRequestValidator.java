package validator.class_validator.subject_request_validator;

import request.subject_request.DeleteSubjectRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteSubjectRequestValidator implements IClassValidator<DeleteSubjectRequest> {
    private final IdValidator idValidator;

    public DeleteSubjectRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(DeleteSubjectRequest request) {
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        return list;
    }
}
