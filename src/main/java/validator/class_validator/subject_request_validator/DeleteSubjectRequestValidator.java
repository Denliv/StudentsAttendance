package validator.class_validator.subject_request_validator;

import request.subject_request.DeleteSubjectRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.DateValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.ListValidator;
import validator.simple_validator.NameValidator;

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
        if (!idValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
