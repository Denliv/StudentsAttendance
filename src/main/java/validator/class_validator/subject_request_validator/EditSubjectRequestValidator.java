package validator.class_validator.subject_request_validator;

import request.subject_request.EditSubjectRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class EditSubjectRequestValidator implements IClassValidator<EditSubjectRequest> {
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public EditSubjectRequestValidator(NameValidator nameValidator, IdValidator idValidator) {
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(EditSubjectRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        nameValidator.isNotNullOrEmptyAndLessThanMaxLen(request.getName(), maxLen, list, "Name");
        return list;
    }
}
