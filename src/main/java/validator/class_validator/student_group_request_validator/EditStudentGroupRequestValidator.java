package validator.class_validator.student_group_request_validator;

import request.student_group_request.EditStudentGroupRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.NameValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentGroupRequestValidator implements IClassValidator<EditStudentGroupRequest> {
    private final NameValidator nameValidator;
    private final IdValidator idValidator;

    public EditStudentGroupRequestValidator(NameValidator nameValidator, IdValidator idValidator) {
        this.nameValidator = nameValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(EditStudentGroupRequest request) {
        var maxLen = 100;
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        nameValidator.isNotNullOrEmptyAndLessThanMaxLen(request.getName(), maxLen, list, "Name");
        return list;
    }
}
